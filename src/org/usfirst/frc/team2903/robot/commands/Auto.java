package org.usfirst.frc.team2903.robot.commands;

import org.usfirst.frc.team2903.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Auto extends Command {

	    public Auto() {
	        requires(Robot.driveSubsystem);
	        requires(Robot.elevatorSubsystem);
	        requires(Robot.pneumaticsSubsystem);
	    }

	    protected void initialize() {
	    }

	    protected void execute() {
	    }

	    protected boolean isFinished() {
	        return false;
	    }

	    protected void end() {
	    }

	    protected void interrupted() {
	    }
	}


