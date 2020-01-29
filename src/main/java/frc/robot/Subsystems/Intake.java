package frc.robot.Subsystems;

/**
 * Intake - picks up the ball from the floor
 */

public class Intake {

    private RobotMap robotMap;
    private Arduino arduino;
    private OI m_OI;

    public Intake(){
        this.arduino = new Arduino();
        this.robotMap = new RobotMap();
        this.m_OI = new OI();

    }
    public void intakePeriodic() {
        double ballCounter = this.arduino.getData();
        if (ballCounter < 5){ 
            this.robotMap.getIntake().set(1);
        }
        else{
            this.robotMap.getIntake().set(-1);
        }
    }
    
    
}