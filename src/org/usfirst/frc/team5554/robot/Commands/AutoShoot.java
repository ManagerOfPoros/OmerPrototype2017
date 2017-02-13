package org.usfirst.frc.team5554.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;

public class AutoShoot extends Command
{

	public AutoShoot()
	{
		super("Auto Shoot");
	}
	
	@Override
	public void initialize()
	{		
		//AUTO SHOOT
		System.out.println("What a great shot");
	}
	
	@Override
	public boolean isFinished() 
	{
		return true;
	}
}
