package com.example.qt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private FrameLayout fl_body;
    private TextView tv_main;
    private TextView tv_my;
    private TextView tv_sq;
    private TextView tv_xx;
    private ImageView iv_main;
    private ImageView iv_sq;
    private ImageView iv_xx;
    private ImageView iv_my;
    private RelativeLayout rl_main;
    private RelativeLayout rl_my;
    private RelativeLayout rl_sq;
    private RelativeLayout rl_xx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        fl_body = findViewById(R.id.fl_body);//界面
        /*
        * 文字*/
        tv_main = findViewById(R.id.tv_main);
        tv_my = findViewById(R.id.tv_my);
        tv_sq = findViewById(R.id.tv_sq);
        tv_xx = findViewById(R.id.tv_xx);
        /*
        * 图片*/
        iv_main = findViewById(R.id.iv_main);
        iv_sq = findViewById(R.id.iv_sq);
        iv_xx = findViewById(R.id.iv_xx);
        iv_my = findViewById(R.id.iv_my);
        /*布局*/
        rl_main = findViewById(R.id.rl_main);
        rl_my = findViewById(R.id.rl_my);
        rl_sq = findViewById(R.id.rl_sq);
        rl_xx = findViewById(R.id.rl_xx);

    }

    /*
    * 点击事件*/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_main:
                break;
            case R.id.rl_sq:
                break;
            case R.id.rl_xx:
                break;
            case R.id.rl_my:
                break;
                default:
                    break;

        }
    }
}
