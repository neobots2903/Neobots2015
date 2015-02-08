package org.usfirst.frc.team2903.robot.subsystems;

import org.usfirst.frc.team2903.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Talon leftFrontMotor1 = new Talon(RobotMap.HDriveM2);
	public Talon rightFrontMotor1 = new Talon(RobotMap.HDriveM3);
	public Talon leftBackMotor1 = new Talon(RobotMap.HDriveM1);
	public Talon rightBackMotor1 = new Talon(RobotMap.HDriveM4);
	public Talon middleMotor1 = new Talon(RobotMap.HDriveM5);
	
	
}