package org.usfirst.frc.team5554.robot;

import java.util.HashMap;
import java.util.Map;
import org.opencv.core.Scalar;

import edu.wpi.first.wpilibj.Joystick;

public class CameraThread extends Thread
{
	private Joystick joy;
	public boolean toSwitch = false;
	private boolean ignoreButton5 = false;

	private boolean showRec = false;
	
	private int liveCamera = 0;
	
	private Map<String,GuideLines> gls = new HashMap<String,GuideLines>();
	
	public CameraThread(Joystick operator)
	{
		joy = operator;
	}
	
	@Override	
	public void run()
	{		
		CameraHandler cameras = new CameraHandler(RobotMap.NUMBER_OF_CAMERAS,320,240);

		gls.put("Shooter", new GuideLines(0, 319, 0, 240, new Scalar(0,0,255), 2));
		
		VideoBox screen = new VideoBox(320 , 240 , "Live Feed");
				
		while (!Thread.interrupted()) 
		{
			if(toSwitch)
			{
				PickCamera(0);
				
				cameras.SetStreamer(liveCamera);
				
				if(joy.getPOV() == 0)
				{
					if(!(gls.get("Shooter").GetLeftX()+2 >= gls.get("Shooter").GetRightX()))
					{
						gls.get("Shooter").NarrowWidth(1);
					}
				}
				if(joy.getPOV() == 180)
				{
					if(!(gls.get("Shooter").GetLeftX()-2 <= 0))
					{
						gls.get("Shooter").DialateWidth(1);
					}
				}
			
				if(joy.getRawButton(RobotMap.XBOX_JOYSTICK_SHOOTER_DASHBOARD_GUIDELINES) && ignoreButton5 == false)
				{
					ignoreButton5 = true;
				
					if(showRec == false)
					{
						showRec = true;
					}
					else
					{
						showRec = false;
					}
	    		
				}
				else if(!joy.getRawButton(RobotMap.XBOX_JOYSTICK_SHOOTER_DASHBOARD_GUIDELINES))
				{
					ignoreButton5 = false;
				}
				
				if(showRec)
				{
					screen.stream(
							screen.DrawGuideLines(cameras.GetStream(), gls.get("Shooter")));
				}
				else
				{
					screen.stream(cameras.GetStream());
				}

			}
			else
			{
				screen.stream(cameras.GetStream());
			}
			
		}
	}
	
	private void PickCamera(int defaultCamera)
	{
		for(int i = 0 ; i<RobotMap.NUMBER_OF_CAMERAS;i++)
		{
				if(joy.getRawButton(RobotMap.BUTTONS_OF_CAMERAS[i]))
				{
					liveCamera = i;
				}
		}
	}
	
}
