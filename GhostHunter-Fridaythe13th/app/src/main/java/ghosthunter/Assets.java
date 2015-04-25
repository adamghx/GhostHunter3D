package ghosthunter;

/**
 * Created by Christian on 4/19/2015.
 */
import framework.Image;
import framework.Sound;
import framework.Music;

public class Assets {

    public static Image menu;
    public static Image human;
    public static Image button;
    public static Music theme;
    public static Image background;
    public static Image splash;
    public static Image joystick_background;
    public static Image fire_button;
    public static Image ghost;
    public static Image projectile;
    public static Image logo;
    public static Image heart;


    public static void load(GhostGame sampleGame) {
        // TODO Auto-generated method stub
        theme = sampleGame.getAudio().createMusic("ghost_waltz.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }
}
