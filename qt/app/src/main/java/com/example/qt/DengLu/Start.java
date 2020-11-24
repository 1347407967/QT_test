package com.example.qt.DengLu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.qt.MainActivity;
import com.example.qt.R;

public class Start extends AppCompatActivity {
    private static final long SPLASH_LENGTH = 2000;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Start.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_LENGTH);

    }
}
