package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  private SpeedController intakeMotorOne;
  private SpeedController intakeMotorTwo;

  public Intake(SpeedController intakeMotorOne, SpeedController intakeMotorTwo) {
    this.intakeMotorOne = intakeMotorOne;
    this.intakeMotorTwo = intakeMotorTwo;
  }

  public void setSpeed(double speed) {
      intakeMotorOne.set(speed);
      intakeMotorOne.set(-speed); //incorporate SteelTalonsController. we'll go over it at the meeting tomorrow
  }

  public void stop() {
      intakeMotorOne.set(0);
      intakeMotorTwo.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
