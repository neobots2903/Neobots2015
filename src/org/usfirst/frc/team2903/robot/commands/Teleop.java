package org.usfirst.frc.team2903.robot.commands;

import org.usfirst.frc.team2903.robot.OI;
import org.usfirst.frc.team2903.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Teleop extends Command {

    public Teleop() {
    	requires(Robot.driveSubsystem);
        requires(Robot.elevatorSubsystem);
        requires(Robot.pneumaticsSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	//Robot.driveSubsystem.drive(OI.controller.getRawAxis(0), OI.controller.getRawAxis(2),OI.controller.getRawAxis(1));
    	if(OI.controller.getRawButton(5)){
    		Robot.pneumaticsSubsystem.leftarmopen();
    	}if(OI.controller.getRawButton(6)){
    		Robot.pneumaticsSubsystem.rightarmopen();
    	}if(OI.controller.getRawButton(7)){
    		Robot.pneumaticsSubsystem.leftarmclose();
    	}if(OI.controller.getRawButton(8)){
    		Robot.pneumaticsSubsystem.rightarmclose();
    	}
    	Robot.elevatorSubsystem.elevatorMotor(OI.controller.getRawAxis(3));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
