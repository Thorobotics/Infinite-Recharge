package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Drive
 */
public class Drive {

    public Drive() {


    }

    public void drive(DifferentialDrive chassis, double xAxis, double yAxis) {
        chassis.arcadeDrive(-yAxis, xAxis);
    }



    
}