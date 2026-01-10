// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// This CDriveBase is for Command Code

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class CDriveBase extends SubsystemBase {
    // XRPMotor
  private final XRPMotor m_lmotor = new XRPMotor(0);
  private final XRPMotor m_rmotor = new XRPMotor(1);
  // Encoder
  private final Encoder m_lencoder = new Encoder(4,5);
  private final Encoder m_rencoder = new Encoder(6,7);
  // Gyro
  private final XRPGyro m_gyro = new XRPGyro();

  // Wheel Vars
  private final double wheelDiameter = 2.3622;
  private final double trackWidth = 6.1;
  private final double pulsesPerRev = 585;
  private double circumference = Math.PI * wheelDiameter;
  private double distancePerPulse = circumference / pulsesPerRev;
  // constants
  private double avgDistance;
  private double speed;

  public CDriveBase() { 
    m_rmotor.setInverted(true);

    m_lencoder.setDistancePerPulse(distancePerPulse);
    m_rencoder.setDistancePerPulse(distancePerPulse);

    resetEncoder();

  
  }
  public void resetEncoder() {
    m_lencoder.reset();
    m_rencoder.reset();

  }
  public void resetGyro() {
    m_gyro.reset();
  }
  public void move(double speed) {
    m_rmotor.set(speed);
    m_lmotor.set(speed);
  }
  public void MotorStop() {
    m_lmotor.set(0);
    m_rmotor.set(0);
  }
  public void turn(double speed) {
    m_rmotor.set(-speed);
    m_lmotor.set(speed);
  }


  public Command moveCusForwardCommand() {
    return new RunCommand(() ->  { move(0.5); }, this )
    .finallyDo(interrupted -> MotorStop());
  }
  public Command moveCusReverseCommand() {
    return new RunCommand( () -> { this.move(-0.5); }, this)
    .finallyDo(interrupted -> MotorStop());
  }
  public Command moveCusRightCommand() {
    return new RunCommand( () -> { this.turn(0.5); }, this)
    .finallyDo(interrupted -> MotorStop());
  }
  public Command moveCusLeftCommand() {
    return new RunCommand(() ->  { this.turn(-0.5); }, this)
    .finallyDo(interrupted -> MotorStop());
  }
  public Command getAutonoCommand() {
    return null;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}