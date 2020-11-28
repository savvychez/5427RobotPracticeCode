package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;

public class SteelTalonsController extends PWMVictorSPX {
    private boolean reversed;
    private double bias;

    public SteelTalonsController(int channel, boolean reversed, double bias) {
        super(channel);
        this.reversed = reversed;
        this.bias = bias;
    }

    public void set(double speed, boolean reversed) {
        if(reversed)
            setInverted(!this.reversed);
        else
            setInverted(this.reversed);
        super.set(speed*bias);
    }
}