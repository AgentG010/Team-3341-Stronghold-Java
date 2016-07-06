
package org.usfirst.frc.team3341.robot;

import org.usfirst.frc.team3341.robot.commands.acquirer.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	private Joystick driveStick;
	private Joystick operatorStick;

	public OI()
	{
		driveStick = new Joystick(RobotMap.DRIVE_STICK);
		operatorStick = new Joystick(RobotMap.OPERATOR_STICK);

		JoystickButton ejectBall = new JoystickButton(driveStick, 1);
		ejectBall.whenPressed(new EjectBall());
		ejectBall.whenReleased(new StopAcquirer());

		JoystickButton acquireBall = new JoystickButton(driveStick, 2);
		acquireBall.whenPressed(new AcquireBall());
		acquireBall.whenReleased(new StopAcquirer());
	}

	public Joystick getDriveStick()
	{
		return driveStick;
	}

	public Joystick getOperatorStick()
	{
		return operatorStick;
	}
}
