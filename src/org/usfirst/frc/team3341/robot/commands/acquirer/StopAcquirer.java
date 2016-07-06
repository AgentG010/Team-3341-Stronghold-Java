
package org.usfirst.frc.team3341.robot.commands.acquirer;

import org.usfirst.frc.team3341.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	Calls the stopAcquire() method of the acquirer subsystem
 */
public class StopAcquirer extends Command
{

	public StopAcquirer()
	{
		requires(Robot.acquirer);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.acquirer.stopAcquirer();
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
