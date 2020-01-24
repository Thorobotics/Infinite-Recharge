/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.Subsystems.Drive;
import frc.robot.Subsystems.OI;
import frc.robot.Subsystems.RobotMap;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  OI m_OI;
  RobotMap robotMap;
  Drive drive;
  private final int X_AXIS = 0;
  Ruble
  private final int Y_AXIS = 1;
  boolean intakeDebounce = false;
  boolean intakeToggle = false;
  boolean colorDebounce = false;
  boolean colorToggle = false;

  @Override
  public void robotInit() {
    m_OI = new OI();
    robotMap = new RobotMap();
    drive = new Drive();
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    //boolean intakeButton = this.m_OI.masterController.getStartButtonPressed();
    boolean colorButton = this.m_OI.masterController.getYButtonPressed();
    this.drive.drive(this.robotMap.getChassis(), this.m_OI.masterController.getRawAxis(this.X_AXIS), this.m_OI.masterController.getRawAxis(this.Y_AXIS));
    
   /* if (intakeButton){
      if (!this.intakeDebounce){
        this.intakeDebounce = true;
        this.intakeToggle = !this.intakeToggle;
      }
    } else {
      this.intakeDebounce = false;
    } 
    this.robotMap.getIntake().set( this.intakeToggle ?  0.05 : 0.0);
    //This block turns intake on/off */

    if (colorButton){
      if (!this.colorDebounce){
        this.colorDebounce = true;
        this.colorToggle = !this.colorToggle;
      }
    } else {
      this.colorDebounce = false;

      this.m_OI.masterController.setRumble(RumbleType.kLeftRumble, 1);
    } 
    //this block turn colorsensor on/off (Remember to put the actual execution of said code in ALLAN!)
      
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
