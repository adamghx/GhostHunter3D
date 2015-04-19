package mzw7af.cs2110.virginia.edu.ghosthunter_fridaythe13th;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Maurice on 4/4/2015.
 */
public class GameActivity extends Activity {

    private float character_x, character_y;
    private float joystick_cx, joystick_cy;
    private ImageView character_image;
    private ImageView joystickback_image;
    private ImageView joystickball_image;
//Emily's comment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setup();
        float[] posXY = new float[2];
        joystickback_image = (ImageView) findViewById(R.id.imageViewJoystickBack);
        joystickball_image = (ImageView) findViewById(R.id.imageViewJoystickBall);
        joystick_cx = joystickback_image.getLeft()+(joystickback_image.getWidth()/2);
        joystick_cy = joystickback_image.getTop()+(joystickback_image.getHeight()/2);
        joystickball_image.setX(joystick_cx);
        joystickball_image.setY(joystick_cy);
        Toast.makeText(getApplicationContext(), Float.toString(joystick_cx),
                Toast.LENGTH_LONG).show();
        //Maurice's Comment, Adam's Comment
        //Christian's Comment
    }

    protected void onResume() {
        super.onResume();

    }

    public void setup() {
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.gameLayout);
        character_image = (ImageView) findViewById(R.id.imageViewCharacter);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event){
//                Toast.makeText(MainActivity.this, "touched", Toast.LENGTH_SHORT).show();
                character_image.setX(event.getX());
                character_image.setY(event.getY());
                return true;
            }
        });

    }
}
