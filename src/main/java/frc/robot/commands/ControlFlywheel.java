/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class ControlFlywheel extends CommandBase {
  private final Intake flywheelIntake;
  private double speed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ControlFlywheel(Intake intake, double speed) {
    this.flywheelIntake = intake;
    this.speed = speed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    flywheelIntake.setSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    flywheelIntake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !(RobotContainer.getJoy().getRawButtonPressed(Constants.JOYSTICK_BUTTON_INTAKE) || RobotContainer.getJoy().getRawButton(Constants.JOYSTICK_BUTTON_OUTTAKE)); //needs to check if button is no longer pressed 
  }
}
