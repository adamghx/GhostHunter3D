package ghosthunter;
import framework.Screen;
import framework_implementation.AndroidGame;

/**
 * Created by Emily on 4/19/2015.
 */
public class GhostGame extends AndroidGame {
    boolean firstTimeCreate = true;

    @Override
    public Screen getInitScreen() {
        if (firstTimeCreate) {
            Assets.load(this);
            firstTimeCreate = false;
        }
        return new LoadingScreen(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        Assets.theme.play();
    }

    @Override
    public void onPause() {
        super.onPause();
        Assets.theme.pause();

    }
}
