// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.XRPDriveCommand;
import frc.robot.subsystems.XRPDriveSubsystem;
import frc.robot.utilities.controller.Controller;
import frc.robot.utilities.controller.XboxController;

public class RobotContainer {
  // Drive Team Joysticks.
  private final Controller m_driverController = new XboxController(OperatorConstants.kDriverPort);

	// Driver Subsystems.
  private final XRPDriveSubsystem m_xrpDrive = new XRPDriveSubsystem();

  // Commands.
  private final XRPDriveCommand m_driveCommand = new XRPDriveCommand(m_xrpDrive, m_driverController::getLeftY, m_driverController::getRightY);


  public RobotContainer() {
    // Configure the controller bindings
    configureDriverBindings();
    configureOperatorBindings();
  }

  private void configureDriverBindings() {
    // Driver specific controller bindings.
    m_xrpDrive.setDefaultCommand(m_driveCommand);
  }

  private void configureOperatorBindings() {
    // Operator specific controller bindings.
  }

  public Command getAutonomousCommand() {
    return new PrintCommand("Hello World");
  }
}