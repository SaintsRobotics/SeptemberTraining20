/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArcadeSubsystem;
import frc.robot.subsystems.TestSubsytem;

public class MecanumCommand extends CommandBase {
  /**
   * Creates a new MecanumCommand.
   */
  private TestSubsytem m_subsystem;
  private XboxController m_controller;

  public MecanumCommand(TestSubsytem subsystem, XboxController controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    m_subsystem = subsystem;
    m_controller = controller;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.setSpeed(m_controller.getTriggerAxis(Hand.kLeft));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
