package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.XboxController;

/**
 * OI
 */
public class OI {

    private Joystick movementStick;
    //private XboxController xMovementStick
    private final int MOVEMENT_STICK_ID = 0;
    private final int X_AXIS = 0;
    private final int Y_AXIS = 1;

    public OI() {
       movementStick = new Joystick(MOVEMENT_STICK_ID); 
    }

    public double getXAxis() {
        return this.movementStick.getRawAxis(X_AXIS);
    }
    
    public double getYAxis() {
        return this.movementStick.getRawAxis(Y_AXIS);
    }

}