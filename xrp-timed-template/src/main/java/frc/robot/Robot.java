// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj.xrp.XRPMotor; //important for motors
import edu.wpi.first.wpilibj.xrp.XRPOnBoardIO;
import edu.wpi.first.wpilibj.xrp.XRPRangefinder;
import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj.xrp.XRPServo; //same as a motor but can only turn 180 deg
import frc.robot.VexV5Controller;


public class Robot extends TimedRobot {
  XRPMotor m_leftMotor = new XRPmotor(0); /*creates XRPMotor object*/
  XRPMotor m_rightMotor = new XRPmotor(1); /*creates XRPMotor object*/
  XboxController m_controller = new XboxController(0);
  XRPServo m_servo = new XRPServo(4);
  public Robot() {}

  @Override
  public void teleopInit()
  {
    // type code in here - runs once
    m_rightMotor.setInverted(true); //reverses the rotation, so it can be treated similar to left in the code while automatically inverting
    m_servo.setPosition(0.5); //moves to 90deg
  }

  @Override
  public void teleopPeriodic()
  {
    // type code in here - runs forever
    double leftSpeed = -m_controller.getLeftY(); //controls how fast the motor based on left joy stick up/down
    double rightSpeed = -m_controller.getRightY(); //controls how fast the motor based on right joy stick up/down
    
    m_leftMotor.set(leftSpeed);
    m_leftMotor.set(rightSpeed);

    if(m_controller.getAButton()) {
      m_servo.setPosition(1.0); //goes to 180 deg/one end + .setAngle(#) can be used to go to a specific angle
    } else {
      m_servo.setPosition(0.0); //goes to 0 deg/other end
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
