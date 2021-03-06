package org.usfirst.frc.team1360.robot.teleop;

import org.usfirst.frc.team1360.robot.IO.HumanInput;
import org.usfirst.frc.team1360.robot.IO.RobotOutput;
import org.usfirst.frc.team1360.robot.IO.SensorInput;
import org.usfirst.frc.team1360.robot.util.Debugger;
import org.usfirst.frc.team1360.robot.util.OrbitBangBang;

public class TeleopShoot implements TeleopComponent{

	private static TeleopShoot instance;
	private RobotOutput robotOutput;
	private HumanInput humanInput;
	private SensorInput sensorInput;
	
	private OrbitBangBang LSide;
	private OrbitBangBang RSide;
	
	private long shooterTime = 500;
	private boolean autoShoot = false;
	private boolean autoStop = false;
	
	private TeleopShoot()
	{
		this.robotOutput = robotOutput.getInstance();
		this.humanInput = humanInput.getInstance();	
		this.sensorInput = sensorInput.getInstance();
		this.LSide = new OrbitBangBang(1.0, 0.5);
		this.RSide = new OrbitBangBang(1.0, 0.5);
	}
	
	public static TeleopShoot getInstance()
	{
		if(instance == null)
		{
			instance = new TeleopShoot();
		}
		return instance;
	}
	
	@Override
	public void calculate() 
	{
		
		double LSpeed = this.humanInput.getOperatorInatke() - this.humanInput.getOperatorOutake();
		double RSpeed = this.humanInput.getOperatorInatke() - this.humanInput.getOperatorOutake();
	
		if(humanInput.getOperatorIntakeHeight())
		{
			this.robotOutput.setShooter(LSpeed, RSpeed);			
			if(LSpeed > 0)
			{
				if(this.sensorInput.getLeftSpeed() > 0.5 && this.sensorInput.getRightSpeed() > 0.5)
				{
					this.robotOutput.intake(LSpeed);
				}
				else
				{
					this.robotOutput.intake(0);
				}
			}
			else
			{
				if(this.sensorInput.getLeftSpeed() > 0.5 && this.sensorInput.getRightSpeed() > 0.5)
				{
					this.robotOutput.intake(LSpeed);
				}
				else
				{
					this.robotOutput.intake(0);
				}
			}

		} 
		else if (humanInput.getOperatorShoot())
		{
			//this.robotOutput.setShooter(0.5, 0.5);
			this.LSide.setTarget(0.9);
			this.LSide.setHighLow(1.0, 0.8);
			this.RSide.setTarget(0.9);
			this.RSide.setHighLow(1, 0.8);
			
			this.robotOutput.setShooter(LSide.calculate(this.sensorInput.getLeftSpeed()), RSide.calculate(this.sensorInput.getRightSpeed()));
			//this.robotOutput.setShooter(1, 1);
			this.robotOutput.intake(LSpeed);
		} 
		else if (humanInput.getOperatorLowgoal())
		{
			this.LSide.setTarget(0.9);
			this.LSide.setHighLow(1.0, 0.8);
			this.RSide.setTarget(0.9);
			this.RSide.setHighLow(1, 0.8);
			
			this.robotOutput.setShooter(LSide.calculate(this.sensorInput.getLeftSpeed()), RSide.calculate(this.sensorInput.getRightSpeed()));
			//this.robotOutput.setShooter(1, 1);
			this.robotOutput.intake(LSpeed);
		}
		else if(Math.abs(LSpeed) > 0.3 || Math.abs(RSpeed) > 0.3 && this.autoShoot == false)
		{
			this.robotOutput.setShooter(LSpeed, RSpeed);
			this.robotOutput.intake(LSpeed);
		}
		else
		{
			if(this.autoShoot == false)
			{
				this.robotOutput.setShooter(0, 0);
				this.robotOutput.intake(0);
			}
		}
		
		if(this.humanInput.getOperatorRevUntilShoot())
		{
				this.LSide.setTarget(0.9);
				this.LSide.setHighLow(1.0, 0.8);
				this.RSide.setTarget(0.9);
				this.RSide.setHighLow(1, 0.8);
				
				this.robotOutput.setShooter(LSide.calculate(this.sensorInput.getLeftSpeed()), RSide.calculate(this.sensorInput.getRightSpeed()));
				this.shooterTime = 100;
				this.autoShoot = true;
			
		} 
		else if (this.autoShoot == true && Math.abs(LSpeed) > 0.5)
		{
			this.autoStop = true;
		}
		
		if(this.autoStop)
		{
			shooterTime -= 1;
			
			if(this.shooterTime <= 0)
			{
				this.robotOutput.intake(0);
				this.robotOutput.setShooter(0, 0);
				this.autoShoot = false;
				this.autoStop = false;
			}
			else 
			{
				this.robotOutput.intake(1);
			}
		}
		
		Debugger.println(shooterTime);
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		this.robotOutput.setShooter(0, 0);
	}

}
