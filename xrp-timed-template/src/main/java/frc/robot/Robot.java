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


public class Robot extends TimedRobot {
  private XRPMotor lmotor = new XRPMotor(0);
  private XRPMotor rmotor = new XRPMotor(1);

  private Encoder leftEncoder = new Encoder(4,5);
  private Encoder rightEncoder = new Encoder(6,7);
  
  private XRPGyro gyro = new XRPGyro();

  private double wheelDiameter = 2.3622;
  private double trackWidth = 6.1;
  private double pulsesPerRev = 585;
  private double circumference = Math.PI * wheelDiameter;
  private double distancePerPulse = circumference / pulsesPerRev;

  private double avgDistance;
  private double GyroAngleZ;
  private double speed = 0.5;
  private double turnDistance;

  private enum Autostate {
    FORWARD1, TURN1, FORWARD2, TURN2, FORWARD3, TURN3, FORWARD4, TURN4, FORWARD5, DONE
  }

  private Autostate currentState = Autostate.FORWARD1;

  public Robot() {
    rmotor.setInverted(true);
  }

  public void restartDistance() { // resets the Distance Encoder as whole
    leftEncoder.reset();
    rightEncoder.reset();
  }
  public void stopAllMotor() { // stops both Motors (just easier to use instead of repeating commands)
    rmotor.stopMotor();
    lmotor.stopMotor();
  }

  public boolean moveForward(double d) { // Forward command is based on inches I believe
    avgDistance = ((leftEncoder.getDistance() + rightEncoder.getDistance()) / 2);

    if ( avgDistance >= d) {
      stopAllMotor();
      return true;
    } else {
    lmotor.set(speed);
    rmotor.set(speed);
      return false;
    }
  }

  public boolean rotateRight(double d) { // figured out the turn distance
    avgDistance = ((Math.abs(leftEncoder.getDistance()) + Math.abs(rightEncoder.getDistance())) / 2 );
    turnDistance = π * trackWidth  *( d / 360)
  if ( avgDistance >= turnDistance) {
    stopAllMotor();
    return true;
  } else {
    rmotor.set(-speed);
    lmotor.set(speed);
    return false;
  }
  }

  public boolean rotateLeft(double d) { // Figured out the math for turnDistance
      avgDistance = ((Math.abs(leftEncoder.getDistance()) + Math.abs(rightEncoder.getDistance())) / 2 );
    if ( avgDistance >= turnDistance) {
      stopAllMotor();
      return true;
    } else {
      rmotor.set(speed);
      lmotor.set(-speed);
      return false;
    }
  }

  @Override
  public void teleopInit()
  {
    leftEncoder.setDistancePerPulse(distancePerPulse);
    rightEncoder.setDistancePerPulse(distancePerPulse);

    restartDistance();
  }

  public void autonomousPeriodic() 
  {
     switch (currentState) { // in theory makes a square
        case FORWARD1:
                if (moveForward(10)) {
                  restartDistance();
                  currentState = Autostate.TURN1;
                }
                break;
        case TURN1:
                if (rotateRight(90)) {
                  restartDistance();
                  currentState = Autostate.FORWARD2;
                }
                break;
        case FORWARD2:
                if (moveForward(10)) {
                  restartDistance();
                  currentState = Autostate.TURN2;
                }
                break;
        case TURN2:
                if (rotateRight(90)) {
                  restartDistance();
                  currentState = Autostate.FORWARD3;
                }
                break;
        case FORWARD3:
                if (moveForward(10)) {
                  restartDistance();
                  currentState = Autostate.TURN3;
                }
                break;
        case TURN3:
              if (rotateRight(90)) {
                restartDistance();
                currentState = Autostate.FORWARD4;
              }
              break;
        case FORWARD4:
              if (moveForward(10)) {
                restartDistance();
                currentState = Autostate.TURN4;
              }
              break;
        case TURN4:
              if (rotateRight(90)) {
                restartDistance();
                currentState = Autostate.FORWARD5;
              }
              break;
        case FORWARD5:
              if (moveForward(10)) {
                restartDistance();
                currentState = Autostate.DONE;
              }
              break;
        case DONE:
              stopAllMotor();
              break;
      }
  }
  @Override
  public void teleopPeriodic()
  {

  }
}