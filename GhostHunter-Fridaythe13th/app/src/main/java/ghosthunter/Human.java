package ghosthunter;

import android.graphics.Rect;
import android.view.View;

import java.util.ArrayList;

import framework.Image;

/**
 * Created by Emily on 4/19/2015.
 */


public class Human {
    private int centerX, centerY, speed;
    private Rect humanBox;
    private Image human;
    private boolean isMovingLeft=false;
    private boolean isMovingRight=false;
    private boolean isMovingUp=false;
    private boolean isMovingDown=false;
    private int savedMovingState;
    private ArrayList<Projectile> projectiles;
    private static final int STATE_UP = 1;
    private static final int STATE_RIGHT = 2;
    private static final int STATE_DOWN = 3;
    private static final int STATE_LEFT = 4;

    public Human() {
        this.centerX = 250;
        this.centerY = 250;
        this.human = Assets.human;
        this.humanBox = new Rect(centerX, centerY,centerX + human.getWidth(), centerY + human.getHeight());
        this.projectiles = new ArrayList<Projectile>();
        speed = 7;
    }

    //Called in the GameScreen
    public void update(){
        humanBox.set(this.centerX, this.centerY, centerX+human.getWidth(), centerY+human.getHeight());
        if(this.isMovingLeft==true) {
            centerX-=speed;
            savedMovingState = STATE_LEFT;
        }
        if(this.isMovingRight==true) {
            centerX+=speed;
            savedMovingState = STATE_RIGHT;
        }
        if(this.isMovingUp==true) {
            centerY-=speed;
            savedMovingState = STATE_UP;
        }
        if(this.isMovingDown==true) {
            centerY+=speed;
            savedMovingState = STATE_DOWN;
        }

    }

    public void fire() {
        Projectile p = new Projectile(this.savedMovingState, this.centerX + (human.getWidth()/2), this.centerY + (human.getHeight()/2));
        projectiles.add(p);
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

    public ArrayList<Projectile> getProjectiles() {
        return this.projectiles;
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
        this.centerX-=speed;
    }
    public void moveRight() {
        this.centerX+=speed;
    }

    public void setMovingLeft(boolean b) {
        isMovingLeft = b;
    }

    public void setMovingRight(boolean b) {
        isMovingRight = b;
    }

    public void setMovingUp(boolean b) {
        isMovingUp = b;
    }

    public void setMovingDown(boolean b) {
        isMovingDown = b;
    }
}
