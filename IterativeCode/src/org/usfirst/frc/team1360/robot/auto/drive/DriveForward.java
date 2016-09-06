package org.usfirst.frc.team1360.robot.auto.drive;

import org.usfirst.frc.team1360.robot.IO.RobotOutput;
import org.usfirst.frc.team1360.robot.auto.AutonCommand;
import org.usfirst.frc.team1360.robot.auto.RobotSubsystems;

public class DriveForward extends AutonCommand {

	private RobotOutput robotOutput;
	
	public DriveForward(long timeout) {
		super(RobotSubsystems.DRIVE, timeout);
		
		this.robotOutput = RobotOutput.getInstance();
	}

	@Override
	public boolean calculate() {
		this.robotOutput.tankDrive(0.5, 0.5);
		return false;
	}

	@Override
	public void override() {
		this.robotOutput.tankDrive(0, 0);
	}

}
