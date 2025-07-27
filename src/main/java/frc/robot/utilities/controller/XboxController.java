package frc.robot.utilities.controller;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;


/*
 * Author: Dominic Davis & Adam Kausch
 * Revision history:
 *  DD 11/16/2023 Initial creation.
 *  AJK 01/26/2024 Add rumble to controller.
 */
public class XboxController implements Controller {
  private final CommandXboxController m_controller;

  public XboxController(int port) {
    m_controller = new CommandXboxController(port);
  }

  @Override
  public double getLeftX() {
    return m_controller.getLeftX();
  }

  @Override
  public double getLeftY() {
    return m_controller.getLeftY();
  }

  @Override
  public double getRightX() {
    return m_controller.getRightX();
  }

  @Override
  public double getRightY() {
    return m_controller.getRightY();
  }

  @Override
  public double getLeftTriggerAxis() {
    return m_controller.getLeftTriggerAxis();
  }

  @Override
  public double getRightTriggerAxis() {
    return m_controller.getRightTriggerAxis();
  }

  @Override
  public Trigger rightStick() {
    return m_controller.rightStick();
  }

  @Override
  public Trigger rightBumper() {
    return m_controller.rightBumper();
  }

  @Override
  public Trigger rightTriggerMax() {
    return m_controller.rightTrigger();
  }

  @Override
  public Trigger rightTriggerMin() {
    return new Trigger(
        () -> MathUtil.applyDeadband(this.getRightTriggerAxis(), OperatorConstants.kDeadband) > 0);
  }

  @Override
  public boolean rightTriggerPressed() {
    return MathUtil.applyDeadband(this.getRightTriggerAxis(), OperatorConstants.kDeadband) > 0;
  }

  @Override
  public Trigger leftStick() {
    return m_controller.leftStick();
  }

  @Override
  public Trigger leftBumper() {
    return m_controller.leftBumper();
  }

  @Override
  public Trigger leftTriggerMax() {
    return m_controller.leftTrigger();
  }

  @Override
  public Trigger leftTriggerMin() {
    return new Trigger(
        () -> MathUtil.applyDeadband(this.getLeftTriggerAxis(), OperatorConstants.kDeadband) > 0);
  }

  @Override
  public boolean leftTriggerPressed() {
    return MathUtil.applyDeadband(this.getLeftTriggerAxis(), OperatorConstants.kDeadband) > 0;
  }

  @Override
  public Trigger upButton() {
    return m_controller.y();
  }

  @Override
  public Trigger downButton() {
    return m_controller.a();
  }

  @Override
  public Trigger leftButton() {
    return m_controller.x();
  }

  @Override
  public Trigger rightButton() {
    return m_controller.b();
  }

  @Override
  public boolean upButtonBool() {
    return m_controller.getHID().getYButton();
  }

  @Override
  public boolean downButtonBool() {
    return m_controller.getHID().getAButton();
  }

  @Override
  public boolean leftButtonBool() {
    return m_controller.getHID().getXButton();
  }

  @Override
  public boolean rightButtonBool() {
    return m_controller.getHID().getBButton();
  }

  @Override
  public Trigger logoButton() {
    return new Trigger(() -> false);
  }

  @Override
  public Trigger shareViewButton() {
    return m_controller.back();
  }

  @Override
  public Trigger optionsMenuButton() {
    return m_controller.start();
  }

  @Override
  public Trigger touchpadShareButton() {
    return new Trigger(() -> false);
  }

  @Override
  public Trigger povCenter() {
    return m_controller.povCenter();
  }

  @Override
  public Trigger povDown() {
    return m_controller.povDown();
  }

  @Override
  public Trigger povDownLeft() {
    return m_controller.povDownLeft();
  }

  @Override
  public Trigger povDownRight() {
    return m_controller.povDownRight();
  }

  @Override
  public Trigger povLeft() {
    return m_controller.povLeft();
  }

  @Override
  public Trigger povRight() {
    return m_controller.povRight();
  }

  @Override
  public Trigger povUp() {
    return m_controller.povUp();
  }

  @Override
  public Trigger povUpLeft() {
    return m_controller.povUpLeft();
  }

  @Override
  public Trigger povUpRight() {
    return m_controller.povUpRight();
  }

  @Override
  public void setRumble(RumbleType arg_rumble, double output) {
    m_controller.getHID().setRumble(arg_rumble, output);
  }

  @Override
  public boolean rightBumperBool() {
    return m_controller.getHID().getRightBumperButton();
  }

  @Override
  public boolean leftBumperBool() {
    return m_controller.getHID().getLeftBumperButton();
  }
}
