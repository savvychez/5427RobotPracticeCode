/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.SteelTalonsController;

public class Arm extends SubsystemBase {
    private SteelTalonsController armController;
  /**
   * Creates a new ExampleSubsystem.
   */
  public Arm(SteelTalonsController armController) {
    this.armController = armController;
  }

  public void run(double speed, boolean reserved) {
      if(RobotContainer.getArmPotentiometerValue() >= Constants.ARM_LOWER_LIMIT && RobotContainer.getArmPotentiometerValue() <= Constants.ARM_UPPER_LIMIT)
        armController.set(speed, reserved);
      else
        armController.set(0);
  }

  public void stop() {
    armController.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
