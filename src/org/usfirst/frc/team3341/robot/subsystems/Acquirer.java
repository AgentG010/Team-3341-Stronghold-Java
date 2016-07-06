
package org.usfirst.frc.team3341.robot.subsystems;

import org.usfirst.frc.team3341.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Acquirer extends Subsystem
{
	private SpeedController acquirerMotor;
	private AnalogInput irSensor;

	public Acquirer(int motorPort)
	{
		super("Acquirer");

		acquirerMotor = new Talon(motorPort);
		irSensor = new AnalogInput(RobotMap.IR_ANALOG);
	}

	public void ejectBall()
	{
		acquirerMotor.set(-1.0);
	}

	public void acquireBall()
	{
		// Do not acquire if a ball is stored in the acquirer
		if (!hasBallStored())
			acquirerMotor.set(0.6);
		else
			stopAcquirer();
	}

	public void stopAcquirer()
	{
		acquirerMotor.set(0);
	}

	// Returns true if a ball is inside the robot
	public boolean hasBallStored()
	{
		// sensorThreshold grabbed from original code (Team-3341-Stronghold on GitHub)
		int sensorThreshold = 2500;

		if (irSensor.getValue() > sensorThreshold)
			return false;
		else
			return true;
	}

	public void initDefaultCommand()
	{
	}
}
