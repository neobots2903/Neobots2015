package org.usfirst.frc.team2903.robot.subsystems;

import edu.wpi.first.wpilibj.*;
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
	
	public void forward()
	{
		rightFrontMotor1.set(1);
		leftFrontMotor1.set(1);
		leftBackMotor1.set(1);
		rightBackMotor1.set(1);
	}
	public void left()
	{
		middleMotor1.set(-1);
	}
	public void right()
	{
		middleMotor1.set(1);
	}
	public void backward()
	{
		rightFrontMotor1.set(-1);
		leftFrontMotor1.set(-1);
		leftBackMotor1.set(-1);
		rightBackMotor1.set(-1);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}