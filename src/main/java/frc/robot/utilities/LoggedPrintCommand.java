package frc.robot.utilities;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class LoggedPrintCommand extends InstantCommand {
  private static final String tableKey = "LoggedPrintCommands";
  
  public LoggedPrintCommand(String message) {
    this("/Default", message);
    
  }
  
  public LoggedPrintCommand(String key, String message) {
    super(() -> {
      System.out.println(message);
      Logger.recordOutput(tableKey + "/" + key, message);
    });
  }
  
  @Override
  public boolean runsWhenDisabled() {
    return true;
  }
}