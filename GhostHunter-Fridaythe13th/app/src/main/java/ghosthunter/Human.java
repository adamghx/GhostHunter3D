package ghosthunter;

import android.graphics.Rect;
import android.view.View;

import framework.Image;

/**
 * Created by Emily on 4/19/2015.
 */


public class Human {
    private int centerX, centerY, xspeed;
    private Rect humanBox;
    private Image human;

    public Human() {
        this.centerX = 250;
        this.centerY = 250;
        this.human = Assets.human;
        this.humanBox = new Rect(centerX, centerY,centerX + human.getWidth(), centerY + human.getHeight());
        xspeed = 5;
    }

    //Called in the GameScreen
    public void update(){
        humanBox.set(this.centerX, this.centerY, centerX+human.getWidth(), centerY+human.getHeight());
    }

    //These are the accessors
    public int getCenterX(){
        return this.centerX;
    }

    public int getCenterY(){
        return this.centerY;
    }

    public Rect getHumanBox(){
        return this.humanBox;
    }

    public Image getHuman(){
        return this.human;
    }
    //These are the mutators
    public void setCenterX(int x){
        this.centerX = x;
    }

    public void setCenterY(int y){
        this.centerY = y;
    }

    public void setHumanBox(Rect rect){
        this.humanBox = rect;
    }


    public void moveLeft() {
        this.centerX-=xspeed;
    }
    public void moveRight() {
        this.centerX+=xspeed;
    }
}
