package org.usfirst.frc.team1360.robot.auto.mode.step1;

import org.usfirst.frc.team1360.robot.auto.drive.DriveForward;
import org.usfirst.frc.team1360.robot.auto.mode.AutonBuilder;
import org.usfirst.frc.team1360.robot.auto.mode.AutonMode;
import org.usfirst.frc.team1360.robot.auto.util.AutonWait;

public class LowBar implements AutonMode {
	
	@Override
	public void addToMode(AutonBuilder ab) {
	 ab.addCommand(new DriveForward(3000, 1));// sets drive to full speed
	 ab.addCommand(new AutonWait(5000)); // waits 5 seconds
	}
}
