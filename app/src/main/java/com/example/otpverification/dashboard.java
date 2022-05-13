package com.example.otpverification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class dashboard extends AppCompatActivity {
    TextView textView1, textView2, textView3, textView4, textView5, textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.skyblue));

        setContentView(R.layout.activity_dashboard1);

        ImageView imageView;
        imageView = findViewById(R.id.imageViewNavigate);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), navigationdrawer.class);
                startActivity(intent);
            }
        });

        textView1 = findViewById(R.id.tv1);
        startCountAnimation1();


        textView3 = findViewById(R.id.tv3);
        startCountAnimation3();

        textView5 = findViewById(R.id.tv5);
        startCountAnimation5();



        CardView card1, card2, card3, card4, card5, card6;

        card1 = findViewById(R.id.cardView);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), institutelist.class);
                startActivity(intent);
            }
        });

        card2 = findViewById(R.id.cardView2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), webgraph.class);
                startActivity(intent);
            }
        });


        card3 = findViewById(R.id.cardView3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), webfaculty.class);
                startActivity(intent);
            }
        });

        card4 = findViewById(R.id.cardView4);
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), webscheme.class);
                startActivity(intent);
            }
        });

        card5 = findViewById(R.id.cardView5);
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), webplacement.class);
                startActivity(intent);
            }
        });

        card6 = findViewById(R.id.cardView6);
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), webnews.class);
                startActivity(intent);
            }
        });

    }

    private void startCountAnimation1() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 8997);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                textView1.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }

    private void startCountAnimation3() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 558837);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                textView3.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }

    private void startCountAnimation5() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 652322);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                textView5.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }

}