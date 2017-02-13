package org.usfirst.frc.team5554.robot.Commands;

import org.usfirst.frc.team5554.robot.Driver;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoSpin extends Command {

	
	int degrees;
	
    public AutoSpin(int _degrees) {
    	super("Auto Spin");
    	degrees = _degrees;
    }

    @Override
    protected void initialize() {
    	Driver.Spin(degrees);
    	System.out.printf("Spinned %d degrees", degrees);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
