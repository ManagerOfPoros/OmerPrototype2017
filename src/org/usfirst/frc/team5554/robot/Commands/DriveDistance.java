package org.usfirst.frc.team5554.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5554.robot.Driver;

public class DriveDistance extends Command
{
	int valuefromencoder;
	int wantedValue;
	double speed;
	
	public DriveDistance(int _wantedValue)
	{
		super("Drive Distance");
		wantedValue = _wantedValue;
		valuefromencoder = 0;
		speed = 0;
	}
	
	@Override
	public void initialize()
	{		

		while(valuefromencoder != wantedValue)
		{
			Driver.Drive(speed);
		}
		
		
		System.out.println("We drove the distance");
	}
	
	@Override
	public boolean isFinished() 
	{
		
		return true;
	}

}
