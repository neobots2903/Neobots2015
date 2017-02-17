package org.usfirst.frc.team2903.robot.commands;

public class Auto extends AutoBase {

	public void forward() {
		long startTime = System.currentTimeMillis();
		long stopTime = startTime;

		rightFrontMotor1.set(1);
		leftFrontMotor1.set(1);
		leftBackMotor1.set(1);
		rightBackMotor1.set(1);

		while (stopTime <= (startTime + 2000)) {

			stopTime = System.currentTimeMillis();

		}

		rightFrontMotor1.set(0);
		leftFrontMotor1.set(0);
		leftBackMotor1.set(0);
		rightBackMotor1.set(0);
	}

}

//import org.usfirst.frc.team2903.robot.OI;
import org.usfirst.frc.team2903.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Auto extends Command {

	public Auto (){
		requires(Robot.driveSubsystem);
	}
	
	protected void end() {
		
	}

	protected void execute() {
		
	}

	protected void initialize() {
			double autoForwardSpeed = (double) 0.25;
			int autoDuration = 2000;
			long startTime = System.currentTimeMillis();
			long stopTime = startTime;

			Robot.driveSubsystem.drive(0,autoForwardSpeed,0);
			
			while (stopTime <= (startTime + autoDuration)) {

				stopTime = System.currentTimeMillis();

			}

			Robot.driveSubsystem.drive(0,0,0);
			
		}

	protected void interrupted() {
		
	}

	protected boolean isFinished() {
		return false;
	}

}

package org.usfirst.frc.team2903.robot.commands;

//import org.usfirst.frc.team2903.robot.OI;
import org.usfirst.frc.team2903.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Auto extends Command {

	public Auto (){
		requires(Robot.driveSubsystem);
	}
	
	protected void end() {
		
	}

	protected void execute() {
		
		
	}
	/*
	 * 
	 * 
	 */

	protected void initialize() {
		SmartDashboard.putString("autoMode","9");
		double autoForwardSpeed = -0.65;
		int autoDuration = 2500;
		long startTime = System.currentTimeMillis();
		long stopTime = startTime;

		 
		
		while (stopTime <= (startTime + autoDuration)) {
			//Robot.driveSubsystem.drive(0,autoForwardSpeed,0); //drive at speed set above
			Robot.elevatorSubsystem.moveElevatorUp();
			stopTime = System.currentTimeMillis();
			
		}

		Robot.driveSubsystem.drive(0,0,0);	//stop robot 
	}

	protected void interrupted() {
		
	}

	protected boolean isFinished() {
		return false;
	}

}