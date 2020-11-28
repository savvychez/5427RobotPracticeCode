/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ControlFlywheel;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.MoveArm;
import frc.robot.commands.MoveSolenoidHatch;
import frc.robot.commands.MoveWrist;
import frc.robot.commands.auto.DropOff;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;
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
  private static Joystick joy;


  //DriveTrain vars
  private static DriveTrain driveTrain;

  private SteelTalonsController frontLeft;
  private SteelTalonsController frontRight;
  private SteelTalonsController backLeft;
  private SteelTalonsController backRight;

  private SteelTalonsControllerGroup left;
  private SteelTalonsControllerGroup right;

  private DifferentialDrive diffDrive;


  //Flywheel vars
  private SteelTalonsController intakeMotorOne;
  private SteelTalonsController intakeMotorTwo;
  private Intake flywheelIntake;

  private JoystickButton intakeButton;
  private JoystickButton outtakeButton;


  //Solenoid vars
  private Solenoid hatchSolenoid;

  private JoystickButton solenoidHatchButton;


  //Arm vars
  private Arm arm;
  private SteelTalonsController armController;
  private static AnalogPotentiometer armPotentiometer;

  private JoystickButton armUpButton;
  private JoystickButton armDownButton;


  //Wrist vars
  private Wrist wrist;
  private SteelTalonsController wristController;
  private static AnalogPotentiometer wristPotentiometer;

  private JoystickButton wristUpButton;
  private JoystickButton wristDownButton;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    joy = new Joystick(Constants.JOYSTICK_PORT);


    //Drivetrain Init
    frontLeft = new SteelTalonsController(Constants.FRONT_LEFT_SPX_CHANNEL, Constants.FRONT_LEFT_REVERSED, Constants.FRONT_LEFT_BIAS);
    frontRight = new SteelTalonsController(Constants.FRONT_RIGHT_SPX_CHANNEL, Constants.FRONT_RIGHT_REVERSED, Constants.FRONT_RIGHT_BIAS);
    backLeft = new SteelTalonsController(Constants.BACK_LEFT_SPX_CHANNEL, Constants.BACK_LEFT_REVERSED, Constants.BACK_LEFT_BIAS); 
    backRight = new SteelTalonsController(Constants.BACK_RIGHT_SPX_CHANNEL, Constants.BACK_RIGHT_REVERSED, Constants.BACK_RIGHT_BIAS);

    left = new SteelTalonsControllerGroup(Constants.LEFT_GROUP_OFFSET, Constants.LEFT_GROUP_REVERSED, frontLeft, backLeft);
    right = new SteelTalonsControllerGroup(Constants.RIGHT_GROUP_OFFSET, Constants.RIGHT_GROUP_REVERSED, frontRight, backRight);

    diffDrive = new DifferentialDrive(left, right);
    driveTrain = new DriveTrain(left, right, diffDrive);


    //Flywheel Intake Init
    intakeMotorOne = new SteelTalonsController(Constants.FLYWHEEL_ONE_SPX_CHANNEL, Constants.FLYWHEEL_ONE_REVERSED, Constants.FLYWHEEL_ONE_BIAS);
    intakeMotorTwo = new SteelTalonsController(Constants.FLYWHEEL_TWO_SPX_CHANNEL, Constants.FLYWHEEL_TWO_REVERSED, Constants.FLYWHEEL_TWO_BIAS);
    flywheelIntake = new Intake(intakeMotorOne, intakeMotorTwo);


    //Solenoid Hatch
    hatchSolenoid = new Solenoid(Constants.SOLENOID_CHANNEL);


    //Arm + Wrist Limits
    armController = new SteelTalonsController(Constants.ARM_SPX_CHANNEL, Constants.ARM_REVERSED, Constants.ARM_BIAS);
    armPotentiometer = new AnalogPotentiometer(0, 180, 0);
    arm = new Arm(armController);

    wristController = new SteelTalonsController(Constants.WRIST_SPX_CHANNEL, Constants.WRIST_REVERSED, Constants.WRIST_BIAS);
    wristPotentiometer = new AnalogPotentiometer(0, 180, 0);
    wrist = new Wrist(wristController);

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
    armUpButton = new JoystickButton(joy, Constants.JOYSTICK_BUTTON_ARM_UP);
    armDownButton = new JoystickButton(joy, Constants.JOYSTICK_BUTTON_ARM_DOWN);
    wristUpButton = new JoystickButton(joy, Constants.JOYSTICK_BUTTON_WRIST_UP);
    wristDownButton = new JoystickButton(joy, Constants.JOYSTICK_BUTTON_WRIST_DOWN);

    //Joystick Button Actions
    driveTrain = new DriveTrain(left, right, diffDrive);
    driveTrain.setDefaultCommand(new DriveWithJoystick(driveTrain, joy));
    intakeButton.whenHeld(new ControlFlywheel(flywheelIntake, Constants.FLYWHEEL_SPEED));
    outtakeButton.whenHeld(new ControlFlywheel(flywheelIntake, -Constants.FLYWHEEL_SPEED)); 
    solenoidHatchButton.whenPressed(new MoveSolenoidHatch(hatchSolenoid));
    armUpButton.whenHeld(new MoveArm(arm, Constants.ARM_SPEED, false));
    armDownButton.whenHeld(new MoveArm(arm, Constants.ARM_SPEED, true));
    wristUpButton.whenHeld(new MoveWrist(wrist, Constants.WRIST_SPEED, false));
    wristDownButton.whenHeld(new MoveWrist(wrist, Constants.WRIST_SPEED, true));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new DropOff(driveTrain, hatchSolenoid);
  }

  public static Joystick getJoy() {
    return joy;
  }

  public static double getArmPotentiometerValue() {
    return armPotentiometer.get();
  }

  public static double getWristPotentiometerValue() {
    return wristPotentiometer.get();
  }
}
