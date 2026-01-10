// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj.xrp.XRPOnBoardIO;
import edu.wpi.first.wpilibj.xrp.XRPRangefinder;
import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import frc.robot.VexV5Controller;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.Subsystems.Drivebase;
import frc.robot.Subsystems.Arm;

public class Robot extends TimedRobot {
  Drivebase m_driveBase = new Drivebase();
  Arm m_Arm = new Arm();
  XboxController m_controller = new XboxController(0);
  //These make a copy of the subsystems that are able to be used

  @Override
  public void teleopInit(){ 
    
    m_driveBase.resetEncoders();
    /* m_driveBase is a copy of Drivebase (makes it public, not private)
    resetEncoders is a function within Drivebase - it is being called*/
  }

  @Override
  public void teleopPeriodic(){

    m_driveBase.twoDirectionDrive();
    // double leftSpeed = -m_controller.getLeftY();
    // m_driveBase.driveForward(10);
    // m_driveBase.driveForwardAmount(10);

    // m_Arm.upAndDown();
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