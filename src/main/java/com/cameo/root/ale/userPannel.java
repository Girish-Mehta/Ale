package com.cameo.root.ale;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

public class userPannel extends AppCompatActivity {

    TextView outSign;

    private GoogleApiClient mGoogleApiClient;

    private FirebaseAnalytics mFirebaseAnalytics;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pannel);

        outSign = (TextView)findViewById(R.id.SignOut);
        outSign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                // Firebase sign out
                FirebaseAuth.getInstance().signOut();
                sharedPreferences = getSharedPreferences("SharedPrefData",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putBoolean("pref_Flag",false);
                editor.commit();
                nextActivity();

            }

        });

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    public void nextActivity()
    {
//        FirebaseAuth.getInstance().signOut();

//        // Google sign out
//        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
//                new ResultCallback<Status>() {
//                    @Override
//                    public void onResult(@NonNull Status status) {
//
//                    }
//                });

        Intent intent = new Intent(this,EmailPasswordActivity.class);
        startActivity(intent);

    }

    public void onBackPressed()
    {
    }
}
