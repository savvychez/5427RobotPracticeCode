package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.SteelTalonsController;

public class Intake extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  private SteelTalonsController intakeMotorOne;
  private SteelTalonsController intakeMotorTwo;

  public Intake(SteelTalonsController intakeMotorOne, SteelTalonsController intakeMotorTwo) {
    this.intakeMotorOne = intakeMotorOne;
    this.intakeMotorTwo = intakeMotorTwo;
  }

  public void setSpeed(double speed) {
      intakeMotorOne.set(speed, false);
      intakeMotorOne.set(speed, true); //incorporate SteelTalonsController. we'll go over it at the meeting tomorrow
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
