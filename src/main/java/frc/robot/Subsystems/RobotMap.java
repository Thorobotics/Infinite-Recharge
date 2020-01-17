package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * RobotMap
 */
public class RobotMap {

    private Spark frontLeft;
    private Spark frontRight;
    private Spark backLeft;
    private Spark backRight;
    private final int FRONT_LEFT_ID = 0;
    private final int FRONT_RIGHT_ID = 0;
    private final int BACK_LEFT_ID = 0;
    private final int BACK_RIGHT_ID = 0;
    private SpeedControllerGroup leftSide;
    private SpeedControllerGroup rightSide;
    private DifferentialDrive chassis;

    public RobotMap() {
        frontLeft = new Spark(FRONT_LEFT_ID);
        frontRight = new Spark(FRONT_RIGHT_ID);
        backLeft = new Spark(BACK_LEFT_ID);
        backRight = new Spark(BACK_RIGHT_ID);

        leftSide = new SpeedControllerGroup(frontLeft, backLeft);
        rightSide = new SpeedControllerGroup(frontRight, backRight);
        
        chassis = new DifferentialDrive(leftSide, rightSide);
    }


}