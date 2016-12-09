package com.cameo.root.ale;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.analytics.FirebaseAnalytics;

public class userPannel extends AppCompatActivity {

    TextView outSign;
    boolean check;
    private GoogleApiClient mGoogleApiClient;
    private FirebaseAnalytics mFirebaseAnalytics;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pannel);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);


        check = true;


//        outSign = (TextView) findViewById(R.id.SignOut);
//        outSign.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Firebase sign out
//                FirebaseAuth.getInstance().signOut();
//                sharedPreferences = getSharedPreferences("SharedPrefData", MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putBoolean("pref_Flag", false);
//                editor.commit();
//                nextActivity();
//
//            }
//
//        });

//        // Obtain the FirebaseAnalytics instance.
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
//
//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        mRecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        // specify an adapter (see also next example)
//        mAdapter = new RecyclerView.Adapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);


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
        if(check == true)
        {
            Toast.makeText(userPannel.this,"Press back again to Exit", Toast.LENGTH_SHORT).show();
            check = false;
        }
        else
        {
            check = true;
            userPannel.this.moveTaskToBack(true);
        }
    }

}
