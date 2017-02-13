package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;

public class Feeder {

	private Victor feeder;
	
	public Feeder(int feederPort)
	{
		feeder = new Victor(feederPort);
	}
	
	public void feed(boolean toFeed)
	{
		if(toFeed)
		{
			feeder.set(0.8);
		}
		else
		{
			feeder.set(0);
		}
	}
	
}
