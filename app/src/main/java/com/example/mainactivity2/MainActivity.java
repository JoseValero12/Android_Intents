package com.example.mainactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button B;
    private TextView textView;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B = findViewById(R.id.btn1);
        B.setOnClickListener(this);

        textView = findViewById(R.id.textView);

        countDownTimer = new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                Intent i = new Intent(MainActivity.this, MainActivity2_1.class);
                startActivity(i);
            }
        };
    }

    @Override
    public void onClick(View view) {
        countDownTimer.start();
    }
}




