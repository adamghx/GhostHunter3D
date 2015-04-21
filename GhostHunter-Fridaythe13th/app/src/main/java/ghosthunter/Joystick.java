package ghosthunter;

import android.graphics.Rect;
import android.util.Log;

import framework.Image;

/**
 * Created by Maurice on 4/20/2015.
 */
public class Joystick {

    private int xCoor, yCoor;
    private int xCenter, yTopMid, yMidBottom;
    private Image joystickBackground = null;
    private Rect joystickRect = null;
    private static final int JOYSTICK_MOVE_UP = 1;
    private static final int JOYSTICK_MOVE_RIGHT = 2;
    private static final int JOYSTICK_MOVE_DOWN = 3;
    private static final int JOYSTICK_MOVE_LEFT = 4;

    //Dimensions of Joystick will be 300X300 located at these coordinates.
    public Joystick()
    {
        xCoor = 30;
        yCoor = 950;
        xCenter = xCoor+150;
        yTopMid = yCoor+100;
        yMidBottom = yCoor+200;
        joystickBackground = Assets.joystick_background;
        joystickRect = new Rect(30,950,330,1250);
    }

    public Image getJoystickBackground() {
        return joystickBackground;
    }


    public Rect getJoystickRect() {
        return joystickRect;
    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public int determineMovement(int x, int y) {
        if (y < yTopMid) {
            Log.d("Up", "up");
            return JOYSTICK_MOVE_UP;
        }
        if (x > xCenter && y < yMidBottom && y > yTopMid) {
            Log.d("right","right");
            return JOYSTICK_MOVE_RIGHT;

        }
        if (y > yMidBottom) {
            Log.d("down","down");
            return JOYSTICK_MOVE_DOWN;
        }
        if (x < xCenter && y < yMidBottom && y > yTopMid) {
            Log.d("left","left");
            return JOYSTICK_MOVE_LEFT;
        }
        return 0;
    }




}
