package org.usfirst.frc.team2903.robot.commands;

import org.usfirst.frc.team2903.robot.Robot;
import org.usfirst.frc.team2903.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;

public class AutoRecyclingbinLift extends AutoBase {
	
	public void forward () {
		long startTime = System.currentTimeMillis();
		long stopTime = startTime;
		
		Robot.elevatorSubsystem.moveElevatorUp();
		//Robot.elevatorSubsystem.moveElevatorUp();
		
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
		
		//Robot.elevatorSubsystem.moveElevatorDown();
		Robot.elevatorSubsystem.moveElevatorDown();
		
		Robot.pneumaticsSubsystem.openarms();
	}

}
