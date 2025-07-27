// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.XRPDriveSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class XRPDriveCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField", "unused"})
  private final XRPDriveSubsystem m_subsystem;
  // If doing arcade choose a more appropriate name
  private final DoubleSupplier m_leftSupplier;
  private final DoubleSupplier m_rightSupplier;
  
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public XRPDriveCommand(XRPDriveSubsystem subsystem, DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    m_subsystem = subsystem;
    m_leftSupplier = leftSupplier;
    m_rightSupplier = rightSupplier;
  
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // A deadband on the joystick allows for slight noise on the joystick to be ignored, we typically cut the bottom 10% off.
    double leftOutput = MathUtil.applyDeadband(m_leftSupplier.getAsDouble(), OperatorConstants.kDeadband);
    double rightOutput = MathUtil.applyDeadband(m_rightSupplier.getAsDouble(), OperatorConstants.kDeadband);
    m_subsystem.tankDrive(leftOutput, rightOutput);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the motors if command gets interrupted.
    m_subsystem.tankDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
