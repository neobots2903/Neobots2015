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
