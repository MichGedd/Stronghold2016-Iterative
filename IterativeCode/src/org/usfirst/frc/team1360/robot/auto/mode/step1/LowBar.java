package org.usfirst.frc.team1360.robot.auto.mode.step1;

import org.usfirst.frc.team1360.robot.auto.drive.DriveForward;
import org.usfirst.frc.team1360.robot.auto.drive.DriveWait;
import org.usfirst.frc.team1360.robot.auto.mode.AutonBuilder;
import org.usfirst.frc.team1360.robot.auto.mode.AutonMode;
import org.usfirst.frc.team1360.robot.auto.pivot.PivotPID;
import org.usfirst.frc.team1360.robot.auto.util.AutonWait;

public class LowBar implements AutonMode {
	
	@Override
	public void addToMode(AutonBuilder ab) {
	 ab.addCommand(new DriveForward(3000, -0.5));// sets drive to full speed
	 ab.addCommand(new PivotPID(0));
	 ab.addCommand(new DriveWait()); // waits
	}
}
