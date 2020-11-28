package frc.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class SteelTalonsControllerGroup extends SpeedControllerGroup {
    private double offset;
    private boolean reversed;

    public SteelTalonsControllerGroup(double offset, boolean reversed, SpeedController speedController, SpeedController... speedControllers) {
        super(speedController, speedControllers);
        this.offset = offset;
        this.reversed = reversed;
    }

    public void set(double speed, boolean reversed) {
        if(reversed)
            setInverted(!this.reversed);
        else
            setInverted(this.reversed); 
        super.set(speed + offset);
    }
}