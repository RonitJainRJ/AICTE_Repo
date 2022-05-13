package com.example.otpverification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import android.net.Uri;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.Objects;

public class navigationdrawer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.skyblue));

        setContentView(R.layout.activity_navigationdrawer);

        LinearLayout linearLayout1 = findViewById(R.id.dashboardmove);
        LinearLayout linearLayout2 = findViewById(R.id.approved_college_list);
        LinearLayout linearLayout3 = findViewById(R.id.aictehome1);
        LinearLayout linearLayout5 = findViewById(R.id.closedinstitute1);
        LinearLayout linearLayout4 = findViewById(R.id.closedcourses1);

        LinearLayout linearLayout6 = findViewById(R.id.nripio1);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), dashboard.class);
                startActivity(intent);
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpdf2();
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), webhome.class);
                startActivity(intent);
            }
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), webclosed.class);
                startActivity(intent);
            }
        });

        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpdf5();
            }
        });

        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpdf6();
            }
        });

    }
    private void viewpdf2() {
        // add the link of pdf
        String value="https://www.aicte-india.org/downloads/Institute_List.pdf";
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(value));

        // start activity
        startActivity(intent);
    }

    private void viewpdf5() {
        // add the link of pdf
        String value="https://drive.google.com/file/d/1Ntjx_DIGASYG-fQ9CNktYgr3I8UUavAi/view?usp=sharing";
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(value));

        // start activity
        startActivity(intent);
    }

    private void viewpdf6() {
        // add the link of pdf
        String value="https://drive.google.com/file/d/18E4LrloW7nNYiLXvQdG-crC0XlJqfzNn/view?usp=sharing";
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(value));

        // start activity
        startActivity(intent);
    }
}