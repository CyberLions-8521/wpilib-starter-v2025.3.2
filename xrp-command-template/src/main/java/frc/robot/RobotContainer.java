// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

// Subsystems
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Arm;
import frc.robot.commands.SquareCommand;


public class RobotContainer {
  DriveBase m_driveBase = new DriveBase();
  Arm m_servo = new Arm();
  CommandXboxController XController = new CommandXboxController(0);


  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }


  private void configureButtonBindings() {
    XController.a().onTrue(new SquareCommand(m_driveBase));
    /*
    XController.b().onTrue(
      new DriveForward(m_drivebase, 3)
      .andThen(new TurnLeft(m_drivebase, 90))
      .andThen
    )
      */
  }


  public Command getAutonomousCommand() {
    return null;
  }

  
}
