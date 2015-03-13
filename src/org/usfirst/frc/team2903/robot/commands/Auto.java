package org.usfirst.frc.team2903.robot.commands;

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
