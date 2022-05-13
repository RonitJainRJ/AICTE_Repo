package com.example.otpverification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class entermobilenumber extends AppCompatActivity {

    EditText enternumber;
    Button getotpbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.skyblue));

        setContentView(R.layout.entermobilenumber);
        enternumber = findViewById(R.id.inputmobilenumber);
        getotpbutton = findViewById(R.id.buttongetotp);

        ProgressBar progressBar = findViewById(R.id.progressbar_getotp);

        getotpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!enternumber.getText().toString().trim().isEmpty()) {
                    if (enternumber.getText().toString().trim().length() == 10) {

                        progressBar.setVisibility(View.VISIBLE);
                        getotpbutton.setVisibility(View.INVISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + enternumber.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                entermobilenumber.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressBar.setVisibility(View.VISIBLE);
                                        getotpbutton.setVisibility(View.INVISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.VISIBLE);
                                        getotpbutton.setVisibility(View.INVISIBLE);
                                        Toast.makeText(entermobilenumber.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressBar.setVisibility(View.VISIBLE);
                                        getotpbutton.setVisibility(View.INVISIBLE);

                                        Intent intent = new Intent(getApplicationContext(), verifyenterdotp.class);
                                        intent.putExtra("mobile", enternumber.getText().toString());
                                        intent.putExtra("backendotp", backendotp);
                                        startActivity(intent);
                                    }
                                }
                        );
                    } else {
                        Toast.makeText(entermobilenumber.this, "Please Enter Correct Number!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(entermobilenumber.this, "Enter Mobile Number!!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}