package ghosthunter;

import android.graphics.Rect;

import framework.Image;

/**
 * Created by Christian on 4/21/2015.
 */
public class Projectile {
    private int centerX, centerY, speed;
    private Rect projectileBox;
    private Image projectile;
    private Human human;
//    private boolean isMovingLeft=false;
//    private boolean isMovingRight=false;
//    private boolean isMovingUp=false;
//    private boolean isMovingDown=false;

    public Projectile(Human human) {
        this.centerX = 1000;
        this.centerY = 1000;
        this.human = human;
        this.projectile = Assets.projectile;
        this.ghostBox = new Rect(centerX, centerY,centerX + ghost.getWidth(), centerY + ghost.getHeight());
        speed = 2;
    }

    //Called in the GameScreen
    public void update(){
        ghostBox.set(this.centerX, this.centerY, centerX+ghost.getWidth(), centerY+ghost.getHeight());
        if(human.getCenterX() > this.getCenterX()) {
            centerX+=speed;
        }
        if(human.getCenterX() < this.getCenterX()) {
            centerX-=speed;
        }
        if(human.getCenterY() > this.getCenterY()) {
            centerY+=speed;
        }
        if(human.getCenterY() < this.getCenterY()) {
            centerY-=speed;
        }

    }

    //These are the accessors
    public int getCenterX(){
        return this.centerX;
    }

    public int getCenterY(){
        return this.centerY;
    }

    public Rect getProjectileBox(){
        return this.projectileBox;
    }

    public Image getProjectile(){
        return this.ghost;
    }

    //These are the mutators
    public void setCenterX(int x){
        this.centerX = x;
    }

    public void setCenterY(int y){
        this.centerY = y;
    }

    public void setProjectileBox(Rect rect){
        this.ghostBox = rect;
    }


    public void moveLeft() {
        this.centerX-=speed;
    }
    public void moveRight() {
        this.centerX+=speed;
    }

//    public void setMovingLeft(boolean b) {
//        isMovingLeft = b;
//    }
//
//    public void setMovingRight(boolean b) {
//        isMovingRight = b;
//    }
//
//    public void setMovingUp(boolean b) {
//        isMovingUp = b;
//    }
//
//    public void setMovingDown(boolean b) {
//        isMovingDown = b;
//    }
}
