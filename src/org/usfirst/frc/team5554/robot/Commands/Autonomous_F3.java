package org.usfirst.frc.team5554.robot.Commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_F3 extends CommandGroup {

    public Autonomous_F3() {
    	addSequential(new DriveDistance(RobotMap.DISTANCE_TO_BASELINE_FROM_START + RobotMap.ROBOT_LENGTH));
    	addSequential(new AutoSpin(RobotMap.DEGREES_TO_TURN_FROM_SIDES_TO_SHOOT));
    	addSequential(new AutoShoot());
    }
}
