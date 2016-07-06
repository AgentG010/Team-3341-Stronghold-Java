
package org.usfirst.frc.team3341.robot.commands.arm;

import org.usfirst.frc.team3341.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	Calls the moveArm() method on the arm Sybsystem
 */
public class MoveArm extends Command
{

	public MoveArm()
	{
		requires(Robot.arm);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		double speedValue = Robot.oi.getOperatorStick().getY();

		// Define some dead space for the joystick to eliminate over-sensitivity
		if (Math.abs(speedValue) > 0.05)
			Robot.arm.moveArm(speedValue);
		else
			Robot.arm.stopArm();
	}

	protected boolean isFinished()
	{
		return false;
	}

	protected void end()
	{
	}

	protected void interrupted()
	{
	}
}
