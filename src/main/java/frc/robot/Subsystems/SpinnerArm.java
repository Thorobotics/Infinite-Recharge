package frc.robot.Subsystems;
import edu.wpi.first.wpilibj.Spark;

public class SpinnerArm {
  private final Spark armMotor;
  private int liftDirection = 0;
  
    public SpinnerArm(final Spark armMotor){
        this.armMotor = armMotor;
    }
    public void armControlInit(int liftControl) {
        this.liftDirection = liftControl;
    }
    public void armControlPeriodic() {
        this.armMotor.set(0.2*this.liftDirection);
    }
}