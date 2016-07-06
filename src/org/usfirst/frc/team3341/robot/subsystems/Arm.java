
package org.usfirst.frc.team3341.robot.subsystems;

import org.usfirst.frc.team3341.robot.commands.arm.MoveArm;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem
{
	private SpeedController armMotor;

	public Arm(int motorPort)
	{
		super("Arm");

		armMotor = new Talon(motorPort);
	}

	public void moveArm(double speed)
	{
		armMotor.set(speed);
	}

	public void stopArm()
	{
		armMotor.set(0.0);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new MoveArm());
	}
}
