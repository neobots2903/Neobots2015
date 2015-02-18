package org.usfirst.frc.team2903.robot.commands;

import org.usfirst.frc.team2903.robot.OI;
import org.usfirst.frc.team2903.robot.Robot;

import com.sun.glass.ui.Timer;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Teleop extends Command {

    public Teleop() {
    	requires(Robot.driveSubsystem);
        requires(Robot.elevatorSubsystem);
        requires(Robot.pneumaticsSubsystem);
    }

    protected void initialize() {
    	Robot.elevatorSubsystem.encoder.reset();
    }

   // @SuppressWarnings("deprecation")
	protected void execute() {
    	
		Robot.elevatorSubsystem.moveElevatorUpCheck();
		Robot.elevatorSubsystem.moveElevatorDownCheck();
    	//Robot.driveSubsystem.drive(OI.controller.getRawAxis(0), OI.controller.getRawAxis(2),OI.controller.getRawAxis(1));
    	Robot.driveSubsystem.drive(OI.Joy2.getX(), OI.Joy1.getY(), OI.Joy1.getX());
    	if(OI.controller.getRawButton(5)){
    		Robot.pneumaticsSubsystem.leftarmopen();
    	}if(OI.controller.getRawButton(6)){
    		Robot.pneumaticsSubsystem.rightarmopen();
    	}if(OI.controller.getRawButton(7)){
    		Robot.pneumaticsSubsystem.leftarmclose();
    	}if(OI.controller.getRawButton(8)){
    		Robot.pneumaticsSubsystem.rightarmclose();
    	}
    	//Robot.elevatorSubsystem.elevatorMotor(OI.controller.getRawAxis(1));
    	//if(OI.controller.getRawButton(2)){
    	//Robot.elevatorSubsystem.brakeEnable();
    	//} else if(OI.controller.getRawButton(3)){
        //	Robot.elevatorSubsystem.brakeDisable();
        //}
    	if(OI.controller.getRawButton(2)){
    		Robot.elevatorSubsystem.moveElevatorUp();
    		edu.wpi.first.wpilibj.Timer.delay(.1);
    	} else if(OI.controller.getRawButton(3)){
    		Robot.elevatorSubsystem.moveElevatorDown();
    		edu.wpi.first.wpilibj.Timer.delay(.1);
    	}
    	SmartDashboard.putNumber("Encoder", Robot.elevatorSubsystem.encoder.get());
    	SmartDashboard.putNumber("Tote Height", Robot.elevatorSubsystem.toteHeight);
    	SmartDashboard.putBoolean("Top Limit", Robot.elevatorSubsystem.topLimitAct);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
