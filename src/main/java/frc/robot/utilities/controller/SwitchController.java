package frc.robot.utilities.controller;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.Trigger;


/*
 * Author: Dominic Davis & Adam Kausch
 * Revision history:
 * AJK 06/14/2025 Initial creation.
 */
public class SwitchController implements Controller {
  private final GenericHID m_controller;

  public SwitchController(int port) {
    m_controller = new GenericHID(port);
  }

  @Override
  public double getLeftX() {
    return m_controller.getRawAxis(0);
  }

  @Override
  public double getLeftY() {
    return m_controller.getRawAxis(1);
  }

  @Override
  public double getRightX() {
    return m_controller.getRawAxis(2);
  }

  @Override
  public double getRightY() {
    return m_controller.getRawAxis(3);
  }

  @Override
  public double getLeftTriggerAxis() {
    if (m_controller.getRawButton(6)) {
      return 1;
    }
    return 0;
  }

  @Override
  public double getRightTriggerAxis() {
    if (m_controller.getRawButton(7)) {
      return 1;
    }
    return 0;
  }

  @Override
  public Trigger rightStick() {
    return new Trigger(()->m_controller.getRawButton(11));
  }

  @Override
  public Trigger rightBumper() {
    return new Trigger(()->m_controller.getRawButton(5));
  }

  @Override
  public Trigger rightTriggerMax() {
    return new Trigger(()->m_controller.getRawButton(7));
  }

  @Override
  public Trigger rightTriggerMin() {
    return new Trigger(()->!m_controller.getRawButton(5));
  }

  @Override
  public boolean rightTriggerPressed() {
    return m_controller.getRawButton(7);
  }

  @Override
  public Trigger leftStick() {
    return new Trigger(()->m_controller.getRawButton(10));
  }

  @Override
  public Trigger leftBumper() {
    return new Trigger(()->m_controller.getRawButton(4));
  }

  @Override
  public Trigger leftTriggerMax() {
    return new Trigger(()->m_controller.getRawButton(6));
  }

  @Override
  public Trigger leftTriggerMin() {
    return new Trigger(()->m_controller.getRawButton(6));
  }

  @Override
  public boolean leftTriggerPressed() {
    return m_controller.getRawButton(6);
  }

  @Override
  public Trigger upButton() {
    return new Trigger(()->m_controller.getRawButton(2));
  }

  @Override
  public Trigger downButton() {
    return new Trigger(()->m_controller.getRawButton(1));
  }

  @Override
  public Trigger leftButton() {
    return new Trigger(()->m_controller.getRawButton(0));
  }

  @Override
  public Trigger rightButton() {
    return new Trigger(()->m_controller.getRawButton(3));
  }

  @Override
  public boolean upButtonBool() {
    return m_controller.getRawButton(2);
  }

  @Override
  public boolean downButtonBool() {
    return m_controller.getRawButton(1);
  }

  @Override
  public boolean leftButtonBool() {
    return m_controller.getRawButton(0);
  }

  @Override
  public boolean rightButtonBool() {
    return m_controller.getRawButton(3);
  }

  @Override
  public Trigger logoButton() {
    return new Trigger(() -> false);
  }

  @Override
  public Trigger shareViewButton() {
    return new Trigger(()->m_controller.getRawButton(13));
  }

  @Override
  public Trigger optionsMenuButton() {
    return new Trigger(()->m_controller.getRawButton(12));
  }

  @Override
  public Trigger touchpadShareButton() {
    return new Trigger(() -> false);
  }

  @Override
  public Trigger povCenter() {
    return new Trigger(()->(m_controller.getPOV() == -1));
  }

  @Override
  public Trigger povDown() {
    return new Trigger(()->(m_controller.getPOV() == 180));
  }

  @Override
  public Trigger povDownLeft() {
    return new Trigger(()->(m_controller.getPOV() == 225));
  }

  @Override
  public Trigger povDownRight() {
    return new Trigger(()->(m_controller.getPOV() == 135));
  }

  @Override
  public Trigger povLeft() {
    return new Trigger(()->(m_controller.getPOV() == 270));
  }

  @Override
  public Trigger povRight() {
    return new Trigger(()->(m_controller.getPOV() == 90));
  }

  @Override
  public Trigger povUp() {
    return new Trigger(()->(m_controller.getPOV() == 0));
  }

  @Override
  public Trigger povUpLeft() {
    return new Trigger(()->(m_controller.getPOV() == 315));
  }

  @Override
  public Trigger povUpRight() {
    return new Trigger(()->(m_controller.getPOV() == 45));
  }

  @Override
  public void setRumble(RumbleType arg_rumble, double output) {
    m_controller.setRumble(arg_rumble, output);
  }

  @Override
  public boolean rightBumperBool() {
    return m_controller.getRawButton(5);
  }

  @Override
  public boolean leftBumperBool() {
    return m_controller.getRawButton(4);
  }
}
