package ghosthunter;

import java.util.List;

import framework.Game;
import framework.Graphics;
import framework.Screen;
import framework.Input.TouchEvent;
import framework_implementation.AndroidGraphics;


public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();


        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {

                if (inBounds(event, 80, 150, 500, 350)) {
                    //START GAME
                    game.setScreen(new GameScreen(game));
                }


            }
        }
    }


    private boolean inBounds(TouchEvent event, int x, int y, int width,
                             int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }


    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        ((AndroidGraphics)g).drawScaledImage(Assets.menu, 0, 0, 800, 1280, 0, 0, Assets.menu.getWidth(), Assets.menu.getHeight());

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
        //Display "Exit Game?" Box


    }
}
