/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.TimedRobot;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot implements DrivetrainInterface {
  
  AutoStuffDoer marcus = new AutoStuffDoer(this);
  
  Drivetrain drivetrain = new Drivetrain();
  
  Joystick gamepadDriver = new Joystick(1);
  
  Joystick gamepadOperator = new Joystick(2);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {}

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    marcus.autoInit();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    marcus.runAuto();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

  drivetrain.arcadeDrive(gamepadDriver.getX() * .7, gamepadDriver.getY() * .7);



  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {}

  @Override
  public void setLeftRightDriveSpeed(double left, double right) {
    drivetrain.setLeftRightDriveSpeed(left, right);
  }

  @Override
  public void setArcadeDriveSpeed(double speed, double turn) {
    drivetrain.setArcadeDriveSpeed(speed, turn);
  }

  @Override
  public double getInchesTraveled() {
    return drivetrain.getInchesTraveled();
  }

  @Override
  public double getCurrentAngle() {
    return drivetrain.getCurrentAngle();
  }

  @Override
  public void resetEncodersAndGyro() {
    drivetrain.resetEncodersAndGyro();
  }






}
