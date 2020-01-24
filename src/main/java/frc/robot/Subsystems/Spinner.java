package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Spark;

/**
 * Spinner
 */
public class Spinner {
    private final ColorSensor COLOR_SENSOR = new ColorSensor();

    private Spark spinnerMotor;

    private int targetRotations = 0;
    private int rotations = 0;
    private boolean counted = false;

    private String startColor = "";
    private String targetColor = "";

    public Spinner(Spark spinnerMotor){
        this.spinnerMotor = spinnerMotor;
    }
    public void setColor(Color color){
        this.COLOR_SENSOR.setTargetColor(color); 
    }
    public void setRotations (int rotations){
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
        String detected = this.COLOR_SENSOR.getNamedColor();

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
        string detected = this.COLOR_SENSOR.getNamedColor();

        if(this.COLOR_SENSOR.DETECTED_2_TARGET.get(detected) != this.targetColor){
            this.spinnerMotor.set(0.2);
        }else{
            this.spinnerMotor.set(0.0);
            this.targetColor = "";
        }
    }

 
}
// Init sends a signel once
// Periodic sends a signal once in a while 
//https://github.com/JulianOrteil/InfiniteRecharge/blob/master/src/main/java/frc/robot/subsystems/Spinner.java