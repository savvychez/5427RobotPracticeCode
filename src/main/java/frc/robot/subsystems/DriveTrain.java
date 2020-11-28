package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.SteelTalonsControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase { //looks good! add a DriveWithJoystick to use the joystick to move dt
    private SteelTalonsControllerGroup left;
    private SteelTalonsControllerGroup right;
    private DifferentialDrive drive;

    public DriveTrain(SteelTalonsControllerGroup left, SteelTalonsControllerGroup right, DifferentialDrive drive) {
        this.left = left;
        this.right = right;
        this.drive = drive;
    }

    public void takeJoystickInputs(Joystick joy) {
        drive.tankDrive(joy.getX() , joy.getY());
    }

    public void run(double speed) {
        left.set(speed, false);
        right.set(speed, true);
    }

    public void stop() {
        left.set(0);
        right.set(0);
    }
}