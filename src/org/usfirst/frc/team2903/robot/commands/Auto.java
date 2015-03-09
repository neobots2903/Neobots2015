package org.usfirst.frc.team2903.robot.commands;

public class Auto extends AutoBase {

	public void forward() {
		long startTime = System.currentTimeMillis();
		long stopTime = startTime;

		rightFrontMotor1.set(1);
		leftFrontMotor1.set(1);
		leftBackMotor1.set(1);
		rightBackMotor1.set(1);

		while (stopTime <= (startTime + 2000)) {

			stopTime = System.currentTimeMillis();

		}

		rightFrontMotor1.set(0);
		leftFrontMotor1.set(0);
		leftBackMotor1.set(0);
		rightBackMotor1.set(0);
	}

}
