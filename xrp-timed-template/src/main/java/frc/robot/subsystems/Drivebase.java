// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {

  private XRPMotor leftMotor = new XRPMotor(0);
  private XRPMotor rightMotor = new XRPMotor(1);
  // sets the instance variables left and right motor to the corresponding motors
  private Encoder leftEncoder = new Encoder(4,5);
  private Encoder rightEncoder = new Encoder(6,7);
  // encoders track distances via revolutions

  private double wheelDiameter = 2.3622;
  private double trackWidth = 6.1;
  private double pulsesPerRev = 585;
  private double circumference = Math.PI * wheelDiameter;
  private double distancePerPulse = circumference / pulsesPerRev;
  // can use "getDistancePerPulse" instead
  /** Creates a new Drivebase. */

  public void driveForward(double distance) {
    if (((leftEncoder.getDistance() + rightEncoder.getDistance()) / 2 ) > distance) {
      leftMotor.stopMotor();
      rightMotor.stopMotor();
    }
  }

  public XRPMotor getLeftMotor(){
    return leftMotor;
  }

  public XRPMotor getRightMotor(){
    return rightMotor;
  }

  public Encoder getLeftEncoder(){
    return leftEncoder;
  }

  public Encoder getRightEncoder(){
    return rightEncoder;
  }

  public Drivebase() {
    rightMotor.setInverted(true);
  }

  public double getDistancePerPulse(){
    return distancePerPulse;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
