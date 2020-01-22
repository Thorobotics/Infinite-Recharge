package frc.robot.Subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

public class CameraServer_ {
    private UsbCamera camera1;
    private UsbCamera camera2;


    public CameraServer_(){
        camera1 = CameraServer.getInstance().startAutomaticCapture(0);
        camera1.setResolution(640, 480);
        camera2 = CameraServer.getInstance().startAutomaticCapture(1);
        camera2.setResolution(640, 480);
    }
}

// https://docs.wpilib.org/en/latest/docs/software/vision-processing/introduction/using-the-cameraserver-on-the-roborio.html