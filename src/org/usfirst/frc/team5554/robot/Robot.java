package org.usfirst.frc.team5554.robot;

import org.usfirst.frc.team5554.robot.Commands.Autonomous_A1;
import org.usfirst.frc.team5554.robot.Commands.Autonomous_A2;
import org.usfirst.frc.team5554.robot.Commands.Autonomous_B;
import org.usfirst.frc.team5554.robot.Commands.Autonomous_C1;
import org.usfirst.frc.team5554.robot.Commands.Autonomous_C2;
import org.usfirst.frc.team5554.robot.Commands.Autonomous_C3;
import org.usfirst.frc.team5554.robot.Commands.Autonomous_C4;
import org.usfirst.frc.team5554.robot.Commands.Autonomous_Empty;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	/****************************************objects**********************************************/
	private Driver driver;
	private Shooter shooter;
	private Feeder feeder;
	@SuppressWarnings("unused")
	private GearHolder gears;
	private Climb climber;
	private CameraThread streamer;
	
	/****************************************Joysticks********************************************/
	private Joystick joy;
	private Joystick xbox;
	
	/****************************************Flags************************************************/
	@SuppressWarnings("unused")
	private boolean ignoreIncreaseSwitch = false;
	@SuppressWarnings("unused")
	private boolean ignoreDecreaseSwitch = false;
	
	/*****************************************Autonomous******************************************/
	Command autonomousCommand;
	SendableChooser<Command> autoChooser;
	
	/*********************************************************************************************/
	
	
	
	@Override
	public void robotInit() 
	{
		/***********************************Declaring Objects***********************************************/
		driver = new Driver(RobotMap.MOTOR_LEFT_ONE , RobotMap.MOTOR_LEFT_TWO, RobotMap.MOTOR_RIGHT_ONE, RobotMap.MOTOR_RIGHT_TWO );
		shooter = new Shooter(RobotMap.MOTOR_SHOOT_ONE,RobotMap.MOTOR_SHOOT_TWO, RobotMap.MOTOR_SCRAMBLE);
		feeder = new Feeder(RobotMap.MOTOR_FEEDER);
		climber = new Climb(RobotMap.MOTOR_CLIMBER);
		//gears = new GearHolder(0,2,4);
		
		//gears.SetLeds(true);
		
		joy = new Joystick(RobotMap.DRIVER_JOYSTICK_PORT);
		xbox = new Joystick(RobotMap.DRIVER_XBOXJOYSTICK_PORT);  
		
		streamer = new CameraThread(joy);
		streamer.start();
		
		/***********************************Autonomous Options***********************************************/
		autoChooser = new SendableChooser<Command>();
		autoChooser.addDefault("Empty", new Autonomous_Empty());
		autoChooser.addObject("A1", new Autonomous_A1(driver));
		autoChooser.addObject("A2", new Autonomous_A2(driver));
		autoChooser.addObject("B", new Autonomous_B(driver));
		autoChooser.addObject("C1", new Autonomous_C1(driver, shooter));
		autoChooser.addObject("C2", new Autonomous_C2(driver));
		autoChooser.addObject("C3", new Autonomous_C3(driver, shooter));
		autoChooser.addObject("C4", new Autonomous_C4(driver));
		SmartDashboard.putData("Autonomous" , autoChooser);
		
		/****************************************************************************************************/
	}

	@Override
	public void autonomousInit() 
	{
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run();
	}
	
	@Override
	public void teleopInit()
	{
		streamer.toSwitch = true;
	}

	@Override
	public void teleopPeriodic() 
	{
		/****************************************** Driving ********************************************/
		driver.Moving(joy.getRawAxis(RobotMap.JOYSTICK_Y_AXIS), joy.getRawAxis(RobotMap.JOYSTICK_Z_AXIS),
				joy.getRawAxis(RobotMap.JOYSTICK_SLIDER_AXIS));
		/****************************************** Shooter ********************************************/
		shooter.shoot(xbox.getRawAxis(RobotMap.XBOX_JOYSTICK_SCRAMBLE_FORWARD));
		shooter.shootReverse(xbox.getRawButton(RobotMap.XBOX_JOYSTICK_SCRAMBLE_BACKWARD));
    	
    	/***************************************** Scramble ********************************************/
    	shooter.scramble(xbox.getRawAxis(RobotMap.XBOX_JOYSTICK_SCRAMBLE_FORWARD));
    	shooter.scrambleReverse(xbox.getRawButton(RobotMap.XBOX_JOYSTICK_SCRAMBLE_BACKWARD));
    	
		/****************************************** Feeder *********************************************/
		feeder.feed(joy.getRawButton(RobotMap.JOYSTICK_FEEDER_BUTTON));
    	
    	/**************************************** Gear Holder ******************************************/
		//gears.isGearIn();
		
		/****************************************** Climbing *******************************************/
		climber.climbing(xbox.getRawButton(RobotMap.XBOX_CLIMB_BUTTON)); //NOTE: Climb is a placeholder
	}
	
	@Override
	public void disabledPeriodic()
	{
		streamer.toSwitch = false;
	}

	@Override
	public void testPeriodic() 
	{
	}
}

