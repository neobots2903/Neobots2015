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

	Encoder encoder = new Encoder(1, 2);

	int count = encoder.get();
	boolean topLimitAct = upperLimit.get();
	int heightValue = 0;
	int toteHeight = 0;

	public void initDefaultCommand() {
	}

	public void elevatorMotor(double value) {
		elevatorM.set(value);
	}

	public void moveElevatorUp() {
		if (!topLimitAct && toteHeight < 5) {
			toteHeight++;
			switch (toteHeight) {
			case 1:
				elevatorM.set(0.5);
				if (28 < count && count < 32) {
					elevatorM.set(0);
				}
				break;
			case 2:
				elevatorM.set(0.5);
				if (33 < count && count < 37) {
					elevatorM.set(0);
				}
				break;
			case 3:
				elevatorM.set(0.5);
				if (38 < count && count < 42) {
					elevatorM.set(0);
				}
				break;
			case 4:
				elevatorM.set(0.5);
				if (43 < count && count < 47) {
					elevatorM.set(0);
				}
				break;
			case 5:
				elevatorM.set(0.5);
				if (48 < count && count < 52) {
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
				if (28 < count && count < 32) {
					elevatorM.set(0);
				}
				break;
			case 2:
				if (33 < count && count < 37) {
					elevatorM.set(0);
				}
				break;
			case 3:
				if (38 < count && count < 42) {
					elevatorM.set(0);
				}
				break;
			case 4:
				if (43 < count && count < 47) {
					elevatorM.set(0);
				}
				break;
			case 5:
				if (48 < count && count < 52) {
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
		switch (toteHeight) {
		case 1:
			elevatorM.set(0.001);
			elevatorM.set(0);
			brakeSol.set(true);
			elevatorM.set(-0.5);
			if (48 < count && count < 52) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 2:
			elevatorM.set(0.001);
			elevatorM.set(0);
			brakeSol.set(true);
			elevatorM.set(-0.5);
			if (43 < count && count < 47) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 3:
			elevatorM.set(0.001);
			elevatorM.set(0);
			brakeSol.set(true);
			elevatorM.set(-0.5);
			if (38 < count && count < 42) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 4:
			elevatorM.set(0.001);
			elevatorM.set(0);
			brakeSol.set(true);
			elevatorM.set(-0.5);
			if (33 < count && count < 37) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 5:
			elevatorM.set(0.001);
			elevatorM.set(0);
			brakeSol.set(true);
			elevatorM.set(-0.5);
			if (28 < count && count < 32) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;

		default:
			elevatorM.set(0);
			break;
		}

		if (toteHeight > 0) {
			toteHeight--;
		}

	}

	public void elevatorReset() {
		if (toteHeight != 0) {
			if (bottomLimit.equals(false)) {
				elevatorM.set(-0.5);
			}
			if (bottomLimit.equals(true)) {
				elevatorM.set(0);
				encoder.reset();
				toteHeight = 0;
			}
		}
	}
}