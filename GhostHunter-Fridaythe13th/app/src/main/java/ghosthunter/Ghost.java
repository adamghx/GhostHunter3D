package ghosthunter;

import android.graphics.Rect;

import framework.Image;

/**
 * Created by Christian on 4/21/2015.
 */
public class Ghost {
    private int centerX, centerY, speed;
    private Rect ghostBox;
    private Image ghost;
    private Human human;
//    private boolean isMovingLeft=false;
//    private boolean isMovingRight=false;
//    private boolean isMovingUp=false;
//    private boolean isMovingDown=false;

    public Ghost(Human human, int edge) {
        // 800 X 1280
        //north edge
        if(edge == 0) {
            this.centerX = (int)(Math.random()*800);
            this.centerY = -50;
        }
        //east edge
        if(edge == 1) {
            this.centerX = 850;
            this.centerY = (int)(Math.random()*1250);
        }
        //south edge
        if(edge == 2) {
            this.centerX = (int)(Math.random()*800);
            this.centerY = 1330;
        }
        //west edge
        if(edge == 3) {
            this.centerX = -50;
            this.centerY = (int)(Math.random()*1250);
        }
        this.human = human;
        this.ghost = Assets.ghost;
        this.ghostBox = new Rect(centerX, centerY,centerX + ghost.getWidth(), centerY + ghost.getHeight());
        speed = 3;
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

    public Rect getGhostBox(){
        return this.ghostBox;
    }

    public Image getGhost(){
        return this.ghost;
    }

    //These are the mutators
    public void setCenterX(int x){
        this.centerX = x;
    }

    public void setCenterY(int y){
        this.centerY = y;
    }

    public void setGhostBox(Rect rect){
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
