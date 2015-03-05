package org.usfirst.frc.team2903.robot.subsystems;

import edu.wpi.first.wpilibj.Gyro;

import org.usfirst.frc.team2903.robot.OI;
import org.usfirst.frc.team2903.robot.RobotMap;
//dhjgf
public class Gyro2903 {
	public void Gyro() {

		Gyro gyro = new Gyro(RobotMap.Gyro);
		gyro.reset();
			
		double angle = gyro.getAngle();
		double	x = OI.Joy2.getX();
		double CAngle = gyro.getAngle();
		
		if(x == 0){
		
			if(angle == 0){
				
			}
			else{
			//turn to 0
				}
			}
		else{
		
		}
		}
} 