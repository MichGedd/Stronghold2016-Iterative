package org.usfirst.frc.team1360.robot.teleop;

import org.usfirst.frc.team1360.robot.IO.HumanInput;
import org.usfirst.frc.team1360.robot.IO.RobotOutput;

public class TeleopPivot implements TeleopComponent {

	private static TeleopPivot instance;
	private RobotOutput robotOutput;
	private HumanInput humanInput;
	
	private TeleopPivot()
	{
		this.robotOutput = RobotOutput.getInstance();
		this.humanInput = HumanInput.getInstance();
	}
	
	public static TeleopPivot getInstance()
	{
		if(instance == null)
		{
			instance = new TeleopPivot();
		}
		
		return instance;
	}
	
	@Override
	public void calculate() {
		// TODO Auto-generated method stub
		robotOutput.pivot(-this.humanInput.getOperatorPivot() * 0.45);
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub

	}

}
