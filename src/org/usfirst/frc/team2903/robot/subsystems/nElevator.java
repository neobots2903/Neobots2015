/*package org.usfirst.frc.team2903.robot.subsystems;

import org.usfirst.frc.team2903.robot.OI;
import org.usfirst.frc.team2903.robot.RobotMap;

//import com.sun.webkit.Timer;



import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class nElevator extends Subsystem {

	public Jaguar elevatorM = new Jaguar(RobotMap.elevatorM);
	public Encoder encoder = new Encoder(1, 0);
	private double speed = .3;

	
	private int startEncoderCount;
	private int endEncoderCount;
	private long startTime;
	private long endTime;
	private float rateMovement;
	private float upwardRate = 180;
	private float downwardRate = -180;
	private float rateAdjust = 5;
	private double speedAdjust = 0.1;
	
	
	public void initDefaultCommand() {
	}
	
	
	public int count() {
		return encoder.get();
	}
	
	public void moveElevatorUp()
	{
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
					// speed greater than desired speed, decrease by
					// speedAdjust
					speed -= speedAdjust;
				} else if (rateMovement < (upwardRate - rateAdjust)) {
					// speed less than desired speed, increase by
					// speedAdjust
					speed += speedAdjust;
				}
			}
		startTime = endTime;
		startEncoderCount = endEncoderCount;
		elevatorM.set(speed);
		}
	}
	
	public void moveElevatorDown()
	{
		if (startEncoderCount == 0) {
			startTime = System.currentTimeMillis();
			startEncoderCount = count();
		} else {
			endTime = System.currentTimeMillis();
			endEncoderCount = count();

			rateMovement = (endEncoderCount - startEncoderCount)
					/ (endTime - startTime);
			
			if (rateMovement < (downwardRate + rateAdjust)) {
				// speed less than desired speed, increase by
				// speedAdjust
				speed += speedAdjust;
			} else if (rateMovement > (downwardRate - rateAdjust)) {
				// speed greater than desired speed, decrease by
				// speedAdjust
				speed -= speedAdjust;
			}
		}
		startTime = endTime;
		startEncoderCount = endEncoderCount;
		elevatorM.set(-speed);
	}
	
	public void resetControl() {
		if (speed == 0){
			startTime = 0;
			startEncoderCount = 0;
			}
	}
	
	public void temp()
	{
		if (startEncoderCount == 0) {
			startTime = System.currentTimeMillis();
			startEncoderCount = count();
		} else {
			endTime = System.currentTimeMillis();
			endEncoderCount = count();

			rateMovement = (endEncoderCount - startEncoderCount)
					/ (endTime - startTime);




			startTime = endTime;
			startEncoderCount = endEncoderCount;
			elevatorM.set(speed);
		}
	}

	
	public double elevatorSpeed(){
		return elevatorM.getSpeed();
	}
}
*/