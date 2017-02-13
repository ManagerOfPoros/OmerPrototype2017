package org.usfirst.frc.team5554.robot.Commands;

import org.usfirst.frc.team5554.robot.Driver;
import org.usfirst.frc.team5554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_C2 extends CommandGroup {

    public Autonomous_C2(Driver driver) {
    	addSequential(new DriveDistance(RobotMap.DISTANCE_TO_BASELINE_FROM_START + RobotMap.ROBOT_LENGTH));
    	addSequential(new AutoSpin(RobotMap.DEGREES_TO_TURN_TO_AIRSHIP));
    	addSequential(new DriveDistance(RobotMap.DISTANCE_TO_AIRSHIP_FROM_BASELINE));
    	addSequential(new PlaceGear());
    }
}
