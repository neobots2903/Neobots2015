package org.usfirst.frc.team2903.robot.commands;

import org.usfirst.frc.team2903.robot.Robot;
import org.usfirst.frc.team2903.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;

public class AutoRecyclingbinLift extends Command {

	public Talon leftFrontMotor1 = new Talon(RobotMap.HDriveM2);
	public Talon rightFrontMotor1 = new Talon(RobotMap.HDriveM3);
	public Talon leftBackMotor1 = new Talon(RobotMap.HDriveM1);
	public Talon rightBackMotor1 = new Talon(RobotMap.HDriveM4);
	public Talon middleMotor1 = new Talon(RobotMap.HDriveM5);
	public RobotDrive hDrive = new RobotDrive(1, 2, 3, 4);

	public void forward() {
		long startTime = System.currentTimeMillis();
		long stopTime = startTime;
		
		Robot.elevatorSubsystem.moveElevatorUp();
		Robot.elevatorSubsystem.moveElevatorUp();
		
		Robot.pneumaticsSubsystem.closearms();

		rightFrontMotor1.set(1);
		leftFrontMotor1.set(1);
		leftBackMotor1.set(1);
		rightBackMotor1.set(1);

		while (stopTime <= (startTime + 5000)) {

			stopTime = System.currentTimeMillis();

		}

		rightFrontMotor1.set(0);
		leftFrontMotor1.set(0);
		leftBackMotor1.set(0);
		rightBackMotor1.set(0);
		
		Robot.elevatorSubsystem.moveElevatorDown();
		Robot.elevatorSubsystem.moveElevatorDown();
		
		Robot.pneumaticsSubsystem.openarms();
	}

	public void drive(double xAxis, double yAxis, double mid) {
		hDrive.arcadeDrive(xAxis, yAxis);
		middleMotor1.set(mid);
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
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
