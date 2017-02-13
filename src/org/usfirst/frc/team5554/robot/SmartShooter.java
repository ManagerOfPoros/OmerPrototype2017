package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;

public class SmartShooter extends Thread {

	Encoder Enc;
	int countChange;
	
	/*constant parameters*/
	final double diameterOfShooterWheel = 7.6; //in cm
	final int maxRPM= 2655; // the maximum rpm of the shooter wheel 
	
	
	public SmartShooter()
	{
	//	Enc = new Encoder(RobotMap.ENCODER_SHOOTER_PORT_FIRST, RobotMap.ENCODER_SHOOTER_PORT_SECOND, false, CounterBase.EncodingType.k4X);
	}
	
	@Override
	public void run()  // checks how much the encoder position has changed during 1 seconds.
	{
		while (!Thread.interrupted()){
			Enc.reset();
			int firstCount = Enc.get();
			int secondCount = 0;
			long firstTime = System.currentTimeMillis()/1000;
			long secondTime = 0;
			
			while(secondTime-firstTime<1){
				secondTime = System.currentTimeMillis()/1000;
			}
			
			secondCount = Enc.get();
			countChange = secondCount-firstCount;
		}
	}
	
	/************************i dont know if its accurate*******************************/
	
	/*public void checkCountChange()              //50 times since the roborio does 50 iterations per second
	{
		int counter=0;
		firstCount = Enc.get();
		
		if (counter<50){
		counter++
		}
		
		else{
		secondCount = Enc.get
		countChange =  secondCount-firstCount;
		
		}
	
	*/
	
	public double calcVelocity(double distance){
		/*constants*/
		final double heightOfBoiler = 2.47;
		final double angle = Math.toRadians(75); //THE DEGREES OF THE SHOOTER
		
		distance+=0.5; // so the ball will land in the middle
		
		/*the calculation*/
		double velocitySquared = (5*distance*distance)/((Math.tan(angle)-heightOfBoiler)*Math.cos(angle)*Math.cos(angle));
		double velocity = Math.sqrt(velocitySquared);
		return velocity;
	}
	
	/*public double velocityToSpeed(double velocity)                       // returns the velocity in pwm units from 0-1 
	{
		double maxVelocity = (maxRPM*3.14*diameterOfShooterWheel)/6000;
		double Speed = velocity/maxVelocity;
		
		return Speed;
	 }
	*/
	
	
	public int getCountChange()
	{
		return countChange;
		
		}
	
}
