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
    private final int BACK_LEFT_ID = 0;           //change IDS
    private final int BACK_RIGHT_ID = 0;
    private SpeedControllerGroup leftSide;
    private SpeedControllerGroup rightSide;
    private DifferentialDrive chassis;

    private Spark spinnerMotor;

    private Spark intakeSpark1;
    private Spark intakeSpark2; 
    private final int INTAKE1_ID = 0;
    private final int INTAKE2_ID = 0;
    private SpeedControllerGroup intakeMotors;

    public RobotMap() {
        frontLeft = new Spark(FRONT_LEFT_ID);
        frontRight = new Spark(FRONT_RIGHT_ID);
        backLeft = new Spark(BACK_LEFT_ID);
        backRight = new Spark(BACK_RIGHT_ID);

        leftSide = new SpeedControllerGroup(frontLeft, backLeft);
        rightSide = new SpeedControllerGroup(frontRight, backRight);
        
        chassis = new DifferentialDrive(leftSide, rightSide);

        intakeSpark1 = new Spark(INTAKE1_ID);
        intakeSpark2 = new Spark(INTAKE2_ID);

        intakeMotors = new SpeedControllerGroup(intakeSpark1, intakeSpark2);
    }

    public DifferentialDrive getChassis() {
        return this.chassis;
    }

    public SpeedControllerGroup getIntake() {
        return this.intakeMotors;
    }
        

    }

