// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveBase;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class SquareCommand extends Command {
  private DriveBase m_DriveBase;
  private Autostate currentState;
  // Autostates
  private enum Autostate {
    FORWARD1, TURN1, FORWARD2, TURN2, FORWARD3, TURN3, FORWARD4, TURN4, FORWARD5, DONE
  }
  
  /** Creates a new Command. */
  public SquareCommand(DriveBase dBase) {
    // Use addRequirements() here to declare subsystem dependencies.
      this.m_DriveBase = dBase;
      addRequirements(m_DriveBase);
      this.currentState = Autostate.FORWARD1;
      
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() { m_DriveBase.restartDistance(); }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (currentState) { // in theory makes a square
      case FORWARD1:
              if (m_DriveBase.moveForward(10)) {
                m_DriveBase.restartDistance();
                currentState = Autostate.TURN1;
              }
              break;
      case TURN1:
              if (m_DriveBase.rotateRight(4)) {
                m_DriveBase.restartDistance();
                currentState = Autostate.FORWARD2;
              }
              break;
      case FORWARD2:
              if (m_DriveBase.moveForward(10)) {
                m_DriveBase.restartDistance();
                currentState = Autostate.TURN2;
              }
              break;
      case TURN2:
              if (m_DriveBase.rotateRight(4)) {
                m_DriveBase.restartDistance();
                currentState = Autostate.FORWARD3;
              }
              break;
      case FORWARD3:
              if (m_DriveBase.moveForward(10)) {
                m_DriveBase.restartDistance();
                currentState = Autostate.TURN3;
              }
              break;
      case TURN3:
            if (m_DriveBase.rotateRight(4)) {
              m_DriveBase.restartDistance();
              currentState = Autostate.FORWARD4;
            }
            break;
      case FORWARD4:
            if (m_DriveBase.moveForward(10)) {
              m_DriveBase.restartDistance();
              currentState = Autostate.TURN4;
            }
            break;
      case TURN4:
            if (m_DriveBase.rotateRight(4)) {
              m_DriveBase.restartDistance();
              currentState = Autostate.FORWARD5;
            }
            break;
      case FORWARD5:
            if (m_DriveBase.moveForward(10)) {
              m_DriveBase.restartDistance();
              currentState = Autostate.DONE;
            }
            break;
    }
      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveBase.stopAllMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      
    return (currentState.equals(Autostate.DONE));

  }
}
