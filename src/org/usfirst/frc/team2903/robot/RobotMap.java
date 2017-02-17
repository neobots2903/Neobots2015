package org.usfirst.frc.team2903.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	
	//PWM
    public static int HDriveM1 = 0;
    public static int HDriveM2 = 1;
    public static int HDriveM3 = 2;
    public static int HDriveM4 = 3;
    public static int HDriveM5 = 4;
    public static int elevatorM = 5;
    
    //DIO
    public static int botLimitSwitch = 4;
    public static int topLimitSwitch = 5;
    
    //Pneumatics
    public static int RIGHTSOLOPEN = 0;
	public static int RIGHTSOLCLOSE = 1;
	public static int LEFTSOLOPEN = 6;
	public static int LEFTSOLCLOSE = 7;
	//Sol
	public static int brakeSol = 3;
	//Gyro
	public static int Gyro = 8;
    
	// Elevator
	public static int ELEVATOR_UP = 2;
	public static int ELEVTOR_DOWN = 3;
	public static int ELEVATOR_RESET = 4;
}
