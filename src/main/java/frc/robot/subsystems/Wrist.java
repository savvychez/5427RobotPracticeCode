/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.SteelTalonsController;

public class Wrist extends SubsystemBase {
    private SteelTalonsController wristController;
  /**
   * Creates a new ExampleSubsystem.
   */
  public Wrist(SteelTalonsController wristController) {
    this.wristController = wristController;
  }

  public void run(double speed, boolean reversed) {
      if(RobotContainer.getWristPotentiometerValue() >= Constants.WRIST_LOWER_LIMIT && RobotContainer.getWristPotentiometerValue() <= Constants.WRIST_UPPER_LIMIT)
        wristController.set(speed, reversed);
      else
        wristController.set(0, reversed);
  }

  public void stop() {
    wristController.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
