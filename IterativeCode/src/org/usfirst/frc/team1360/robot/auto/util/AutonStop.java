package org.usfirst.frc.team1360.robot.auto.util;

import org.usfirst.frc.team1360.robot.auto.AutonCommand;
import org.usfirst.frc.team1360.robot.auto.AutonControl;
import org.usfirst.frc.team1360.robot.auto.RobotSubsystems;

public class AutonStop extends AutonCommand {
	
    public AutonStop() {
        super(RobotSubsystems.UTIL);
    }
    
    public boolean calculate() {
        AutonControl.getInstance().stop();
        return true;
    }

	@Override
	public void override() {
		// nothing to do
		
	}

}
