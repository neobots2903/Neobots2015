package org.usfirst.frc.team2903.robot.commands;

import org.usfirst.frc.team2903.robot.Robot;
import org.usfirst.frc.team2903.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoRecyclingbinLift extends Command {




	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void initialize() {
		SmartDashboard.putString("autoMode","9");
		double autoForwardSpeed = -0.8;
		int autoDuration = 1000;
		long startTime = System.currentTimeMillis();
		long stopTime = startTime;

		
		
		while (stopTime <= (startTime + autoDuration)) {
			Robot.driveSubsystem.drive(0,autoForwardSpeed,0);
			stopTime = System.currentTimeMillis();

		}

		Robot.driveSubsystem.drive(0,0,0);	
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}
