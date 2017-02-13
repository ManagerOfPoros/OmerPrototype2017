package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;

public class Shooter 
{
	private Victor firstShooter;
	//private Victor secondShooter;
	private Victor scrumble;
	//private Ultrasonic ultrasonic;
	//private SmartShooter smartshooter;
	 
	private double Speed = 1;
	
	
	public Shooter(int shooterFirstPort, int shooterSecondPort, int scrumblePort)
	{
		firstShooter = new Victor(shooterFirstPort);
		//secondShooter = new Victor(shooterSecondPort);
		scrumble = new Victor(scrumblePort);
		//smartshooter = new SmartShooter();
	//	smartshooter.start();//start checking the countChange every second
	}
	
	//shooter
	
	
	public void shoot(double toShoot)
	{
		if(toShoot > 0)
		{
			firstShooter.set(Speed);
			//secondShooter.set(-Speed);
		}
		else
		{
			firstShooter.set(0);
			//secondShooter.set(0);
		}	
	}
	
	public void shootReverse(boolean toReverse) {
		
		if(toReverse)
		{
			firstShooter.set(-Speed);
			//secondShooter.set(-Speed);
		}
		else
		{
			firstShooter.set(0);
			//secondShooter.set(0);
		}	
	}

	
	
		/*public void smartShoot(double toShoot)
{
		 we need to know what is the speed needed to shoot and since we know it we know what the countChange needs to be
	
		if(toShoot>0){
		
			Speed = smartshooter.velocityToSpeed(smartshooter.calcVelocity(ultrasonic.getRangeMeters()));
			this.shoot(toShoot);
			
			if(smartshooter.getCountChange()< something){
				Speed+=0.05;
		}
		
	}
	}
	*/
		
	public void scramble(double toScrumble)
	{
		if (toScrumble > 0)
		{
			scrumble.set(-1);
		}
		else
		{
			scrumble.set(0);
		}
	}
	
	public void scrambleReverse(boolean toReverse)
	{
		if (toReverse)
		{
			scrumble.set(1);
		}
		else
		{
			scrumble.set(0);
		}
	}
	
	

	/*methods that benefit us in tests on the shooter*/
	
	public void setSpeed(double Speed)
	{
		this.Speed = Speed;
	}
	
	public double getSpeed()
	{
		return this.Speed;
	}
	
	}
