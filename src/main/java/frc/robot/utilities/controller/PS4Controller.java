package frc.robot.utilities.controller;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;


/*
 * Author: Dominic Davis & Adam Kausch
 * Revision history:
 *  DD 11/16/2023 Initial creation.
 *  AJK 01/26/2024 Add rumble to controller.
 *  AJK 01/27/2024 Interpolate rear triggers to match Xbox.
 *
 */
public class PS4Controller implements Controller {
  private final CommandPS4Controller m_controller;
  private final int m_port;

  public PS4Controller(int arg_port) {
    this.m_controller = new CommandPS4Controller(arg_port);
    this.m_port = arg_port;
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
    if (!DriverStation.isJoystickConnected(m_port)) {
      return 0;
    }
    return MathUtil.interpolate(0.0, 1.0, (m_controller.getL2Axis() + 1.0) / 2.0);
  }

  @Override
  public double getRightTriggerAxis() {
    if (!DriverStation.isJoystickConnected(m_port)) {
      return 0;
    }
    return MathUtil.interpolate(0.0, 1.0, (m_controller.getR2Axis() + 1.0) / 2.0);
  }

  @Override
  public Trigger rightStick() {
    return m_controller.R3();
  }

  @Override
  public Trigger rightBumper() {
    return m_controller.R1();
  }

  @Override
  public Trigger rightTriggerMax() {
    return m_controller.R2();
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
    return m_controller.L3();
  }

  @Override
  public Trigger leftBumper() {
    return m_controller.L1();
  }

  @Override
  public Trigger leftTriggerMax() {
    return m_controller.L2();
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
    return m_controller.triangle();
  }

  @Override
  public Trigger downButton() {
    return m_controller.cross();
  }

  @Override
  public Trigger leftButton() {
    return m_controller.square();
  }

  @Override
  public Trigger rightButton() {
    return m_controller.circle();
  }

  @Override
  public boolean upButtonBool() {
    return m_controller.getHID().getTriangleButton();
  }

  @Override
  public boolean downButtonBool() {
    return m_controller.getHID().getCrossButton();
  }

  @Override
  public boolean leftButtonBool() {
    return m_controller.getHID().getSquareButton();
  }

  @Override
  public boolean rightButtonBool() {
    return m_controller.getHID().getCircleButton();
  }

  @Override
  public Trigger logoButton() {
    return m_controller.PS();
  }

  @Override
  public Trigger shareViewButton() {
    return m_controller.share();
  }

  @Override
  public Trigger optionsMenuButton() {
    return m_controller.options();
  }

  @Override
  public Trigger touchpadShareButton() {
    return m_controller.touchpad();
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
    return m_controller.getHID().getR1Button();
  }

  @Override
  public boolean leftBumperBool() {
    return m_controller.getHID().getL1Button();
  }
}
