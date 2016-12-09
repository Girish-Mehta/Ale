package com.cameo.root.ale;

/**
 * Created by Girish-Mehta on 31/10/16.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Welcome_FullscreenActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome_fullscreen);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        CountDownTimer cdt = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                sharedPreferences = getSharedPreferences("SharedPrefData",MODE_PRIVATE);
                if (sharedPreferences.getBoolean("pref_Flag", false))
                {
                    userPannel();
                }
                else
                {
                    emailActivity();
                }
                finish();
            }
        };
        cdt.start();

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        //findViewById(R.id.).setOnTouchListener(mDelayHideTouchListener);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
    }

    private void emailActivity()
    {
        Intent intent = new Intent(this,EmailPasswordActivity.class);
        startActivity(intent);

    }

    private void userPannel()
    {
        Intent intent = new Intent(this,userPannel.class);
        startActivity(intent);

    }
}
