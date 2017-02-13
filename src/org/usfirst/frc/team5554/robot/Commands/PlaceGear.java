package org.usfirst.frc.team5554.robot.Commands;

import org.usfirst.frc.team5554.robot.Driver;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PlaceGear extends Command {

    public PlaceGear() {
    	super("Place Gear");
    }

    @Override
    protected void initialize() {
    	System.out.println("The robot is ready to place the gear man!");
    	//Drive and hit the airship,
    	//then wait for the gear to be taken out.
    	System.out.println("The robot is ready to release the gear man!");
    	Driver.ReleaseGear();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
