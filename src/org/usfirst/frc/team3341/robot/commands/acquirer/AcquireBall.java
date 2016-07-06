
package org.usfirst.frc.team3341.robot.commands.acquirer;

import org.usfirst.frc.team3341.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	Calls the acquireBall() mehtod of the acquirer subsystem
 */
public class AcquireBall extends Command
{
	public AcquireBall()
	{
		requires(Robot.acquirer);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.acquirer.acquireBall();
	}

	// Stop acquiring if the ball is detected in the robot
	protected boolean isFinished()
	{
		return Robot.acquirer.hasBallStored();
	}

	// Stop the acquirer after we're done
	protected void end()
	{
		Robot.acquirer.stopAcquirer();
	}

	protected void interrupted()
	{
	}
}
