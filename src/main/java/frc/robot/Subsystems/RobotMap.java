package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * RobotMap
 */
public class RobotMap {

    private WPI_TalonSRX frontLeft;
    private WPI_TalonSRX frontRight;
    private WPI_TalonSRX backLeft;
    private WPI_TalonSRX backRight;
    private final int FRONT_LEFT_ID = 0;
    private final int FRONT_RIGHT_ID = 0;
    private final int BACK_LEFT_ID = 0;           //change IDS
    private final int BACK_RIGHT_ID = 0;
    private SpeedControllerGroup leftSide;
    private SpeedControllerGroup rightSide;
    private DifferentialDrive chassis;

    private Spark spinnerMotor;

    public Spark intakeSpark;
    public Spark doorMotor; 
    public final int INTAKE1_ID = 0;
    public final int INTAKE2_ID = 0;
    //public SpeedControllerGroup intakeMotors;

    public RobotMap() {
        frontLeft = new WPI_TalonSRX(FRONT_LEFT_ID);
        frontRight = new WPI_TalonSRX(FRONT_RIGHT_ID);
        backLeft = new WPI_TalonSRX(BACK_LEFT_ID);
        backRight = new WPI_TalonSRX(BACK_RIGHT_ID);

        leftSide = new SpeedControllerGroup(frontLeft, backLeft);
        rightSide = new SpeedControllerGroup(frontRight, backRight);
        
        chassis = new DifferentialDrive(leftSide, rightSide);

        intakeSpark = new Spark(INTAKE1_ID);
        doorMotor = new Spark(INTAKE2_ID);

        //intakeMotors = new SpeedControllerGroup(intakeSpark); //the two motors are complte different
    }

    public DifferentialDrive getChassis() {
        return this.chassis;
    }

    public Spark getIntakeSpark() {
        return this.intakeSpark;
    }

    public Spark getDoorMotor() {
        return this.doorMotor;
    }
        

    }

