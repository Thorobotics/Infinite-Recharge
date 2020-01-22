package frc.robot.Subsystems;

import java.util.HashMap;
import java.util.Map;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

/** ColorSensor -> this is for the spinner
 * 
 * COlorSensorV3 is the color sensor we're using
 *I2C port is the port we're using
 */
public class ColorSensor {
    private final I2C.Port I2C_PORT = I2C.Port.kOnboard;
    private final ColorSensorV3 COLOR_SENSOR = new ColorSensorV3(I2C_PORT);
    private final ColorMatch COLOR_MATCHER = new ColorMatch();

    private final Color COLOR_BLUE = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color COLOR_GREEN = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color COLOR_RED = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color COLOR_YELLOW = ColorMatch.makeColor(0.361, 0.524, 0.113);
// (COLOR_"COLOR") = (TARGET_"COLOR")
// #s represent the color (RGB)
    private Color targetColor;

    public final Map<Color, Color> DETECTED_2_TARGET = new HashMap<>(); //Walter: String -> Color
// we are now on the color sensor
    public ColorSensor(){
        this.COLOR_MATCHER.addColorMatch(COLOR_BLUE);
        this.COLOR_MATCHER.addColorMatch(COLOR_GREEN);
        this.COLOR_MATCHER.addColorMatch(COLOR_RED);
        this.COLOR_MATCHER.addColorMatch(COLOR_YELLOW);
/* 
* why? Keep in mind the spinner is constantly spinning
*  detecting 2 colors -> Blue to Green, Green to Red, Red to Yellow, Yellow to Blue
*The colors are ordered in Blue, Green, Red, and Yellow
*/
        this.DETECTED_2_TARGET.put(COLOR_YELLOW, COLOR_BLUE);
        this.DETECTED_2_TARGET.put(COLOR_BLUE, COLOR_GREEN);
        this.DETECTED_2_TARGET.put(COLOR_GREEN, COLOR_RED);
        this.DETECTED_2_TARGET.put(COLOR_RED, COLOR_YELLOW);
    }

    public Color getColor() {
        return this.COLOR_SENSOR.getColor();
    }


// Code is over half way done 1/20/20 -NATASHA. Cool it Natasha, i got this
    public String getColorString() {
        ColorMatchResult colorMatch = this.COLOR_MATCHER.matchClosestColor(getColor());
        if (colorMatch.color == COLOR_BLUE){
            return "Blue";
        } else if (colorMatch.color == COLOR_GREEN){
            return "Green";
        } else if (colorMatch.color == COLOR_RED){
            return "Red";
        } else if (colorMatch.color == COLOR_YELLOW){
            return "Yellow";
        }
         return "Unknown";
    }

    public void setTargetColor(Color target){
        this.targetColor = target;
    }

    public boolean matchColor(){
        ColorMatchResult colorMatch = this.COLOR_MATCHER.matchClosestColor(this.getColor());
        return colorMatch.color == this.targetColor;
    }
}