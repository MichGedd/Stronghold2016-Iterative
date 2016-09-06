package org.usfirst.frc.team1360.robot.IO;

import org.usfirst.frc.team1360.robot.util.XboxRemote;

public class HumanInput {
	//Dont know what this is for
	private static HumanInput instance;
	
	//These two are the Driver and Operator remotes
	private XboxRemote driver;
	private XboxRemote operator;
	
	
	//Initialize the driver and operator remotes
	private HumanInput()
	{
		this.driver = new XboxRemote(0);
		this.operator = new XboxRemote(1);
	}
	
	public static HumanInput getInstance()
	{
		if(instance == null)
		{
			HumanInput.instance = new HumanInput();
		}
		
		return instance;
	}
	
	//Driver
	public double getDriverLeftTrigger()
	{
		return this.driver.getLeftTrigger();
	}
	
	public double getDriverRightTrigger()
	{
		return this.driver.getRightTrigger();
	}
	
	public boolean getDriverActuate()
	{
		return this.driver.getButtonA();
	}
	
	public double getDriverLeftX()
	{
		return this.driver.getLeftXAxis();
	}
	
	public double getDriverLeftY()
	{
		return this.driver.getLeftYAxis();
	}
	
	//Operator
	public double getOperatorInatke()
	{
		return this.operator.getLeftTrigger();
	}
	
	public double getOperatorOutake()
	{
		return this.operator.getRightTrigger();
	}
	
	public double getOperatorPivot()
	{
		return this.operator.getLeftXAxis();
	}
	
}