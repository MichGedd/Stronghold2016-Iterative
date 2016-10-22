package org.usfirst.frc.team1360.robot.auto.mode.step1;

import org.usfirst.frc.team1360.robot.auto.AutonOverride;
import org.usfirst.frc.team1360.robot.auto.RobotSubsystems;
import org.usfirst.frc.team1360.robot.auto.drive.DriveForward;
import org.usfirst.frc.team1360.robot.auto.drive.DriveWait;
import org.usfirst.frc.team1360.robot.auto.mode.AutonBuilder;
import org.usfirst.frc.team1360.robot.auto.mode.AutonMode;
import org.usfirst.frc.team1360.robot.auto.pivot.PivotPID;
import org.usfirst.frc.team1360.robot.auto.util.AutonWait;

public class LowBar implements AutonMode {
	
	@Override
	public void addToMode(AutonBuilder ab) {
	 ab.addCommand(new PivotPID(0));
	 ab.addCommand(new AutonWait(500));
	 ab.addCommand(new DriveForward(1000, -0.5));// sets drive to full speed
	 ab.addCommand(new DriveWait());
	 ab.addCommand(new AutonWait(2000));
	 ab.addCommand(new AutonOverride(RobotSubsystems.ARM));
	 ab.addCommand(new PivotPID(145));
	 ab.addCommand(new AutonWait(10000));
	}
}
