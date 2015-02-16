package org.usfirst.frc.team2903.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics extends Subsystem {
	
	final int RIGHTSOLOPEN = 0;
	final int RIGHTSOLCLOSE = 1;
	final int LEFTSOLOPEN = 6;
	final int LEFTSOLCLOSE = 7;

	public Solenoid rightSolOpen = new Solenoid(RIGHTSOLOPEN); 
	public Solenoid rightSolClose = new Solenoid(RIGHTSOLCLOSE);
	public Solenoid leftSolOpen = new Solenoid(LEFTSOLOPEN);
	public Solenoid leftSolClose = new Solenoid(LEFTSOLCLOSE);
	//public DoubleSolenoid doubleSolOpen = new DoubleSolenoid(RIGHTSOLOPEN, LEFTSOLOPEN);
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
		//doubleSolOpen.set(Value.kOff);
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