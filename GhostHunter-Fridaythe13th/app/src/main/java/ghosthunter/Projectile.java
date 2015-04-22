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
    private int savedState;
    private boolean isMovingLeft=false;
    private boolean isMovingRight=false;
    private boolean isMovingUp=false;
    private boolean isMovingDown=false;

    public Projectile(int savedState, int x, int y) {
        this.centerX = x;
        this.centerY = y;
        this.projectile = Assets.projectile;
        this.savedState = savedState;
        this.projectileBox = new Rect(centerX, centerY,centerX + projectile.getWidth(), centerY + projectile.getHeight());
        speed = 20;
    }

    //Called in the GameScreen
    public void update(){
        projectileBox.set(this.centerX, this.centerY, centerX+projectile.getWidth(), centerY+projectile.getHeight());
        if(this.savedState == 1 ) {
            centerY-=speed;
        }
        if(this.savedState == 2) {
            centerX+=speed;
        }
        if(this.savedState == 3) {
            centerY+=speed;
        }
        if(this.savedState == 4) {
            centerX-=speed;
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
        return this.projectile;
    }

    //These are the mutators
    public void setCenterX(int x){
        this.centerX = x;
    }

    public void setCenterY(int y){
        this.centerY = y;
    }

    public void setProjectileBox(Rect rect){
        this.projectileBox = rect;
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
