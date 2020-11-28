package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Wait extends CommandBase {
    private double startTime;
    private double time;

    public Wait(double time) {
        this.time = time;
    }

    @Override
    public void initialize() {
        startTime = Timer.getFPGATimestamp();
    }

    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() - time >= startTime;
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
    }
}