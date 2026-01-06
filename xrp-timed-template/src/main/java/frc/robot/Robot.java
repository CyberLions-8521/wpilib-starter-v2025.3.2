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
  private XRPMotor m_motorL = new XRPMotor(0);
  private XRPMotor m_motorR = new XRPMotor(1);

  private Encoder m_encoderL = new Encoder(4,5);
  private Encoder m_encoderR = new Encoder(6,7);

  private double wheelDiameter = 2.3622;
  private double wheelCircumference = wheelDiameter * Math.PI;
  private double countsPerWheelRev = 585;
  private double convFactor = wheelCircumference / countsPerWheelRev;

  private double trackWidth = 6.1;
  private double speed = 0.5;

  public Robot() {}

  @Override
  public void teleopInit()
  {
    // type code in here - runs once
    m_motorR.setInverted(true);
    m_encoderL.reset();
    m_encoderL.setDistancePerPulse(convFactor);
    m_encoderR.reset();
    m_encoderR.setDistancePerPulse(convFactor);
  }

  @Override
  public void teleopPeriodic()
  {
    // type code in here - runs forever
    driveDist(25);
    turnLeft();
    driveDist(5);
    turnRight();

  }

  public void driveDist(double d){
    double targetDistance = d * convFactor;
    resetEncoders();
    while(m_encoderL.getDistance() < targetDistance && m_encoderR.getDistance() < targetDistance){
      m_motorL.set(speed);
      m_motorR.set(speed);
    }
    brake();
  }

  public void turnRight(){
    resetEncoders();
    while(m_encoderL.getDistance() < (trackWidth / 2) * convFactor){
      m_motorL.set(speed);
      m_motorR.set(-speed);
    }
    brake();
  }

  public void turnLeft(){
    resetEncoders();
    while(m_encoderR.getDistance() < (trackWidth / 2) * convFactor){
      m_motorL.set(-speed);
      m_motorR.set(speed);
    }
    brake();
  }

  public void resetEncoders(){
    m_encoderL.reset();
    m_encoderR.reset();
  }

  public void brake() {
    m_motorL.set(0);
    m_motorR.set(0);
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
