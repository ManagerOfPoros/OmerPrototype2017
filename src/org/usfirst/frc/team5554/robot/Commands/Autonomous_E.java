package org.usfirst.frc.team5554.robot.Commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_E extends CommandGroup {

    public Autonomous_E() {
    //	addSequential(new DriveDistance(RobotMap.DISTANCE_TO_AIRSHIP_FROM_MIDDLE));
    	addSequential(new PlaceGear());
    }
}
