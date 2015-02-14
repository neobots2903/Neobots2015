package org.usfirst.frc.team2903.robot.subsystems;

import org.usfirst.frc.team2903.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	
	public Jaguar relevatorM = new Jaguar(RobotMap.relevatorM);
    
	Encoder encoder = new Encoder(1, 2);
	
	int count = encoder.get();
	int heightValue = 0;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void moveElevatorUp() {
    	if(count < heightValue && heightValue != 100){
    	relevatorM.set(0.5);
    	heightValue++;
    	}
    	
    }
    
    public void moveElevatorDown(){
    	if(count > heightValue && heightValue != 0){
    	relevatorM.set(-0.5);
    	heightValue--;
        }
    	
    }
    
    public void elevatorReset(){
    	while(heightValue != 0){
    	relevatorM.set(-0.5);
    	heightValue--;
        }
    	
    }
}