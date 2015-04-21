package ghosthunter;

import framework.Game;
import framework.Graphics;
import framework.Screen;
import framework.Graphics.ImageFormat;
/**
 * Created by Emily on 4/19/2015.
 */
public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("game_background.png", ImageFormat.RGB565);
//        Assets.click = game.getAudio().createSound("explode.ogg");
        Assets.human = g.newImage("character_box.png", ImageFormat.RGB565);
        Assets.background = g.newImage("game_background.png", ImageFormat.RGB565);
        Assets.joystick_background = g.newImage("joystick_background.png", ImageFormat.RGB565);
        Assets.joystick_ball = g.newImage("joystick_ball.png", ImageFormat.RGB565);
        game.setScreen(new MainMenuScreen(game));
    }


    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(Assets.splash, 0, 0);
    }


    @Override
    public void pause() {


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
