/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Arm extends SubsystemBase {
    private SpeedController armController;
  /**
   * Creates a new ExampleSubsystem.
   */
  public Arm(SpeedController armController) {
    this.armController = armController;
  }

  public void run(double speed) {
      if(RobotContainer.getA)
      armController.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
