// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.xrp.XRPServo;

public class Arm extends SubsystemBase {
  XRPServo m_servo = new XRPServo(4);
  public XRPServo getServo(){
    return m_servo;
  }

  public double getPosition(){
    return m_servo.getPosition();
  }
  public Arm() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_servo.setPosition(0.5); 
  }
}
