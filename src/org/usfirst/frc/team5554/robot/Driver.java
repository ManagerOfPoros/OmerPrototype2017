package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;

public class Driver
{
	private Victor left0;
	private Victor left1;
	private Victor right0;
	private Victor right1;
	
	/**
	 * The constructor configurates the motors objects to certain ports
	 * @since 15/1/2017
	 * @param MOTOR_LEFT port for left motor
	 * @param MOTOR_RIGHT port for right motor
	 * Author: Gil Meri
	 */
	public Driver(int motorLeftOne , int motorLeftTwo , int motorRightOne , int motorRightTwo) 
	{
		
		left0 = new Victor(motorLeftOne);
		left1 = new Victor(motorLeftTwo);
		right0 = new Victor(motorRightOne);
		right1 = new Victor(motorRightTwo);
		
	}
	
	/**
	 * This function in charge of the movement of the robot with the joystick
	 * @since 15/1/2017
	 * @param y The value of the joystick's y axis
	 * @param z The value of the joystick's z axis
	 * @param slider The value of the joystick's slider axis
	 * Author: Gil Meri
	 */
	public void Moving (double y, double z, double slider) 
	{
		slider = (-slider+1)/2;
		
		double powerLeft = (y+z) * slider;
		double powerRight = (-y+z) * slider;
		
		if (powerLeft > 1)powerLeft=1;
		if (powerLeft < -1)powerLeft=-1;
		if (powerRight > 1)powerRight=1;
		if (powerRight < -1)powerRight=-1;
		
		this.left0.set(powerLeft);
		this.left1.set(powerLeft);
		this.right0.set(powerRight);
		this.right1.set(powerRight);
	}
	
	public static void Drive(double speed)
	{
		//here it will start the motors for the driver given a speed
		//to drive an exact distance
	}
	
	public static void Spin(double degrees)
	{
		if(degrees > 0){
			//then spin right
		}else if(degrees < 0){
			degrees *= -1;
			//then spin left
		}
	}
	
	public static void ReleaseGear()
	{
		//Drive backwards for a second after 
		//the gear was taken from the robot
	}
		
		
}
