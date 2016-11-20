package com.cameo.root.ale;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class userPannel extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pannel);
    }

    public void signOut()
    {
        FirebaseAuth.getInstance().signOut();
        sharedPreferences = getSharedPreferences("SharedPrefData",MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean("pref_Flag",false);
        editor.apply();
        Intent intent = new Intent(this,EmailPasswordActivity.class);
        startActivity(intent);
    }
}
