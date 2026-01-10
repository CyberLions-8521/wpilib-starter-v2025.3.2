// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

// Subsystems
import frc.robot.subsystems.CDriveBase;

public class RobotContainer {
  private final CommandXboxController XController = new CommandXboxController(0);
  private final CDriveBase m_CDriveBase = new CDriveBase();


  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }


  private void configureButtonBindings() {
    XController.a().whileTrue( m_CDriveBase.moveCusReverseCommand());
    XController.y().whileTrue(m_CDriveBase.moveCusForwardCommand());
    XController.x().whileTrue( m_CDriveBase.moveCusLeftCommand());
    XController.b().whileTrue(m_CDriveBase.moveCusRightCommand());
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
