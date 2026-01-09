// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.xrp.XRPServo;

public class DriveBase extends SubsystemBase {
  // XRPMotor
  private final XRPMotor lmotor = new XRPMotor(0);
  private final XRPMotor rmotor = new XRPMotor(1);
  // Encoder
  private final Encoder leftEncoder = new Encoder(4,5);
  private final Encoder rightEncoder = new Encoder(6,7);
  // Gyro
  private final XRPGyro Gyro = new XRPGyro();
  // Wheel Vars
  private final double wheelDiameter = 2.3622;
  private final double trackWidth = 6.1;
  private final double pulsesPerRev = 585;
  private double circumference = Math.PI * wheelDiameter;
  private double distancePerPulse = circumference / pulsesPerRev;
  // constants
  private double avgDistance;
  private double TurnDistance;
  private double GyroAngleZ;
  private double speed = 0.5;

  public DriveBase() { rmotor.setInverted(true); }
    // Getters
    public double getdistancePerPulse() { return distancePerPulse; }
    public Encoder getLeftEncoder() { return leftEncoder; }
    public Encoder getRightEncoder() { return rightEncoder; }

    // restartDistance() restarts the Encoder Distance of both motors 
    public void restartDistance() { leftEncoder.reset(); rightEncoder.reset(); }
    public void stopAllMotor() { rmotor.set(0); lmotor.set(0); }
    public void restartGyroDistance() { Gyro.reset(); }


    // moveForwarsd
    public boolean moveForward(double d) { 
      avgDistance = ((leftEncoder.getDistance() + rightEncoder.getDistance()) / 2);
  
      if ( avgDistance >= d) { stopAllMotor(); return true; } 
      else { lmotor.set(speed); rmotor.set(speed); return false; }

    }
    public boolean rotateLeft(double d) { // command's rotation ratio is 5 inches
      avgDistance = ((Math.abs(leftEncoder.getDistance()) + Math.abs(rightEncoder.getDistance())) / 2 );
      TurnDistance = Math.PI * trackWidth * (d / 360);
    if ( avgDistance >= d) {
      stopAllMotor();
      return true;
    } else {
      rmotor.set(speed);
      lmotor.set(-speed);
      return false;
    }
  }
  public boolean rotateRight(double d) { // command's rotation ratio is 5 inches
  avgDistance = ((Math.abs(leftEncoder.getDistance()) + Math.abs(rightEncoder.getDistance())) / 2 );
  if ( avgDistance >= d) {
  stopAllMotor();
  return true;
    } else {
  rmotor.set(-speed);
  lmotor.set(speed);
  return false;
    }
  }
  

    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
