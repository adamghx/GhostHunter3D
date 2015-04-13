package mzw7af.cs2110.virginia.edu.ghosthunter_fridaythe13th;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }




    public void startClick(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        this.startActivity(intent);
    }
}
