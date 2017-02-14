package org.usfirst.frc.team5554.robot;

public class RobotMap {

/*******************Motor Ports**************************************************************************/
    public final static int MOTOR_LEFT_ONE = 0;
    public final static int MOTOR_LEFT_TWO = 1;
    public final static int MOTOR_RIGHT_ONE = 2;
    public final static int MOTOR_RIGHT_TWO = 3;
    public final static int MOTOR_FEEDER = 5;
    public final static int MOTOR_SHOOT_ONE = 8;
    public final static int MOTOR_SHOOT_TWO = 4;
    public final static int MOTOR_SCRAMBLE = 6;
	public final static int MOTOR_CLIMBER = 0; //TODO: Add a real engine port!
    
/*******************Control & Sensor Ports***************************************************************/
    public final static int DRIVER_JOYSTICK_PORT = 0;
    public final static int DRIVER_XBOXJOYSTICK_PORT = 1;
//    public final static int ENCODER_SHOOTER_PORT_FIRST = 2;
//    public final static int ENCODER_SHOOTER_PORT_SECOND = 3;
    
/****************************Buttons for Joysticks*******************************************************/    
    //Joystick Controller
    public final static int JOYSTICK_Y_AXIS = 1; // Forward and backward joystick axis
    public final static int JOYSTICK_Z_AXIS = 2; // Spinning joystick controller axis
    public final static int JOYSTICK_SLIDER_AXIS = 3; // Slider
    public final static int JOYSTICK_FEEDER_BUTTON = 1; // Joystick trigger
    public final static int JOYSTICK_SHOOTERCAM_BUTTON = 2; // Thumb button
    public final static int[] BUTTONS_OF_CAMERAS = {10,11,12}; // Order: Forward Camera, Inside Camera, Shooter Camera
    
    //XBOX Controller
    public final static int XBOX_JOYSTICK_SHOOTER_FORWARD = 3; // RT Axis
    public final static int XBOX_JOYSTICK_SHOOTER_BACKWARD = 6;  // RB Button
    public final static int XBOX_JOYSTICK_SCRAMBLE_FORWARD = 2; // LT Axis
    public final static int XBOX_JOYSTICK_SCRAMBLE_BACKWARD = 5; // LB Button
    public final static int XBOX_JOYSTICK_SHOOTER_DASHBOARD_GUIDELINES = 1; // A Button
    public final static int XBOX_JOYSTICK_FEEDER_DASHBOARD_GUIDELINES = 4; // Y Button
    public final static int XBOX_CLIMB_BUTTON = 8; // Start Button
    public final static int XBOX_EMERGENCY_CLIMB_STOP_BUTTON = 9; // Left Joystick Button
    
/*******************Field & Robot Distances In Centimeters***********************************************/
    public final static int DISTANCE_TO_AIRSHIP_FROM_SIDE = 0; //TODO: Add a real measured value!
    public final static int DISTANCE_TO_BASELINE_FROM_START = 237;
    public final static int DISTANCE_TO_AIRSHIP_FROM_BASELINE = 0; //TODO: Add a real measured value!
    public final static int DISTANCE_TO_HOPPER_FROM_BASELINE = 0; //TODO: Add a real measured value!
    public final static int ROBOT_WIDTH = 101;
    public final static int ROBOT_LENGTH = 91;
    public final static int ROBOT_HEIGHT = 60;
    
/*******************Constant Turning Angles In Degrees***************************************************/
    public final static int DEGREES_TO_TURN_FROM_SIDES_TO_SHOOT = 0; //TODO: Add a real measured value!
    public final static int DEGREES_TO_TURN_TO_AIRSHIP = 0; //TODO: Add a real measured value!
    
    public final static int[] CAMERA_INDEXES = {0,1,2};
    public final static int NUMBER_OF_CAMERAS = 3;
}

