// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
  private XRPMotor LeftMotor = new XRPMotor(0); 
  private XRPMotor RightMotor = new XRPMotor(1); 

  private Encoder LeftEncoder = new Encoder(6,7);
  private Encoder RightEncoder = new Encoder(4,5);

  double WheelDiameter = 2.3622; 
  double TrackWith = 6.1;
  double PulsePerRev = 585;

  double speed = 0.5; 

  double circumference = Math.PI * WheelDiameter;
  double DistPerPulse = circumference/PulsePerRev;


  /** Creates a new Drivebase. */
  public Drivebase() {
    LeftEncoder.setDistancePerPulse(DistPerPulse);
    RightEncoder.setDistancePerPulse(DistPerPulse);

    RightMotor.setInverted(true);
  }

  // driving a certain distance
  public void driveDist(double d) {
    if (getAverageDist() <= d) {
      moveForward();
    }
    else {
      LeftMotor.set(0);
      RightMotor.set(0);
    }
  }
  // turn d distance
  public void turn(double d) {
    if (getAverageDist() <= 10) {
      LeftMotor.set(0.5);
      RightMotor.set(-0.5);
    }
    else {
      stopMoving();
    }
    }

  // motors start moving
  public void moveForward() {
    LeftMotor.set(0.5);
    RightMotor.set(0.5);
  }

  // motors stop moving
  public void stopMoving() {
    LeftMotor.set(0);
    RightMotor.set(0);
  }

  // get the average distance/total distance 
  public double getAverageDist() {
    return (LeftEncoder.getDistance() + RightEncoder.getDistance()) / 2;
  }

  // reset the Encoders
  public void resetEncoders() {
    LeftEncoder.reset();
    RightEncoder.reset(); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
