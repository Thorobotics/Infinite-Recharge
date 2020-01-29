package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.DriverStation;

/**
 * Spinner
 */
public class Spinner {
    private final ColorSensor COLOR_SENSOR = new ColorSensor();

    private final Spark spinnerMotor;

    private int rotationDirection = 0;
    private int targetRotations = 0;
    private int rotations = 0;
    private boolean counted = false;

    private String startColor = "";
    private String targetColor = "";

    public Spinner(final Spark spinnerMotor){
        this.spinnerMotor = spinnerMotor;
    }
    public void setColor(final Color color){
        this.COLOR_SENSOR.setTargetColor(color); 
    }
    public void setRotations (final int rotations){
        this.targetRotations = rotations;
    }
    public int getRotations(){
        return this.rotations;
    }
    public void rotationControlInit(){
        this.targetRotations = (int)SmartDashboard.getNumber("Target Rotations",3);
        this.startColor = this.COLOR_SENSOR.getNamedColor();
    }
    public void rotationControlPeriodic() {
        final String detected = this.COLOR_SENSOR.getNamedColor();

        if (detected == this.startColor){
            if(!counted){
                this.rotations += 1;
                this.counted = true;
            }
        }else if (detected != "Unknown") {
            this.counted = false;
        }
        if ((this.rotations - targetRotations) <= 2 && (this.rotations - targetRotations) > 0) {
            this.spinnerMotor.set(0.2);
            } else if (this.rotations != this.targetRotations) {
                this.spinnerMotor.set(0.5);
            }   else {
                this.spinnerMotor.set(0.0);
                this.rotations = 0;
                this.startColor = "";
            }
    }
    public void positionControlInit() {
        this.targetColor = SmartDashboard.getString("Target Color", "Unknown");
    }
    public void positionControlPeriodic() {
        final String detected = this.COLOR_SENSOR.getNamedColor();

        if(this.COLOR_SENSOR.DETECTED_2_TARGET.get(detected) != this.targetColor){
            this.spinnerMotor.set(0.2);
        }else{
            this.spinnerMotor.set(0.0);
            this.targetColor = "";
        }
    } 
    public void colorControlInit(int rotationControl){
    /*this.startColor = this.COLOR_SENSOR.getNamedColor();
        this.rotationDirection = rotationControl; */
        this.targetColor = DriverStation.getInstance().getGameSpecificMessage();
        if (this.targetColor.length() > 0){
            switch (this.targetColor.charAt(0)) {
                case 'B':
                 this.targetColor = "Blue"; 
                break;
                
                case 'G' :
                 this.targetColor = "Green";
                break;

                case 'R' :
                 this.targetColor = "Red";
                break;

                case 'Y' :
                 this.targetColor = "Yellow";
                break;
                
                default :
                break;
            }
        } else {

        }
    }
     public void colorControlPeriodic() {
        final String detected = this.COLOR_SENSOR.getNamedColor();

        if(detected != this.startColor){
            this.spinnerMotor.set(0.0);
            this.startColor = "";
        }else{
            this.spinnerMotor.set(0.2*this.rotationDirection);
        }
    }
}






