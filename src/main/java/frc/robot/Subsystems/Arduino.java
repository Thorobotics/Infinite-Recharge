import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public class Arduino{

    public Arduino() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    private static I2C Wire = new I2C(Port.kOnboard, 4);//uses the i2c port on the RoboRIO
    //uses address 4, must match arduino
     //Walter is working on one side of the code, whilist this file works on the other side...
    //
    private static final int MAX_BYTES = 32;

    public static void writeData() { //variable between () 

        Wire.write(4, 1); //Write a single byte to a register on a device and wait until the transaction is complete
        //

    }
    public Double getData() { // we removed static Allan - Nat

    	byte[] data = new byte[MAX_BYTES];//create a byte array to hold the incoming data

		Wire.read(4, MAX_BYTES, data);//use address 4 on i2c and store it in data

		String output = new String(data);//create a string from the byte array

		int pt = output.indexOf((char)255);

		String realOut = (String) output.subSequence(0, pt < 0 ? 0 : pt);

		try {
        	if (realOut == "none") {
        		return 0d;
        	} else {
    
                return Double.parseDouble(realOut);

			}

		} catch (NumberFormatException e) {

			return 0d;

		}

		

    }



    // Called just before this Command runs the first time

    protected void initialize() {

    }



    // Called repeatedly when this Command is scheduled to run

    protected void execute() {

    }



    // Make this return true when this Command no longer needs to run execute()

    protected boolean isFinished() {

        return false;

    }



    // Called once after isFinished returns true

    protected void end() {

    }



    // Called when another command which requires one or more of the same

    // subsystems is scheduled to run

    protected void interrupted() {

    }

}