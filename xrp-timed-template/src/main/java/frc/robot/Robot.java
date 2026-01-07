// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import javax.lang.model.util.ElementScanner14;

import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj.xrp.XRPOnBoardIO;
import edu.wpi.first.wpilibj.xrp.XRPRangefinder;
import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj.xrp.XRPServo;
import frc.robot.VexV5Controller;

import frc.robot.subsystems.Drivebase;


public class Robot extends TimedRobot {
  Drivebase Ruby = new Drivebase(); 

  public Robot() {
  }


  @Override
  public void teleopInit()
  {
    Ruby.resetEncoders();
    // type code in here - runs once
  }


  //.setInverted(true)
  @Override
  public void teleopPeriodic()
  {
    Ruby.driveDist(20); 
    Ruby.resetEncoders();
    Ruby.turn(20);
  }









  /* // Optional robot methods - uncomment to use
  @Override
  public void robotPeriodic() {}
  @Override
  public void autonomousInit() {}
  @Override
  public void autonomousPeriodic() {}
  @Override
  public void disabledInit() {}
  @Override
  public void disabledPeriodic() {}
  @Override
  public void testInit() {}
  @Override
  public void testPeriodic() {}
  */
}
