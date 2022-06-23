package com.example.otpverification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class startlauncher extends AppCompatActivity {

    Timer timer;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.skyblue));

        setContentView(R.layout.activity_startlauncher);



        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser != null){
            //loggedIN
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(startlauncher.this, dashboard.class);
                    startActivity(intent);
                    finish();
                }
            }, 1800);

        }
        else{
            //no one logged in
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(startlauncher.this, entermobilenumber.class);
                    startActivity(intent);
                    finish();
                }
            }, 1800);

        }
    }
}