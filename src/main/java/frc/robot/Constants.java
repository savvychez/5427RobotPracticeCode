/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Joysticks
    public static final int JOYSTICK_PORT            = 0;
    public static final int JOYSTICK_BUTTON_INTAKE   = 1;
    public static final int JOYSTICK_BUTTON_OUTTAKE  = 2;
    public static final int JOYSTICK_BUTTON_SOLENOID = 3;


    //Drivetrain PWM Victor SPX Channels
    public static final int FRONT_LEFT_SPX_CHANNEL   = 4;
    public static final int FRONT_RIGHT_SPX_CHANNEL  = 5;
    public static final int BACK_LEFT_SPX_CHANNEL    = 6;
    public static final int BACK_RIGHT_SPX_CHANNEL   = 7;


    //Flywheel Intake PWM Victor SPX Channels
    public static final int FLYWHEEL_ONE_SPX_CHANNEL = 8;
    public static final int FLYWHEEL_TWO_SPX_CHANNEL = 9;
    public static final int FLYWHEEL_SPEED           = 10;

    
    //Solenoid Channel
    public static final int SOLENOID_CHANNEL = 11;


    //Arm
    public static final int ARM_SPX_CHANNEL = 12;
}
