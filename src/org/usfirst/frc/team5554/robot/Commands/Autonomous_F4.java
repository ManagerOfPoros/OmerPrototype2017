package org.usfirst.frc.team5554.robot.Commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_F4 extends CommandGroup {

    public Autonomous_F4() {
    	addSequential(new DriveDistance(RobotMap.DISTANCE_TO_BASELINE_FROM_START + RobotMap.ROBOT_LENGTH + RobotMap.DISTANCE_TO_HOPPER_FROM_BASELINE));
    }
}
