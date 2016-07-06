
package org.usfirst.frc.team3341.robot.commands.acquirer;

import org.usfirst.frc.team3341.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Calls the eject() method of the acquirer subsystem
 */
public class EjectBall extends Command
{
	public EjectBall()
	{
		requires(Robot.acquirer);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.acquirer.ejectBall();
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
