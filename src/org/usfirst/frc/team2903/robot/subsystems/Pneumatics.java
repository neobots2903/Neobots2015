package org.usfirst.frc.team2903.robot.subsystems;

import org.usfirst.frc.team2903.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics extends Subsystem {

	public Solenoid rightSolOpen = new Solenoid(RobotMap.RIGHTSOLOPEN); 
	public Solenoid rightSolClose = new Solenoid(RobotMap.RIGHTSOLCLOSE);
	public Solenoid leftSolOpen = new Solenoid(RobotMap.LEFTSOLOPEN);
	public Solenoid leftSolClose = new Solenoid(RobotMap.LEFTSOLCLOSE);
	public boolean isOpen = false; 
	
		
	public void openarms()
	{
		leftarmopen();
		rightarmopen();
	}
	
	public void closearms()
	{
		leftarmclose();
		rightarmclose();
	}
	
	public void leftarmopen()
	{
		leftSolOpen.set(true);
		leftSolClose.set(false);
	}
	
	public void leftarmclose()
	{
		leftSolOpen.set(false);
		leftSolClose.set(true);
	}
	
	public void rightarmopen()
	{
		rightSolOpen.set(true);
		rightSolClose.set(false);
	}
	
	public void rightarmclose()
	{
		rightSolOpen.set(false);
		rightSolClose.set(true);
	}
	
	
	public void armReset()
	{
		openarms();
	}
	
	public void armsOpenClose()
	{
		if (isOpen)
		{
			closearms();
			isOpen = false;
		}
		else
		{
			openarms();
			isOpen = true; 
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	}