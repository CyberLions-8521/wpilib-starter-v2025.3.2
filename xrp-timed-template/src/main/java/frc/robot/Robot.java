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
import edu.wpi.first.wpilibj.xrp.XRPServo;
import frc.robot.VexV5Controller;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.xrp.XRPServo;

import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Arm;

public class Robot extends TimedRobot {
  Drivebase m_driveBase = new Drivebase();
  Arm m_Arm = new Arm();
  @Override
  public void teleopInit(){ 

    // type code in here - runs once
    m_driveBase.getLeftEncoder().setDistancePerPulse(m_driveBase.getDistancePerPulse());
    m_driveBase.getRightEncoder().setDistancePerPulse(m_driveBase.getDistancePerPulse());
    // sets distance per pulse (tick) to the given value for distancePerPulse
    
    m_driveBase.getLeftEncoder().reset();
    m_driveBase.getRightEncoder().reset();
    // reset it so distance doesn't save between on/off periods
  }

  @Override
  public void teleopPeriodic(){
    m_driveBase.getLeftMotor().set(.5);
    m_driveBase.getRightMotor().set(.5);

    if (((m_driveBase.getLeftEncoder().getDistance() + m_driveBase.getRightEncoder().getDistance()) / 2 ) > 10) {
      m_driveBase.getLeftMotor().stopMotor();
      m_driveBase.getRightMotor().stopMotor();
    }

    if (getPosition() = 0){
      m_Arm.getServo().setPosition(1);

    }

    if (m_Arm.getPosition() = 1){
      m_Arm.getServo().setPosition(0);
    }
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