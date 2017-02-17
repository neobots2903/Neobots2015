package org.usfirst.frc.team2903.robot.subsystems;

import org.usfirst.frc.team2903.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

	private double upSpeed = 0.5;
	private int startEncoderCount;
	private int endEncoderCount;
	private long startTime;
	private long endTime;
	private float rateMovement;
	private float upwardRate = 160;
	private float downwardRate = -160;
	private float rateAdjust;
	private double speedAdjust = 0.05;
	private double autoSpeed;
	private boolean movingUp = true;

	int tote0Min = 0;
	int tote0Max = 20;
	int tote1Min = 195;
	int tote1Max = 215;
	int tote2Min = 450;
	int tote2Max = 470;
	int tote3Min = 740;
	int tote3Max = 760;
	int tote4Min = 980;
	int tote4Max = 1000;
	int tote5Min = 1150;
	int tote5Max = 1170;
	
	int flex = 25;// +and- flex

	public void initDefaultCommand() {
		autoSpeed = 0.1;
		movingUp = true;
	}

	public void speedControl() {
		SmartDashboard.putString("debug", "entering speed control");
		double speed = elevatorM.get();
		if (speed > 0) {
			if (startEncoderCount == 0) {
				startTime = System.currentTimeMillis();
				startEncoderCount = count();
			} else {
				endTime = System.currentTimeMillis();
				endEncoderCount = count();

				rateMovement = (endEncoderCount - startEncoderCount)
						/ (endTime - startTime);

				if (rateMovement >= 0) {
					// compare rateMovement to the desired rate plus the extra
					// room
					if (rateMovement > (upwardRate + rateAdjust)) {
						// speed greater than disired speed, decrease by
						// speedAdjust
						autoSpeed -= speedAdjust;
					} else if (rateMovement < (upwardRate - rateAdjust)) {
						// speed less than disired speed, increase by
						// speedAdjust
						autoSpeed += speedAdjust;
					}

				}

				startTime = endTime;
				startEncoderCount = endEncoderCount;
				elevatorM.set(autoSpeed);
			}
		} else {
			startTime = 0;
			startEncoderCount = 0;
		}
	}

	public int count() {
		return encoder.get();
	}

	public void moveElevatorUp() {
		if (toteHeight < 5) {
			toteHeight++;
			movingUp = true;
			brakeSol.set(false);

			switch (toteHeight) {
			case 1:
				elevatorM.set(upSpeed);
				if (count() >= tote1Min) {
					SmartDashboard.putString("debug", "109");
					elevatorM.set(0);
				}
				break;
			case 2:
				elevatorM.set(upSpeed);
				if (tote2Min <= count()) {
					SmartDashboard.putString("debug", "127");
					elevatorM.set(0);
				}
				break;
			case 3:
				elevatorM.set(upSpeed);
				if (tote3Min <= count()) {
					SmartDashboard.putString("debug", "134");
					elevatorM.set(0);
				}
				break;
			case 4:
				elevatorM.set(upSpeed);
				if (tote4Min <= count()) {
					SmartDashboard.putString("debug", "141");
					elevatorM.set(0);
				}
			case 5:
				elevatorM.set(upSpeed);
				if (tote5Min <= count()) {
					SmartDashboard.putString("debug", "139");
					elevatorM.set(0);
				}
				break;
			default:
				break;

			}
		}
	}

	public boolean moveElevatorUpCheck() {
		boolean atRequestedHeight;
		atRequestedHeight = false;
		if (movingUp) {

			if (toteHeight <= 5) {
				switch (toteHeight) {
				case 1:
					if (tote1Min <= count()) {
						SmartDashboard.putString("debug", "148");
						elevatorM.set(0);
						atRequestedHeight = true;
						// movingUp = false;

					}
					break;
				case 2:
					if (tote2Min <= count()) {
						SmartDashboard.putString("debug", "155");
						elevatorM.set(0);
						// movingUp = false;
						atRequestedHeight = true;
					}
					break;
				case 3:
					if (tote3Min <= count()) {
						SmartDashboard.putString("debug", "162");
						elevatorM.set(0);
						// movingUp = false;
						atRequestedHeight = true;
					}
					break;
				case 4:
					if (tote4Min <= count()) {
						SmartDashboard.putString("debug", "169");
						elevatorM.set(0);
						// movingUp = false;
						atRequestedHeight = true;
					}
					break;
				case 5:
					if (tote5Min <= count()) {
						SmartDashboard.putString("debug", "169");
						elevatorM.set(0);
						// movingUp = false;
						atRequestedHeight = true;
					}
					break;

				default:
					elevatorM.set(0);
					// movingUp = false;
					atRequestedHeight = true;
					break;
				}
			}
		}
		SmartDashboard.putBoolean("@height", atRequestedHeight);
		SmartDashboard.putBoolean("movingUp", movingUp);
		return atRequestedHeight;
	}

	public void moveElevatorDown() {

		if (toteHeight > 0) {
			toteHeight--;
			movingUp = false;
			autoSpeed= 0.1;
			
			switch (toteHeight) {
			case 0:
				elevatorM.set(0.6);
				brakeSol.set(true);
				edu.wpi.first.wpilibj.Timer.delay(.1);
				SmartDashboard.putString("debug", "222");
				elevatorM.set(0);
				if (count() < tote0Max) {
					//elevatorM.set(0);
					brakeSol.set(false);
				}
				break;
			case 1:
				elevatorM.set(0.6);
				brakeSol.set(true);
				edu.wpi.first.wpilibj.Timer.delay(.1);
				SmartDashboard.putString("debug", "234");
				elevatorM.set(0);
				if (count() < tote1Max) {
					SmartDashboard.putString("debug", "238");
					elevatorM.set(0);
					brakeSol.set(false);
				}
				break;
			case 2:
				elevatorM.set(0.6);
				brakeSol.set(true);
				edu.wpi.first.wpilibj.Timer.delay(.1);
				SmartDashboard.putString("debug", "247");
				elevatorM.set(0);
				if (count() < tote2Max) {
					SmartDashboard.putString("debug", "251");
					elevatorM.set(0);
					brakeSol.set(false);
				}
				break;
			case 3:
				elevatorM.set(0.6);
				brakeSol.set(true);
				edu.wpi.first.wpilibj.Timer.delay(.1);
				SmartDashboard.putString("debug", "260");
				elevatorM.set(0);
				if (count() < tote3Max) {
					SmartDashboard.putString("debug", "264");
					elevatorM.set(0);
					brakeSol.set(false);
				}
				break;
			case 4:
				elevatorM.set(0.6);
				brakeSol.set(true);
				edu.wpi.first.wpilibj.Timer.delay(.1);
				SmartDashboard.putString("debug", "260");
				elevatorM.set(0);
				if (count() < tote4Max) {
					SmartDashboard.putString("debug", "264");
					elevatorM.set(0);
					brakeSol.set(false);
				}
				break;
			default:
				SmartDashboard.putString("debug", "281");
				elevatorM.set(0);
				break;
			}
		}

	}

	public boolean moveElevatorDownCheck() {
		boolean atRequestedHeight = false;
		if (!movingUp) {
			switch (toteHeight) {
			case 0:
				if (count() < tote0Max) {
					SmartDashboard.putString("debug", "294");
					elevatorM.set(0);
					brakeSol.set(false);
					atRequestedHeight = true;
				}
				break;
			case 1:
				if (count() < tote1Max) {
					SmartDashboard.putString("debug", "302");
					elevatorM.set(0);
					brakeSol.set(false);
					atRequestedHeight = true;
				}
				break;
			case 2:
				if (count() < tote2Max) {
					SmartDashboard.putString("debug", "310");
					elevatorM.set(0);
					brakeSol.set(false);
					atRequestedHeight = true;
				}
				break;
			case 3:
				if (count() < tote3Max) {
					SmartDashboard.putString("debug", "318");
					elevatorM.set(0);
					brakeSol.set(false);
					atRequestedHeight = true;
				}
				break;
			case 4:
				if (count() < tote4Max) {
					SmartDashboard.putString("debug", "318");
					elevatorM.set(0);
					brakeSol.set(false);
					atRequestedHeight = true;
				}
				break;

			default:
				atRequestedHeight = true;
				break;
			}
		}
		return atRequestedHeight;
	}

	public void elevatorReset() {
		encoder.reset();
		elevatorM.set(0.6);
		brakeSol.set(true);
		Timer.delay(0.1);
		startTime = 0;
		startEncoderCount = 0;
		elevatorM.set(0);
	}
	
	public void manualElevator(double speed){
		elevatorM.set(speed);
	}
	
	public void brake(boolean brakeOff){
		if(brakeOff = true){
		brakeSol.set(true);
		}else{
			brakeSol.set(false);
		}
	}

	public double elevatorSpeed() {
		return elevatorM.getSpeed();
	}

	public double getAutoSpeed() {
		return autoSpeed;
	}

	public void setAutoSpeed(double autoSpeed) {
		this.autoSpeed = autoSpeed;
	}
}
