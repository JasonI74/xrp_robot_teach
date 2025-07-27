// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
* The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
* constants. This class should not be used for any other purpose. All constants should be declared
* globally (i.e. public static). Do not put anything functional in this class.
*
* <p>It is advised to statically import this class (or one of its inner classes) wherever the
* constants are needed, to reduce verbosity.
*/
public final class Constants {
  
  // --------------------------------------------------------------------------------------------------------
  // SYSTEM CONSTANTS
  // --------------------------------------------------------------------------------------------------------
  public final class SystemConstants {
    // Define what robot the code is being deployed to.
    public static final BotType kBotType = BotType.XRP;
    // For AKit, Simulation or replay of a log.
    public static final Mode simMode = Mode.SIM;
    // For AKit, Real, vs virtual options.
    public static final Mode kDeployMode = RobotBase.isReal() ? Mode.REAL : simMode;
    // Global debug flag to enable additional logging / alerts.
    public static final boolean kDebug = true;
    // System level hardware definitions.
    public static final String kCANivoreBus = "Canivore";
    public static final int kCandleID = 31;
    public static final int kPowerDistID = 1;
    // Robot specific definitions.
  }
  
  public final class OperatorConstants {
    public static final int kDriverPort = 0;
    public static final int kOperatorPort = 1;
    public static final double kDeadband = 0.1;
  }

  public final class DriveConstants {
    // The XRP has the left and right motors set to channels 0 and 1 respectively
    public static final int kLeftMotorID = 0;
    public static final int kRightMotorID = 1;
  }
  
  // --------------------------------------------------------------------------------------------------------
  // ENUMS
  // --------------------------------------------------------------------------------------------------------
  public static enum Mode {
    REAL, // Running on a real robot.
    SIM, // Running a physics simulator.
    REPLAY // Replaying from a log file.
  }
  
  public static enum BotType {
    XRP,
    SIM
  }
  
}
