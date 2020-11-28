package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class DriveWithJoystick extends CommandBase
{
    DriveTrain driveTrain;
    Joystick joy;

    public DriveWithJoystick(DriveTrain driveTrain, Joystick joy)
    {
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize()
    {}

    @Override
    public void execute()
    {
        driveTrain.takeJoystickInputs(joy);
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void end(boolean interrupted)
    {
        driveTrain.stop();
    }
}