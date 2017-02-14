package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;

public class Climb {
	
	private Victor climber;
	private boolean toClimb;
	
	public Climb(int climberPort)
	{
		climber = new Victor(climberPort);
	}
	
	public void climbing(boolean climbButton) //INFO: First press activates climbing, second press stops climbing.
	{
		if(climbButton && !toClimb)
		{
			toClimb = true;
		}
		else if(climbButton && toClimb)
		{
			toClimb = false;
		}
		
		if(toClimb)
		{
			System.out.println("Climbing"); // Code line for testing
		}	
	}

}
