package org.usfirst.frc.team1360.robot.teleop;

import org.usfirst.frc.team1360.robot.IO.HumanInput;
import org.usfirst.frc.team1360.robot.IO.RobotOutput;
import org.usfirst.frc.team1360.robot.util.pid.PIDSpeedController;

public class TeleopPivot implements TeleopComponent {

	private static TeleopPivot instance;
	private RobotOutput robotOutput;
	private HumanInput humanInput;
	
	private PIDSpeedController pivotController;
	
	private TeleopPivot()
	{
		this.robotOutput = RobotOutput.getInstance();
		this.humanInput = HumanInput.getInstance();
		this.pivotController =  new PIDSpeedController(1, 0.1, 0.1, 5);
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
		
		double speed = -this.humanInput.getOperatorPivot();
		
		if(Math.abs(speed) > 0.2)
		{
			robotOutput.pivot(speed * 0.45);
		}
		else if (humanInput.getOperatorIntakeHeight())
		{
			this.pivotController.SetSetpoint(0);
		} 
		else if (humanInput.getOperatorBatterShot())
		{
			this.pivotController.SetSetpoint(1);
		}
		else if (humanInput.getOperatorOuterworksShot())
		{
			this.pivotController.SetSetpoint(0.5);
		} 
		else
		{
			robotOutput.pivot(0);
		}
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		this.robotOutput.pivot(0);
	}

}
