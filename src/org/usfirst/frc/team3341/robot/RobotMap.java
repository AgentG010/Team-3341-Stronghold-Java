
package org.usfirst.frc.team3341.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap
{
	// Joysticks
	public static final int DRIVE_STICK = 0;
	public static final int OPERATOR_STICK = 1;

	// Drive Motors
	public static final int DRIVELEFT_MOTOR = 0;
	public static final int DRIVERIGHT_MOTOR = 1;

	// Acquirer Motor
	public static final int ACQUIRER_MOTOR = 2;

	// Arm Motor
	public static final int ARM_MOTOR = 3;

	// Digital I/O
	public static final int ENCODER_LEFT_1 = 0;
	public static final int ENCODER_LEFT_2 = 1;
	public static final int ENCODER_RIGHT_1 = 2;
	public static final int ENCODER_RIGHT_2 = 3;

	// Analog I/O
	public static final int GYRO_ANALOG = 0;
	public static final int IR_ANALOG = 2;
}
