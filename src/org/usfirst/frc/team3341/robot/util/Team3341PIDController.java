
package org.usfirst.frc.team3341.robot.util;

/**
 *	A simple PID controller that calculates an output signal from a given input signal
 *	Does not grab inputs or set outputs by itself 
 */
public class Team3341PIDController
{
	private double kP, kI, kD;
	private double setPoint;
	private double previousError;
	private double integralAccumulation;

	public Team3341PIDController(double kP, double kI, double kD, double setPoint)
	{
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;

		this.setPoint = setPoint;
		this.previousError = 0;
		this.integralAccumulation = 0;
	}

	// given a sensor input from a sensor, calculates an output signal
	// to be called continuously in a for loop
	public double calculate(double input)
	{
		double error = this.setPoint - input;
		this.integralAccumulation += error;

		double proportionalTerm = error * kP;
		double integralTerm = kI * integralAccumulation;
		double derivativeTerm = kD * (error - previousError);

		this.previousError = error;

		return proportionalTerm + integralTerm + derivativeTerm;
	}

	// Resets values that are accumulated within the PIDController
	public void resetAccumulatedValues()
	{
		integralAccumulation = 0;
		previousError = 0;
	}
}
