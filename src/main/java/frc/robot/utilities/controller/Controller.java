package frc.robot.utilities.controller;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.Trigger;


/*
 * Author: Dominic Davis & Adam Kausch
 * Revision history:
 *  DD 11/16/2023 Initial creation.
 *  AJK 01/26/2024 Add rumble to controller.
 *
 */
public interface Controller {
  // Controller axes.
  public double getLeftX();

  public double getLeftY();

  public double getRightX();

  public double getRightY();

  public double getLeftTriggerAxis();

  public double getRightTriggerAxis();

  // Controller button triggers.
  public Trigger rightStick();

  public Trigger rightBumper();

  public boolean rightBumperBool();

  public boolean rightTriggerPressed();

  public Trigger rightTriggerMin();

  public Trigger rightTriggerMax();

  public Trigger leftStick();

  public Trigger leftBumper();

  public boolean leftBumperBool();

  public boolean leftTriggerPressed();

  public Trigger leftTriggerMax();

  public Trigger leftTriggerMin();

  // ABXY / Cross, Circle, Square, Triangle.
  public Trigger upButton();

  public boolean upButtonBool();

  public Trigger downButton();

  public boolean downButtonBool();

  public Trigger leftButton();

  public boolean leftButtonBool();

  public Trigger rightButton();

  public boolean rightButtonBool();

  // Misc. buttons.
  public Trigger logoButton();

  public Trigger shareViewButton();

  public Trigger optionsMenuButton();

  public Trigger touchpadShareButton();

  // POV butons.
  public Trigger povCenter();

  public Trigger povDown();

  public Trigger povDownLeft();

  public Trigger povDownRight();

  public Trigger povLeft();

  public Trigger povRight();

  public Trigger povUp();

  public Trigger povUpLeft();

  public Trigger povUpRight();

  // Rumble
  public void setRumble(RumbleType arg_rumble, double output);
}
