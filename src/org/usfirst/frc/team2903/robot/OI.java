package org.usfirst.frc.team2903.robot;

import org.usfirst.frc.team2903.robot.commands.ElevatorDown;
import org.usfirst.frc.team2903.robot.commands.ElevatorReset;
import org.usfirst.frc.team2903.robot.commands.ElevatorUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick controller = new Joystick(0);
	public static Joystick Joy1 = new Joystick(2);
	public static Joystick Joy2 = new Joystick(3);
	
	public static JoystickButton elevatorUpButton = new JoystickButton(controller, RobotMap.ELEVATOR_UP);
	public static JoystickButton elevatorDownButton = new JoystickButton(controller, RobotMap.ELEVTOR_DOWN);
	public static JoystickButton elevatorResetButton = new JoystickButton(controller, RobotMap.ELEVATOR_RESET);
	
	
	public OI()
	{
		elevatorUpButton.whenReleased(new ElevatorUp());
		elevatorDownButton.whenReleased(new ElevatorDown());
		elevatorResetButton.whenReleased(new ElevatorReset());
	}
}

