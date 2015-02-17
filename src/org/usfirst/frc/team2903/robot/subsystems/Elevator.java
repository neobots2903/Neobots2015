package org.usfirst.frc.team2903.robot.subsystems;

import org.usfirst.frc.team2903.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	public DigitalInput bottomLimit = new DigitalInput(RobotMap.botLimitSwitch);
	public DigitalInput upperLimit = new DigitalInput(RobotMap.topLimitSwitch);
	public Jaguar elevatorM = new Jaguar(RobotMap.elevatorM);
	// software control of breaking system
	public Solenoid brakeSol = new Solenoid(RobotMap.brakeSol);

	public Encoder encoder = new Encoder(0, 1);

	public int count = encoder.get();
	boolean topLimitAct = upperLimit.get();
	int heightValue = 0;
	public int toteHeight = 0;
	
	
	int tote0Min = 0;
	int tote0Max = 25;
	int tote1Min = 26;
	int tote1Max = 50;
	int tote2Min = 0;
	int tote2Max = 0;
	int tote3Min = 0;
	int tote3Max = 0;
	int tote4Min = 0;
	int tote4Max = 0;
	int tote5Min = 0;
	int tote5Max = 0;
	int flex = 25;//+and- flex

	public void initDefaultCommand() {
	}

	public void elevatorMotor(double value) {
		elevatorM.set(value);
	}
	public void brakeEnable(){
		brakeSol.set(true);
	}
	public void brakeDisable(){
		brakeSol.set(false);
	}
	public void moveElevatorUp() {
		if (!topLimitAct && toteHeight < 5) {
			toteHeight++;
			switch (toteHeight) {
			case 1:
				elevatorM.set(0.5);
				if (tote1Min < count && count < tote1Max) {
					elevatorM.set(0);
				}
				break;
			case 2:
				elevatorM.set(0.5);
				if (tote2Min < count && count < tote2Max) {
					elevatorM.set(0);
				}
				break;
			case 3:
				elevatorM.set(0.5);
				if (tote3Min < count && count < tote3Max) {
					elevatorM.set(0);
				}
				break;
			case 4:
				elevatorM.set(0.5);
				if (tote4Min < count && count < tote4Max) {
					elevatorM.set(0);
				}
				break;
			case 5:
				elevatorM.set(0.5);
				if (tote4Min < count && count < tote5Max) {
					elevatorM.set(0);
				}
				break;

			default:
				elevatorM.set(0);
				break;
			}
		}
	}

	public void moveElevatorUpCheck() {
		if (!topLimitAct && toteHeight < 5) {
			switch (toteHeight) {
			case 1:
				if (tote1Min < count && count < tote1Max) {
					elevatorM.set(0);
				}
				break;
			case 2:
				if (tote2Min < count && count < tote2Max) {
					elevatorM.set(0);
				}
				break;
			case 3:
				if (tote3Min < count && count < tote3Max) {
					elevatorM.set(0);
				}
				break;
			case 4:
				if (tote4Min < count && count < tote4Max) {
					elevatorM.set(0);
				}
				break;
			case 5:
				if (tote5Min < count && count < tote5Max) {
					elevatorM.set(0);
				}
				break;

			default:
				elevatorM.set(0);
				break;
			}
		}
	}

	public void moveElevatorDown() {
		toteHeight--;
		switch (toteHeight) {
		case 1:
			elevatorM.set(-0.2);
			brakeSol.set(true);
			elevatorM.set(0);
			if (tote1Min < count && count < tote1Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 2:
			elevatorM.set(-0.2);
			brakeSol.set(true);
			elevatorM.set(0);
			if (tote2Min < count && count < tote2Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 3:
			elevatorM.set(-0.2);
			brakeSol.set(true);
			elevatorM.set(0);
			if (tote3Min < count && count < tote3Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 4:
			elevatorM.set(-0.2);
			brakeSol.set(true);
			elevatorM.set(0);
			if (tote4Min < count && count < tote4Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 5:
			elevatorM.set(-0.2);
			brakeSol.set(true);
			elevatorM.set(0);
			if (tote5Min < count && count < tote5Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;

		default:
			elevatorM.set(0);
			break;
		}
	}

	public void elevatorReset() {
		if (toteHeight != 0) {
			if (bottomLimit.equals(false)) {
				elevatorM.set(0);
			}
			if (bottomLimit.equals(true)) {
				elevatorM.set(0);
				encoder.reset();
				toteHeight = 0;
			}
		}
	}
}