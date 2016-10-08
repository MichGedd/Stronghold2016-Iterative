
package org.usfirst.frc.team1360.robot;

import org.usfirst.frc.team1360.robot.IO.HumanInput;
import org.usfirst.frc.team1360.robot.IO.RobotOutput;
import org.usfirst.frc.team1360.robot.IO.SensorInput;
import org.usfirst.frc.team1360.robot.teleop.TeleopControl;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    
    private RobotOutput robotOutput;
    private HumanInput humanInput;
    private TeleopControl teleopControl;
    private SensorInput sensorInput;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	this.robotOutput = RobotOutput.getInstance();
    	this.humanInput = HumanInput.getInstance();
    	this.teleopControl = TeleopControl.getInstance();
    	this.sensorInput = SensorInput.getInstance();
    	
    }
    
    public void disabledInit()
    {
    	this.robotOutput.stopAll();
    	this.teleopControl.disable();
    }
    

    public void autonomousInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        this.teleopControl.runCycle();
        this.sensorInput.calculate();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
