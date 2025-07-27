package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;


public class XRPDriveSubsystem extends SubsystemBase {
  // Set up the XRP hardware.
  private final XRPMotor m_rightMotor = new XRPMotor(DriveConstants.kRightMotorID);
  private final XRPMotor m_leftMotor = new XRPMotor(DriveConstants.kLeftMotorID);

  // Set up the differential drive controller.
  private final DifferentialDrive m_diffDrive =  new DifferentialDrive(m_leftMotor::set, m_rightMotor::set);
  

  /** Creates a new ExampleSubsystem. */
  public XRPDriveSubsystem() {
    // Configure motors.
    m_leftMotor.setInverted(true);
    m_rightMotor.setInverted(false);
  }

  public void arcadeDrive(double fwdSpeed, double rotSpeed) {
    m_diffDrive.arcadeDrive(fwdSpeed, rotSpeed);
  }
  
  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_diffDrive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
