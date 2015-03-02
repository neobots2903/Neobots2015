package org.usfirst.frc.team2903.robot.subsystems;

import org.usfirst.frc.team2903.robot.RobotMap;

//import com.sun.webkit.Timer;

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

	public Encoder encoder = new Encoder(1, 0);

	public boolean topLimitAct = upperLimit.get();
	int heightValue = 0;
	public int toteHeight = 0;
	public double speedUp = 0.5;

	private int startEncoderCount;
	private int endEncoderCount;
	private long startTime;
	private long endTime;
	private float rateMovement;
	private float upwardRate = 180;
	private float downwardRate = -180;
	private float rateAdjust = 5;
	private double speedAdjust = 0.1;
	private double speed;

	int tote0Min = 0;
	int tote0Max = 20;
	int tote1Min = 470;
	int tote1Max = 490;
	int tote2Min = 760;
	int tote2Max = 780;
	int tote3Min = 1000;
	int tote3Max = 1020;
	int tote4Min = 1170;
	int tote4Max = 1190;
	int flex = 25;// +and- flex

	public void initDefaultCommand() {
	}

	public void speedControl() {
		speed = elevatorM.get();
		if (speed < 0) {
			if (startEncoderCount == 0) {
				startTime = System.currentTimeMillis();
				startEncoderCount = count();
			} else {
				endTime = System.currentTimeMillis();
				endEncoderCount = count();

				rateMovement = (endEncoderCount - startEncoderCount)
						/ (endTime - startTime);

				if (rateMovement > 0) {
					// compare rateMovement to the desired rate plus the extra
					// room
					if (rateMovement > (upwardRate + rateAdjust)) {
						// speed greater than disired speed, decrease by
						// speedAdjust
						speed -= speedAdjust;
					} else if (rateMovement < (upwardRate - rateAdjust)) {
						// speed less than disired speed, increase by
						// speedAdjust
						speed += speedAdjust;
					}

				} else if (rateMovement < 0) {
					if (rateMovement < (downwardRate + rateAdjust)) {
						// speed less than disired speed, increase by
						// speedAdjust
						speed += speedAdjust;
					} else if (rateMovement > (downwardRate - rateAdjust)) {
						// speed greater than disired speed, decrease by
						// speedAdjust
						speed -= speedAdjust;
					}
				}
				startTime = endTime;
				startEncoderCount = endEncoderCount;
				elevatorM.set(speed);
			}
		}
		else{
			startTime = 0;
			startEncoderCount = 0;
			}
	}

	public int count() {
		return encoder.get();
	}

	public void elevatorMotor(double value) {
		elevatorM.set(value);
	}

	public void moveElevatorUp() {
		if (toteHeight < 4) {
			toteHeight++;
		}
		switch (toteHeight) {
		case 1:
			elevatorM.set(speedUp);
			if (tote1Min < count() && count() < tote1Max) {
				elevatorM.set(0);
			}
			break;
		case 2:
			elevatorM.set(speedUp);
			if (tote2Min < count() && count() < tote2Max) {
				elevatorM.set(0);
			}
			break;
		case 3:
			elevatorM.set(speedUp);
			if (tote3Min < count() && count() < tote3Max) {
				elevatorM.set(0);
			}
			break;
		case 4:
			elevatorM.set(speedUp);
			if (tote4Min < count() && count() < tote4Max) {
				elevatorM.set(0);
			}
			break;

		default:
			elevatorM.set(0);
			break;

		}
	}

	public void moveElevatorUpCheck() {
		if (toteHeight <= 4) {
			switch (toteHeight) {
			case 1:
				if (tote1Min < encoder.get() && encoder.get() < tote1Max) {
					elevatorM.set(0);
				}
				break;
			case 2:
				if (tote2Min < count() && count() < tote2Max) {
					elevatorM.set(0);
				}
				break;
			case 3:
				if (tote3Min < count() && count() < tote3Max) {
					elevatorM.set(0);
				}
				break;
			case 4:
				if (tote4Min < count() && count() < tote4Max) {
					elevatorM.set(0);
				}
				break;

			default:
				break;
			}
		}
	}

	public void moveElevatorDown() {
		toteHeight--;
		switch (toteHeight) {
		case 0:
			elevatorM.set(0.6);
			brakeSol.set(true);
			edu.wpi.first.wpilibj.Timer.delay(.1);
			elevatorM.set(0);
			if (tote0Min < count() && count() < tote0Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 1:
			elevatorM.set(0.6);
			brakeSol.set(true);
			edu.wpi.first.wpilibj.Timer.delay(.1);
			elevatorM.set(0);
			if (tote1Min < count() && count() < tote1Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 2:
			elevatorM.set(0.6);
			brakeSol.set(true);
			edu.wpi.first.wpilibj.Timer.delay(.1);
			elevatorM.set(0);
			if (tote2Min < count() && count() < tote2Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 3:
			elevatorM.set(0.6);
			brakeSol.set(true);
			edu.wpi.first.wpilibj.Timer.delay(.1);
			elevatorM.set(0);
			if (tote3Min < count() && count() < tote3Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 4:
			elevatorM.set(0.6);
			brakeSol.set(true);
			edu.wpi.first.wpilibj.Timer.delay(.1);
			elevatorM.set(0);
			if (tote4Min < count() && count() < tote4Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;

		default:
			elevatorM.set(0);
			break;
		}

	}

	public void moveElevatorDownCheck() {
		switch (toteHeight) {
		case 0:
			if (tote0Min < count() && count() < tote0Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 1:
			if (tote1Min < count() && count() < tote1Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 2:
			if (tote2Min < count() && count() < tote2Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;
		case 3:
			if (tote3Min < count() && count() < tote3Max) {
				elevatorM.set(0);
				brakeSol.set(false);
			}
			break;

		default:
			break;
		}

	}

	public void elevatorReset() {
		// if (toteHeight != 0) {
		// if (bottomLimit.equals(false)) {
		// elevatorM.set(0);
		// }
		// if (bottomLimit.equals(true)) {
		// elevatorM.set(0);
		// encoder.reset();
		// toteHeight = 0;
		// }
		// }
		startTime = 0;
		startEncoderCount = 0;
	}
}
