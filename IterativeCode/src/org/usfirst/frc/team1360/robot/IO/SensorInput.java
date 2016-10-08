package org.usfirst.frc.team1360.robot.IO;

import org.usfirst.frc.team1360.robot.teleop.TeleopControl;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SensorInput {
	private static SensorInput instance;
	private RobotOutput robotOutput;
	private TeleopControl teleopControl;
	
	private Encoder pivotEncoder;
	private AnalogInput leftSide;
	private AnalogInput rightSide;
	
	// TODO: Change back to private.
	private SensorInput()
	{
		this.robotOutput = RobotOutput.getInstance();
		this.pivotEncoder = new Encoder(3, 2);
		this.rightSide = new AnalogInput(0);
		this.leftSide = new AnalogInput(1);
		
	}
	
	public static SensorInput getInstance()
	{
		if(instance == null)
		{
			SensorInput.instance = new SensorInput();
		}
		
		return instance;
	}
	
	public void calculate()
	{
		SmartDashboard.putNumber("Pivot Encoder: ", this.getPivotEncoder());
		SmartDashboard.putNumber("Left Speed", this.getLeftSpeed());
		SmartDashboard.putNumber("Right Speed", this.getRightSpeed());
	}
	
	public double getPivotEncoder()
	{
		return pivotEncoder.get();
	}
	
	public double getLeftSpeed()
	{
		return leftSide.getValue();
	}
	
	public double getRightSpeed()
	{
		return rightSide.getValue();
	}
	
	public void reset()
	{
		pivotEncoder.reset();
	}
	
}
