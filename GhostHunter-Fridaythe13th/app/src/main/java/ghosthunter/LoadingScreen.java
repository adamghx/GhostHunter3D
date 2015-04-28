package ghosthunter;

import android.graphics.Color;
import android.graphics.Paint;

import framework.Game;
import framework.Graphics;
import framework.Screen;
import framework.Graphics.ImageFormat;
import framework_implementation.AndroidGraphics;

/**
 * Created by Emily on 4/19/2015.
 */
public class LoadingScreen extends Screen {

    Paint paint;
    public LoadingScreen(Game game) {
        super(game);
        paint = new Paint();
        paint.setTextSize(40);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("main_menu.png", ImageFormat.RGB565);
//        Assets.click = game.getAudio().createSound("explode.ogg");
        Assets.human = g.newImage("character_front.png", ImageFormat.RGB565);
        Assets.background = g.newImage("game_background.png", ImageFormat.RGB565);
        Assets.joystick_background = g.newImage("joystick_background.png", ImageFormat.RGB565);
        Assets.fire_button = g.newImage("button.png", ImageFormat.RGB565);
        Assets.ghost = g.newImage("ghost_front.png", ImageFormat.RGB565);
        Assets.projectile = g.newImage("projectile.png", ImageFormat.RGB565);

        Assets.heart = g.newImage("heart.png",ImageFormat.RGB565);

        Assets.logo = g.newImage("logo.png", ImageFormat.RGB565);

        resize();
        try{
            Thread.sleep(4000);}
        catch(Exception e){

         }

        game.setScreen(new MainMenuScreen(game));

    }


    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
//        ((AndroidGraphics)g).drawScaledImage(Assets.splash, 0, 0, 800, 1280, 0, 0, Assets.splash.getWidth(), Assets.splash.getHeight());
        g.drawRect(0, 0, 800, 1280, Color.BLACK);
        g.drawString("Maurice Wong", 200, 500, paint);
        g.drawString("Emily Zhou", 200, 550, paint);
        g.drawString("Christian Lastova", 200, 600, paint);
        g.drawString("Adam Guo", 200, 650, paint);
        g.drawString("University of Virginia, CS2110, Spring 2015", 400, 750, paint);
        g.drawImage(Assets.logo, 200, 800);
        g.drawString("Thanks to Kilobolt.com!", 300, 1050, paint);
    }


    @Override
    public void pause() {


    }

    //resizes the original image
    public void resize() {
        Assets.background.scaleImage(800,1280);
        Assets.projectile.scaleImage(50,50);
        Assets.joystick_background.scaleImage(300,300);
        Assets.fire_button.scaleImage(200,200);
        Assets.ghost.scaleImage(172,192);
        Assets.human.scaleImage(94,192);
        Assets.heart.scaleImage(40, 40);
        Assets.logo.scaleImage(150, 150);
    }

    @Override
    public void resume() {


    }


    @Override
    public void dispose() {


    }


    @Override
    public void backButton() {


    }
}
