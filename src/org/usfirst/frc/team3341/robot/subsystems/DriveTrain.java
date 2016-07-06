
package org.usfirst.frc.team3341.robot.subsystems;

import org.usfirst.frc.team3341.robot.RobotMap;
import org.usfirst.frc.team3341.robot.commands.drivetrain.ArcadeDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem
{
	private SpeedController leftWheels, rightWheels;
	private AnalogGyro gyro;
	private Encoder encoderLeft, encoderRight;

	public DriveTrain(int leftWheelsPort, int rightWheelsPort, int gyroPort)
	{
		super("DriveTrain");

		leftWheels = new Talon(leftWheelsPort);
		rightWheels = new Talon(rightWheelsPort);

		gyro = new AnalogGyro(gyroPort);

		encoderLeft = new Encoder(RobotMap.ENCODER_LEFT_1, RobotMap.ENCODER_LEFT_2);
		encoderRight = new Encoder(RobotMap.ENCODER_RIGHT_1, RobotMap.ENCODER_RIGHT_2);

		// TODO: find distancePerPulse values
		encoderLeft.setDistancePerPulse(1.0);
		encoderRight.setDistancePerPulse(1.0);
	}

	// Moves the left and right wheels based on arcade drive input parameters
	public void arcadeDrive(double driveSpeed, double rotationSpeed)
	{
		double leftMotorOutput;
		double rightMotorOutput;

		// Convert ArcadeDrive inputs to TankDrive outputs
		if (driveSpeed > 0.0)
		{
			if (rotationSpeed > 0.0)
			{
				leftMotorOutput = driveSpeed - rotationSpeed;
				rightMotorOutput = Math.max(driveSpeed, rotationSpeed);
			}
			else
			{
				leftMotorOutput = Math.max(driveSpeed, -rotationSpeed);
				rightMotorOutput = driveSpeed + rotationSpeed;
			}
		}
		else
		{
			if (rotationSpeed > 0.0)
			{
				leftMotorOutput = -Math.max(-driveSpeed, rotationSpeed);
				rightMotorOutput = driveSpeed + rotationSpeed;
			}
			else
			{
				leftMotorOutput = driveSpeed - rotationSpeed;
				rightMotorOutput = -Math.max(-driveSpeed, -rotationSpeed);
			}
		}

		leftMotorOutput = constrain(leftMotorOutput, -1.0, 1.0);
		rightMotorOutput = constrain(rightMotorOutput, -1.0, 1.0);

		leftWheels.set(leftMotorOutput);
		rightWheels.set(rightMotorOutput);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new ArcadeDrive());
	}

	public void resetGyro()
	{
		gyro.reset();
	}

	public double getGyroAngle()
	{
		return gyro.getAngle();
	}

	// Constrain inputVal to be within minVal and maxVal
	private double constrain(double inputVal, double minVal, double maxVal)
	{
		return Math.min(maxVal, Math.max(minVal, inputVal));
	}
}
