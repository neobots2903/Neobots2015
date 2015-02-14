package org.usfirst.frc.team2903.robot.subsystems;

import org.usfirst.frc.team2903.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	
	public Jaguar elevatorM = new Jaguar(RobotMap.elevatorM);
    //software control of breaking system
	Encoder encoder = new Encoder(1, 2);
	
	int count = encoder.get();
	int heightValue = 0;
	int toteHeight = 0;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void moveElevatorUp() {
    	toteHeight++; 
    	switch (toteHeight) {
		case 1:
			elevatorM.set(0.5);
			if(28 < count && count < 32){
				elevatorM.set(0);
			}
			break;
		case 2:
			elevatorM.set(0.5);
			if(33 < count && count < 37){
				elevatorM.set(0);
			}
			break;
		case 3:
			elevatorM.set(0.5);
			if(38 < count && count < 42){
				elevatorM.set(0);
			}
			break;
		case 4:
			elevatorM.set(0.5);
			if(43 < count && count < 47){
				elevatorM.set(0);
			}
			break;
		case 5:
			elevatorM.set(0.5);
			if(48 < count && count < 52){
				elevatorM.set(0);
			}
			break;

		default:
			elevatorM.set(0);
			break;
		}
    	
    }
    
    public void moveElevatorDown(){
    	toteHeight--; 
    	switch (toteHeight) {
		case 1:
			elevatorM.set(-0.5);
			if(48 < count && count < 52){
				elevatorM.set(0);
			}
			break;
		case 2:
			elevatorM.set(-0.5);
			if(43 < count && count < 47){
				elevatorM.set(0);
			}
			break;
		case 3:
			elevatorM.set(-0.5);
			if(38 < count && count < 42){
				elevatorM.set(0);
			}
			break;
		case 4:
			elevatorM.set(-0.5);
			if(33 < count && count < 37){
				elevatorM.set(0);
			}
			break;
		case 5:
			elevatorM.set(-0.5);
			if(28 < count && count < 32){
				elevatorM.set(0);
			}
			break;

		default:
			elevatorM.set(0);
			break;
		}
    	
    	
    	
    }
    
    public void elevatorReset(){
    	
    	
    }
}