package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.XboxController;

/**
 * OI
 */
public class OI {

    public XboxController masterController;

    private final int MOVEMENT_STICK_ID = 0;


    public OI() {
       this.masterController = new XboxController(MOVEMENT_STICK_ID);
    }


}