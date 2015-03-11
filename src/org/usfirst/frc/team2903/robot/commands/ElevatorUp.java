package org.usfirst.frc.team2903.robot.commands;

import org.usfirst.frc.team2903.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorUp extends Command {

	public ElevatorUp() {
		// TODO Auto-generated constructor stub
		requires(Robot.elevatorSubsystem);
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevatorSubsystem.moveElevatorUp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevatorSubsystem.speedControl();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevatorSubsystem.moveElevatorUpCheck();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
