// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// This CDriveBase is for Command Code
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;


public class CDriveBase extends SubsystemBase {
    // XRPMotor
  private final XRPMotor m_lmotor = new XRPMotor(0);
  private final XRPMotor m_rmotor = new XRPMotor(1);
  // Encoder
  private final Encoder m_leftEncoder = new Encoder(4,5);
  private final Encoder m_rightEncoder = new Encoder(6,7);
  // Gyro
  private final XRPGyro m_Gyro = new XRPGyro();
  // Wheel Vars
  private final double wheelDiameter = 2.3622;
  private final double trackWidth = 6.1;
  private final double pulsesPerRev = 585;
  private final double circumference = Math.PI * wheelDiameter;
  private final double DPP = circumference / pulsesPerRev;
  // changable constants
  private double avgDistance;
  private double currentAngle;
  private double abs_speed = 0.5;
    
  
  public CDriveBase() {
    m_rmotor.setInverted(true);

    m_rightEncoder.setDistancePerPulse(DPP);
    m_leftEncoder.setDistancePerPulse(DPP);

    resetEncoders();
    resetGyro();
  }

  public void resetEncoders() {
    m_rightEncoder.reset();
    m_leftEncoder.reset();
  }
  public void resetGyro() {
    m_Gyro.reset();
  }
  public double getAverageDistance() {
    return (Math.abs(m_rightEncoder.getDistance()) + Math.abs(m_leftEncoder.getDistance()) / 2.0);
  }

  public void moveForwardbyAmount(double inches) { 
      avgDistance = ((leftEncoder.getDistance() + rightEncoder.getDistance()) / 2);
      if ( avgDistance >= inches) { 
          stopAllMotor();
        } else { 
          lmotor.set(speed); 
          rmotor.set(speed);  
        }
    }
  public void Forward(double speed) {
      lmotor.set(speed);
      rmotor.set(speed);
    }
  public void Rotate(double AngleZ) {
      currentAngle = m_Gyro.getAngleZ();
  }

    public Command DriveForward(double speed) {
        return new RunCommand( () -> Forward(speed), this );
    }
    public Command DriveTurn(double degrees) { 
        return new RunCommand( () -> Rotation(abs_speed,), this);
    }

    public Command DriveForwardatDistance(double distance) {
        return new RunCommand( () -> moveForwardbyAmount(distance), this);
    }

    public Command MotorEnd(){

    }
  @Override
  public void periodic() {}
}
