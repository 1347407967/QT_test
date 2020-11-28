package com.example.qt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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
        initBodyLayout();
        setListener();
    }



    private void initBodyLayout() {
        fl_body = findViewById(R.id.fl_body);//界面
    }



    /*
    * 点击事件*/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_main:
                cleaBottomImageState();
                selectDisplayview(1);
                break;
            case R.id.rl_sq:
                cleaBottomImageState();
                break;
            case R.id.rl_xx:
                cleaBottomImageState();
                break;
            case R.id.rl_my:
                cleaBottomImageState();
                break;
                default:
                    break;

        }
    }
    /*
    * 设置底部控件点击的监听事件*/
    private void setListener() {
    for(int i=0;i<fl_body.getChildCount();i++){
        fl_body.getChildAt(i).setOnClickListener(this);
    }
    }

    /*
    * 显示相应的界面*/
    private void selectDisplayview(int i) {
        removeAllView();
        createView(i);
    }
    /*
    * 选择视图*/
    private void createView(int viewIndex) {
        switch (viewIndex){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }

    }


    /*
    * 移除不需要的视图*/
    private void removeAllView() {
        for(int i=0;i<fl_body.getChildCount();i++){
            fl_body.getChildAt(i).setVisibility(View.GONE);
        }
    }

    private void cleaBottomImageState() {
        tv_main.setTextColor(Color.parseColor("#666666"));
        tv_my.setTextColor(Color.parseColor("#666666"));
        tv_sq.setTextColor(Color.parseColor("#666666"));
        tv_xx.setTextColor(Color.parseColor("#666666"));
        iv_main.setImageResource(R.drawable.sy_icon_1);
        iv_my.setImageResource(R.drawable.my_icon_1);
        iv_sq.setImageResource(R.drawable.sq_icon_1);
        iv_xx.setImageResource(R.drawable.xx_icon_1);
        for(int i=0;i<fl_body.getChildCount();i++){
            fl_body.getChildAt(i).setSelected(false);
        }
    }
}
