package org.usfirst.frc.team2903.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics extends Subsystem {
	
	final int RIGHTSOLOPEN = 1;
	final int RIGHTSOLCLOSE = 2;
	final int LEFTSOLOPEN = 6;
	final int LEFTSOLCLOSE = 7;

	public Solenoid rightSolOpen = new Solenoid(RIGHTSOLOPEN); 
	public Solenoid rightSolClose = new Solenoid(RIGHTSOLOPEN);
	public Solenoid leftSolOpen = new Solenoid(LEFTSOLOPEN);
	public Solenoid leftSolClose = new Solenoid(LEFTSOLCLOSE);
	public DoubleSolenoid doubleSolOpen = new DoubleSolenoid(RIGHTSOLOPEN, LEFTSOLOPEN);
	public boolean isOpen = false; 
	
		
	public void openarms()
	{
		doubleSolOpen.set(Value.kForward);
	}
	
	public void closearms()
	{
		doubleSolOpen.set(Value.kReverse);
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
		rightSolOpen.set(false);
	}
	
	public void rightarmclose()
	{
		rightSolOpen.set(false);
		rightSolOpen.set(true);
	}
	
	
	public void armReset()
	{
		openarms();
		doubleSolOpen.set(Value.kOff);
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