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
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * An example command that uses an example subsystem.
 */
public class MoveSolenoidHatch extends InstantCommand {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Solenoid hatchSolenoid;
  private boolean solenoidActivated;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MoveSolenoidHatch(Solenoid hatchSolenoid) {
    this.hatchSolenoid = hatchSolenoid;
    this.solenoidActivated = true;

    // Use addRequirements() here to declare subsystem dependencies.
    // addRequirements(Solenoid);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    hatchSolenoid.set(solenoidActivated);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    solenoidActivated = false;
    hatchSolenoid.set(solenoidActivated);
  }
}
