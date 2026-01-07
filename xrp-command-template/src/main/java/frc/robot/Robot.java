// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
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
// Subsystems
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Arm;


public class Robot extends TimedRobot {

  Drivebase m_driveBase = new Drivebase();
  Arm m_servo = new Arm();

  private enum Autostate {
    FORWARD1, TURN1, FORWARD2, TURN2, FORWARD3, TURN3, FORWARD4, TURN4, FORWARD5, DONE
  }

  private Autostate currentState = Autostate.FORWARD1;

  public Robot() {}

  @Override
  public void teleopInit()
  {
    m_driveBase.getLeftEncoder().setDistancePerPulse(m_driveBase.getdistancePerPulse());
    m_driveBase.getRightEncoder().setDistancePerPulse(m_driveBase.getdistancePerPulse());

    m_driveBase.restartDistance();
  }


  @Override
  public void teleopPeriodic()
  {   /* 
      switch (currentState) { // in theory makes a square
        case FORWARD1:
                if (m_driveBase.moveForward(10)) {
                  m_driveBase.restartDistance();
                  currentState = Autostate.TURN1;
                }
                break;
        case TURN1:
                if (m_driveBase.rotateRight(4)) {
                  m_driveBase.restartDistance();
                  currentState = Autostate.FORWARD2;
                }
                break;
        case FORWARD2:
                if (m_driveBase.moveForward(10)) {
                  m_driveBase.restartDistance();
                  currentState = Autostate.TURN2;
                }
                break;
        case TURN2:
                if (m_driveBase.rotateRight(4)) {
                  m_driveBase.restartDistance();
                  currentState = Autostate.FORWARD3;
                }
                break;
        case FORWARD3:
                if (m_driveBase.moveForward(10)) {
                  m_driveBase.restartDistance();
                  currentState = Autostate.TURN3;
                }
                break;
        case TURN3:
              if (m_driveBase.rotateRight(4)) {
                m_driveBase.restartDistance();
                currentState = Autostate.FORWARD4;
              }
              break;
        case FORWARD4:
              if (m_driveBase.moveForward(10)) {
                m_driveBase.restartDistance();
                currentState = Autostate.TURN4;
              }
              break;
        case TURN4:
              if (m_driveBase.rotateRight(4)) {
                m_driveBase.restartDistance();
                currentState = Autostate.FORWARD5;
              }
              break;
        case FORWARD5:
              if (m_driveBase.moveForward(10)) {
                m_driveBase.restartDistance();
                currentState = Autostate.DONE;
              }
        case DONE:
              m_driveBase.stopAllMotor();
              break;
      }
      */
      
      m_servo.getServo().setPosition(0);

    }
}