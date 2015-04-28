package ghosthunter;

import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Random;

import framework.Image;

/**
 * Created by Emily on 4/27/2015.
 */
public class PowerUp {
    private int type, centerX, centerY;
    private Rect powerBox;
    private Image powerUp;
    final int CLEAR_BOMB = 0;
    final int FOUR_DIRECTION = 1;

    public PowerUp(int centerX, int centerY){
        this.type = (int)(Math.random()*2);
        this.centerX = centerX;
        this.centerY = centerY;

        if(this.type == 0) {
           this.powerUp = Assets.clear_bomb;
        }
        if(this.type == 1) {
            this.powerUp = Assets.four_direction;
        }
        this.powerBox = new Rect(centerX, centerY, centerX+powerUp.getWidth(), centerY+powerUp.getHeight());

    }

    public void clear(ArrayList<Ghost> ghosts){
        ghosts.removeAll(ghosts);
    }

    public void fourDirections(Human human){
        human.setFourDirections(true);
    }

    public Rect getPowerBox(){
        return this.powerBox;
    }

    public void setPowerRect(Rect r){
        this.powerBox = r;
    }

    public int getCenterX(){
        return this.centerX;
    }
    public int getCenterY(){
        return this.centerY;
    }
    public int getType(){
        return this.type;
    }
    public Image getImage() { return this.powerUp; }
}
