package ghosthunter;

import android.graphics.Rect;
import android.view.View;

import framework.Image;

/**
 * Created by Emily on 4/19/2015.
 */


public class Human {
    private float centerX, centerY;
    private Rect humanBox;
    private Image human;

    public Human() {
        this.centerX = 0;
        this.centerY = 0;
        this.humanBox = new Rect(0, 0, human.getWidth(), human.getHeight());
        this.human = Assets.human;
    }

    //Called in the GameScreen
    public void update(){

    }

    //These are the accessors
    public float getCenterX(){
        return this.centerX;
    }

    public float getCenterY(){
        return this.centerY;
    }

    public Rect getHumanBox(){
        return this.humanBox;
    }

    public Image getHuman(){
        return this.human;
    }
    //These are the mutators
    public void setCenterX(float x){
        this.centerX = x;
    }

    public void setCenterY(float y){
        this.centerY = y;
    }

    public void setHumanBox(Rect rect){
        this.humanBox = rect;
    }
}
