/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class MoveArm extends CommandBase {
  private Arm arm;
  private double speed;
  private boolean reversed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MoveArm(Arm arm, double speed, boolean reversed) {
    this.arm = arm;
    this.speed = speed;
    this.reversed = reversed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.run(speed, reversed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !(RobotContainer.getJoy().getRawButtonPressed(Constants.JOYSTICK_BUTTON_ARM_UP) || RobotContainer.getJoy().getRawButton(Constants.JOYSTICK_BUTTON_ARM_DOWN)) || (RobotContainer.getArmPotentiometerValue() == Constants.ARM_UPPER_LIMIT || RobotContainer.getArmPotentiometerValue() == Constants.ARM_LOWER_LIMIT); //needs to check if button is no longer pressed 
  }
}
