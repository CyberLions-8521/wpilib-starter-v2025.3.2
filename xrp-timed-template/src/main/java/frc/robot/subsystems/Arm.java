// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.xrp.XRPServo;

public class Arm extends SubsystemBase {
  private final XRPServo m_servo = new XRPServo(4);
    public XRPServo getServo(){
    return m_servo;
  }

  public Arm() {
    m_servo.setAngle(0);
  }

  @Override
  public void periodic() {
  }
  
  public void upAndDown(){
    if (m_servo.getAngle() == 0){
      m_servo.setAngle(180);
    }

    if (m_servo.getAngle() == 180){
      m_servo.setAngle(0);
    }
  }
}
