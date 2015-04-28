package ghosthunter;

/**
 * Created by adamguo on 4/19/15.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import framework.Game;
import framework.Graphics;
import framework.Image;
import framework.Screen;
import framework.Input.TouchEvent;
import framework_implementation.AndroidGame;
import framework_implementation.AndroidGraphics;

//Android Screen Dimensions: 800dp X 1280dp
public class GameScreen extends Screen {
    enum GameState {
        Ready, Running, Paused, GameOver
    }

    GameState state = GameState.Ready;

    // Variable Setup
    // You would create game objects here.


    private static Human human;
    private ArrayList<Ghost> ghosts;
    private ArrayList<PowerUp> powerUps;
    private Joystick joystick;
    private Rect joystickSpace;
    private Rect buttonSpace;
    private Rect screenSpace;
    private int counter, fireCounter;
    int joystickMovement = 0;
    int livesLeft = 3;
    int mod_value;
    int ghost_speed;
    Paint paint;
<<<<<<< HEAD
    private boolean proximity;
=======
    SharedPreferences prefs;
    int score;
>>>>>>> origin/master

    public GameScreen(Game game) {
        super(game);
        screenSpace = new Rect(0,0,800,1280);
        human = new Human();
        this.ghosts = new ArrayList<Ghost>();
        joystick = new Joystick();
        joystickSpace = joystick.getJoystickRect();
        buttonSpace = new Rect(550, 1000, 750, 1200);
        this.counter = 0;
        this.ghost_speed = 2;
        this.mod_value = 200;
<<<<<<< HEAD
        proximity = false;
=======

        //getting the high score
        prefs = ((AndroidGame)super.game).getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        score = prefs.getInt("key", 0); //0 is the default value if nothing is found.

>>>>>>> origin/master
        // Defining a paint object
        paint = new Paint();
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        this.powerUps = new ArrayList<PowerUp>();

    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        // We have four separate update methods in this example.
        // Depending on the state of the game, we call different update methods.
        // Refer to Unit 3's code. We did a similar thing without separating the
        // update methods.

        if (state == GameState.Ready)
            updateReady(touchEvents);
        if (state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if (state == GameState.Paused)
            updatePaused(touchEvents);
        if (state == GameState.GameOver)
            updateGameOver(touchEvents);
    }

    private void updateReady(List<TouchEvent> touchEvents) {

        // This example starts with a "Ready" screen.
        // When the user touches the screen, the game begins.
        // state now becomes GameState.Running.
        // Now the updateRunning() method will be called!

        if (touchEvents.size() > 0)
            state = GameState.Running;
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {

        //This is identical to the update() method from our Unit 2/3 game.

        Graphics g = game.getGraphics();
        // 1. All touch input is handled here:
        int len = touchEvents.size();

        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);

            if (event.type == TouchEvent.TOUCH_DRAGGED || event.type == TouchEvent.TOUCH_DOWN) {
                Log.d("touch", "touch");
                if (joystickSpace.contains(event.x, event.y)) {
                    Log.d("contains", "contains");
                   joystickMovement = joystick.determineMovement(event.x, event.y);
                    if (joystickMovement == 1) {
                        human.setMovingUp(true);
                        human.setMovingDown(false);
                        human.setMovingLeft(false);
                        human.setMovingRight(false);
                    }
                    else if (joystickMovement == 2) {
                        human.setMovingUp(false);
                        human.setMovingDown(false);
                        human.setMovingLeft(false);
                        human.setMovingRight(true);
                    }
                    else if (joystickMovement == 3) {
                        human.setMovingUp(false);
                        human.setMovingDown(true);
                        human.setMovingLeft(false);
                        human.setMovingRight(false);
                    }
                    else if (joystickMovement == 4) {
                        human.setMovingUp(false);
                        human.setMovingDown(false);
                        human.setMovingLeft(true);
                        human.setMovingRight(false);
                    }
                }
            }
            if (event.type == TouchEvent.TOUCH_UP) {

                    human.setMovingLeft(false);
                    human.setMovingUp(false);
                    human.setMovingRight(false);
                    human.setMovingDown(false);
                    joystickMovement = 0;
            }
            if (event.type == TouchEvent.TOUCH_DOWN) {
                if (buttonSpace.contains(event.x, event.y)) {
                    Log.d("projectile" , "fire");
                    if(human.getFourDirections() == true && fireCounter <= 30){
                        human.fireFour();
                        fireCounter += 1;
                        Log.d("fourDirections", "firing");
                    } else {
                        human.setFourDirections(false);
                        human.fire();
                        fireCounter = 0;
                    }
                }
            }

        }

        // 2. Check miscellaneous events like death:

        counter += 1;
        if(counter % 1350 == 0) {
            ghost_speed += 1;
        }
        if(counter % 200 == 0 && mod_value > 30){
            mod_value = mod_value - 10;
        }
        if(counter >= 750){
            if(counter % (mod_value+20) == 0 && mod_value >= 20){
                int edge = (int) (Math.random() * 4);
                ghosts.add(new Ghost(human, edge, ghost_speed));
            }
        }
        if(counter >= 3000){
            if(counter % (mod_value+35) == 0 && mod_value >= 20){
                int edge = (int) (Math.random() * 4);
                ghosts.add(new Ghost(human, edge, ghost_speed));
            }
        }
        if(counter % mod_value == 0 && mod_value >= 20){
            int edge = (int) (Math.random() * 4);
            ghosts.add(new Ghost(human, edge, ghost_speed));
        }


        // 3. Call individual update() methods here.
        // This is where all the game updates happen.
        // For example, robot.update();
        human.update();
        for(Ghost ghost : ghosts){
            if(ghost.getGhostBox().intersect(human.getHumanBox())){

                if(human.getHumanBox().centerX() > ghost.getGhostBox().centerX()){
                    ghost.setCenterX(ghost.getCenterX() - 150);
                } else {
                    ghost.setCenterX(ghost.getCenterX() + 150);
                }
                if(human.getHumanBox().centerY() > ghost.getGhostBox().centerY()){
                    ghost.setCenterY(ghost.getCenterY() - 150);
                } else {
                    ghost.setCenterY(ghost.getCenterY() + 150);
                }

                livesLeft -= 1;
                Log.d("livesLeft", "-1");
            }
            if (livesLeft == 0) {
                state = GameState.GameOver;
            }
            // This is where user get alerted when ghosts get close to the human
            double xDirectionDistance = human.getHumanBox().centerX() - ghost.getGhostBox().centerX();
            double yDirectionDistance = human.getHumanBox().centerY() - ghost.getGhostBox().centerY();
            double humanGhostDistance = Math.hypot(xDirectionDistance,yDirectionDistance);
            if (humanGhostDistance < 420) {
                Log.d("PROXIMITY","PROXIMITY");
                proximity = true;
            }
            else {
                proximity = false;
            }

            ghost.update();
        }

        //Checking projectile collision with ghosts
        for(int p = 0; p < human.getProjectiles().size(); p++) {
            boolean remove = false;
            human.getProjectiles().get(p).update();

            //Checking for projectile-ghost collision
            for(int ghostnum = 0; ghostnum < ghosts.size(); ghostnum++){
                if (ghosts.get(ghostnum).getGhostBox().intersect(human.getProjectiles().get(p).getProjectileBox())) {

                    //Putting down power ups
                    int rand = (int)(Math.random()*10);
                    if(rand == 2){
                        powerUps.add(new PowerUp(ghosts.get(ghostnum).getCenterX(), ghosts.get(ghostnum).getCenterY()));
                    }
                    if(powerUps.size() > 4){
                        powerUps.remove(0);
                    }

                    //Removing ghosts that are hit by projections
                    ghosts.remove(ghosts.get(ghostnum));
                    remove = true;
                }
            }

            if (!human.getProjectiles().get(p).getProjectileBox().intersect(screenSpace)) {
                remove = true;
            }

            if(remove) {
                human.getProjectiles().remove(human.getProjectiles().get(p));
            }

        }


        for(PowerUp powerUp : powerUps){
            if(human.getHumanBox().intersect(powerUp.getPowerBox())){
                Log.d("power up", "picked up");
                if(powerUp.getType() == 0){
                    powerUp.clear(ghosts);
                    powerUps.remove(powerUp);
                } else if(powerUp.getType() == 1){
                    if(human.getFourDirections() == true){
                        fireCounter = 0;
                        powerUps.remove(powerUp);
                    }
                    if(human.getFourDirections() == false) {
                        powerUp.fourDirections(human);
                        powerUps.remove(powerUp);
                    }
                }
             
            }
        }

    }

    private void updatePaused(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {

            }
        }
    }

    private void updateGameOver(List<TouchEvent> touchEvents) {
        //get high score
        score = prefs.getInt("key", 0);

        //setting high score
        if (counter > score) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("key", counter);
            editor.commit();
        }
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_DOWN) {
                if(event.x > 200 && event.x < 600 && event.y > 1100 && event.y < 1200) {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("key", 0);
                    editor.commit();
                    counter = 0;
                }
                if (event.x > 200 && event.x < 600 && event.y > 800
                        && event.y < 1000) {
                    nullify();
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();

        // First draw the game elements.
        //Draw the background
        g.drawImage(Assets.background,0,0);
        // Then draw the game elements.
        g.drawImage(Assets.human,human.getCenterX(),human.getCenterY());
        for(Ghost ghost : ghosts){
            g.drawImage(Assets.ghost, ghost.getCenterX(), ghost.getCenterY());
        }
        for(Projectile p : human.getProjectiles()){
            g.drawImage(Assets.projectile, p.getCenterX(), p.getCenterY());
        }
        g.drawImage(Assets.joystick_background, joystick.getxCoor(), joystick.getyCoor());
        g.drawImage(Assets.fire_button,550,1000);
        g.drawString("Score: " + counter, 690, 75, paint);
        int xcoor = 40;
        for(int i = 0; i<livesLeft; i++) {
            g.drawImage(Assets.heart, xcoor, 50);
            xcoor+= 60;
        }
        //Drawing all power ups
        for(PowerUp powerUp : powerUps){
            g.drawImage(Assets.projectile, powerUp.getCenterX(), powerUp.getCenterY());
        }

        // Example:
        //g.drawImage(Assets.background, 0, 0);
        //g.drawImage(Assets.character, characterX, characterY);

        // Secondly, draw the UI above the game elements.
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI();
        if (state == GameState.Paused)
            drawPausedUI();
        if (state == GameState.GameOver)
            drawGameOverUI();

    }

    private void nullify() {

        // Set all variables to null. You will be recreating them in the
        // constructor.
        paint = null;

        // Call garbage collector to clean up memory.
        System.gc();
    }

    private void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawARGB(155, 0, 0, 0);
        g.drawString("Tap to begin.",
                400, 300, paint);
        g.drawString("Use this to move.", 370, 950, paint);
        g.drawString("These are your lives.", 140, 110, paint);

    }

    private void drawRunningUI() {
        Graphics g = game.getGraphics();
        g.drawString("Score: " + counter, 690, 75, paint);
        Image heart = Assets.human;
        int xcoor = 40;
        for(int i = 0; i<livesLeft; i++) {
            g.drawImage(Assets.heart, xcoor, 50);
            xcoor+= 60;
        }
        if (proximity == true) {
            g.drawString("Ghost Approaching!", 200, 200, paint);
        }

    }

    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        // Darken the entire screen so you can display the Paused screen.
        g.drawARGB(155, 0, 0, 0);

    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();

        g.drawRect(0, 0, 810, 1300, Color.BLACK);
        g.drawString("GAME OVER.", 400, 300, paint);
        g.drawString("Your Score Is: "+counter, 400, 350, paint);
        g.drawString("High Score: " + score, 400, 400, paint);
        g.drawString("To Return to Menu, Tap Below", 400, 600, paint);
        g.drawString("Play Again", 400, 900, paint);
        g.drawString("Reset Scores", 400,1150, paint);
    }

    @Override
    public void pause() {
        if (state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
        pause();
    }
}