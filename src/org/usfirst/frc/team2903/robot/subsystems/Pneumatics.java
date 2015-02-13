package org.usfirst.frc.team2903.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public Solenoid mySol1 = new Solenoid(1); 
	Public mySol1				/* This makes the variable called
												 mySol1 a Solenoid from port
												 1 and allows us to activate 
												 it*/
	public Solenoid mySol2 = new Solenoid(2); 
												/* This makes the variable called
												 mySol2 a Solenoid from port
												 2 and allows us to activate 
												 it*/
	public DoubleSolenoid myDoubleSol = new DoubleSolenoid(1, 2); /* This allow
																	 us to use
																	 the
																	 Solenoids
																	 together.*/

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}
}