package ghosthunter;
import framework.Screen;
import framework_implementation.AndroidGame;

/**
 * Created by Emily on 4/19/2015.
 */
public class GhostGame extends AndroidGame {
    @Override
    public Screen getInitScreen() {
        return new LoadingScreen(this);
    }
}
