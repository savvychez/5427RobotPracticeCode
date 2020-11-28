package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.MoveForward;
import frc.robot.commands.MoveSolenoidHatch;
import frc.robot.commands.Wait;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;

public class DropOff extends SequentialCommandGroup
{
    private double startTime = Timer.getFPGATimestamp();
    private double time;

    public DropOff(DriveTrain driveTrain, Solenoid hatchSolenoid)
    {
       super(new MoveForward(driveTrain, 2), new Wait(2), new MoveSolenoidHatch(hatchSolenoid));
    }
}