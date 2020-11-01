/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ControlFlywheel;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveSolenoidHatch;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Joystick joy;


  //DriveTrain vars
  private static DriveTrain driveTrain;

  private SpeedController frontLeft;
  private SpeedController frontRight;
  private SpeedController backLeft;
  private SpeedController backRight;

  private SpeedControllerGroup left;
  private SpeedControllerGroup right;

  private DifferentialDrive diffDrive;


  //Flywheel vars
  private SpeedController intakeMotorOne;
  private SpeedController intakeMotorTwo;
  private Intake flywheelIntake;

  private JoystickButton intakeButton;
  private JoystickButton outtakeButton;

  //Solenoid vars
  private Solenoid hatchSolenoid;

  private JoystickButton solenoidHatchButton;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    joy = new Joystick(Constants.JOYSTICK_PORT);


    //Drivetrain Init
    frontLeft = new PWMVictorSPX(Constants.FRONT_LEFT_SPX_CHANNEL);
    frontRight = new PWMVictorSPX(Constants.FRONT_RIGHT_SPX_CHANNEL);
    backLeft = new PWMVictorSPX(Constants.BACK_LEFT_SPX_CHANNEL); 
    backRight = new PWMVictorSPX(Constants.BACK_RIGHT_SPX_CHANNEL);

    left = new SpeedControllerGroup(frontLeft, backLeft);
    right = new SpeedControllerGroup(frontRight, backRight);

    diffDrive = new DifferentialDrive(left, right);
    driveTrain = new DriveTrain(left, right, diffDrive);


    //Flywheel Intake Init
    intakeMotorOne = new PWMVictorSPX(Constants.FLYWHEEL_ONE_SPX_CHANNEL);
    intakeMotorTwo = new PWMVictorSPX(Constants.FLYWHEEL_TWO_SPX_CHANNEL);
    flywheelIntake = new Intake(intakeMotorOne, intakeMotorTwo);


    //Solenoid Hatch
    hatchSolenoid = new Solenoid(Constants.SOLENOID_CHANNEL);

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Joystick Button Init
    intakeButton = new JoystickButton(joy, Constants.JOYSTICK_BUTTON_INTAKE); 
    outtakeButton = new JoystickButton(joy, Constants.JOYSTICK_BUTTON_OUTTAKE);
    solenoidHatchButton = new JoystickButton(joy, Constants.JOYSTICK_BUTTON_SOLENOID);

    //Joystick Button Actions
    intakeButton.whenHeld(new ControlFlywheel(flywheelIntake, Constants.FLYWHEEL_SPEED));
    outtakeButton.whenHeld(new ControlFlywheel(flywheelIntake, -Constants.FLYWHEEL_SPEED)); 
    solenoidHatchButton.whenHeld(new MoveSolenoidHatch(hatchSolenoid));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;//m_autoCommand;
  }

  public Joystick getJoy() {
    return joy;
  }
}
