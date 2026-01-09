// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {

  private final XRPMotor leftMotor = new XRPMotor(0);
  private final XRPMotor rightMotor = new XRPMotor(1);             // sets the instance variables left and right motor to the corresponding motors
  private final Encoder leftEncoder = new Encoder(4,5);
  private final Encoder rightEncoder = new Encoder(6,7);   // encoders track distances via revolutions
  private final double wheelDiameter = 2.3622;  // inches
  private final double trackWidth = 6.1;        // inches
  private final double pulsesPerRev = 585;
  private final double circumference = Math.PI * wheelDiameter;           // inches
  private final double distancePerPulse = circumference / pulsesPerRev;   // inches
  // can use "getDistancePerPulse" instead but this is technical

  public Drivebase() {
    leftEncoder.setDistancePerPulse(distancePerPulse);
    rightEncoder.setDistancePerPulse(distancePerPulse);
    // sets the distance per pulse
    // happens automatically - like init
    rightMotor.setInverted(true);
    }

  public void driveForwardAmount(double distance) {
    if (((leftEncoder.getDistance() + rightEncoder.getDistance()) / 2 ) > distance) {
      leftMotor.stopMotor();
      rightMotor.stopMotor();
      // (double distance) is a script variable
    }
    // drive forward until # distance
  }

  public void resetEncoders(){
    leftEncoder.reset();
    rightEncoder.reset();
    // reset it so distance doesn't save between on/off periods
  }

  public void driveForward(){
    leftMotor.set(.5);
    rightMotor.set(.5);
  }
}