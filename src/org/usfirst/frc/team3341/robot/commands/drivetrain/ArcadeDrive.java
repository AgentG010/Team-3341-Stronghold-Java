
package org.usfirst.frc.team3341.robot.commands.drivetrain;

import org.usfirst.frc.team3341.robot.Robot;
import org.usfirst.frc.team3341.robot.util.Team3341PIDController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	Calls the arcadeDrive method of the driveTrain subsystem
 *	Uses the Gyro sensor of the driveTrain for straight driving
 */
public class ArcadeDrive extends Command
{
	private Team3341PIDController straightDrivePID;
	// Keeps track of if gyro needs to be reset before driving straight
	private boolean gyroNeedsReset;

	public ArcadeDrive()
	{
		requires(Robot.driveTrain);

		gyroNeedsReset = true;
		straightDrivePID = new Team3341PIDController(0.1, 0, 0, 0.0);
	}

	protected void initialize()
	{
		Robot.driveTrain.resetGyro();
		gyroNeedsReset = false;
	}

	protected void execute()
	{
		double driveSpeedRaw = Robot.oi.getDriveStick().getY();
		double rotationSpeedRaw = Robot.oi.getDriveStick().getZ();

		double driveSpeedAdjusted = mapToCubic(driveSpeedRaw, 0, 0);
		double rotationSpeedAdjusted;

		if (Math.abs(rotationSpeedRaw) < 0.05)
		{
			// Reset the gyro only once before driving straight
			if (gyroNeedsReset)
			{
				Robot.driveTrain.resetGyro();
				gyroNeedsReset = false;
			}

			// If joystick rotation value is relatively centered, drive straight using PID from Gyro input
			rotationSpeedAdjusted = straightDrivePID.calculate(Robot.driveTrain.getGyroAngle());
		}
		else
		{
			rotationSpeedAdjusted = rotationSpeedRaw;
			// If not driving straight, gyro needs to be reset before driving straight again
			gyroNeedsReset = true;
		}

		Robot.driveTrain.arcadeDrive(driveSpeedAdjusted, rotationSpeedAdjusted);
	}

	/**
	 * Maps a linear inputVal to a cubic output val based on the equation
	 * (1-b)ax^3 + (1-a)x +/- b
	 * This curve always passes through points (0, +/- b) and (1, 1)
	 * @param a: steepness of cubic curve
	 * @param b: y intercept for "dead space" of joystick
	 * Makes joystick less sensitive for lower values, helpful for driving
	 */
	private double mapToCubic(double a, double b, double inputVal)
	{
		double output;

		if (inputVal > 0)
			output = b + (1 - b) * ((a * Math.pow(inputVal, 3) + (1 - a) * inputVal));
		else
			output = -b + (1 - b) * ((a * Math.pow(inputVal, 3) + (1 - a) * inputVal));

		return output;
	}

	protected boolean isFinished()
	{
		return false;
	}

	protected void end()
	{
		Robot.driveTrain.resetGyro();
	}

	protected void interrupted()
	{
	}
}
