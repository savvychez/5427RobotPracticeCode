package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase { //looks good! add a DriveWithJoystick to use the joystick to move dt
    private SpeedControllerGroup left;
    private SpeedControllerGroup right;
    private DifferentialDrive drive;

    public DriveTrain(SpeedControllerGroup left, SpeedControllerGroup right, DifferentialDrive drive) {
        this.left = left;
        this.right = right;
        this.drive = drive;
    }

    public void takeJoystickInputs(Joystick left, Joystick right) {
        drive.tankDrive(left.getY() , right.getY());
    }

    public void run(double speed) {
        left.set(speed);
        right.set(-speed);
    }

    public void stop() {
        left.set(0);
        right.set(0);
    }
}