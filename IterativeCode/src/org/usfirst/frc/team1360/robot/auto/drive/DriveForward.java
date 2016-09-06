package org.usfirst.frc.team1360.robot.auto.drive;

import org.usfirst.frc.team1360.robot.IO.RobotOutput;
import org.usfirst.frc.team1360.robot.auto.AutonCommand;
import org.usfirst.frc.team1360.robot.auto.RobotSubsystems;

public class DriveForward extends AutonCommand {

	private RobotOutput robotOutput;
	
	public DriveForward(RobotSubsystems type) {
		super(RobotSubsystems.DRIVE);
		
		this.robotOutput = RobotOutput.getInstance();
	}

	@Override
	public boolean calculate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void override() {
		
	}

}
