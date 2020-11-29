package com.example.qt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
        setListener();
        setInitStatus();



    }
    /*
    * 设置view初始化状态*/
    private void setInitStatus() {
        cleaBottomImageState();
        setSelectedStatus(0);
    }
    
    /*
    * 设置底部选中状态*/
    private void setSelectedStatus(int i) {
        switch (i){
            case 0:
                rl_main.setSelected(true);
                iv_main.setImageResource(R.drawable.sy_icon);
                tv_main.setTextColor(Color.parseColor("#5187f5"));
                break;
            case 1:
                rl_sq.setSelected(true);
                iv_sq.setImageResource(R.drawable.sq_icon_1);
                tv_sq.setTextColor(Color.parseColor("#5187f5"));
                break;
            case 2:
                rl_xx.setSelected(true);
                iv_xx.setImageResource(R.drawable.xx_icon_1);
                tv_xx.setTextColor(Color.parseColor("#5187f5"));
                break;
            case 3:
                rl_my.setSelected(true);
                iv_my.setImageResource(R.drawable.my_icon_1);
                tv_my.setTextColor(Color.parseColor("#5187f5"));
                break;
                
                
        }

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
                selectDisplayview(0);
                break;
            case R.id.rl_sq:
                cleaBottomImageState();
                selectDisplayview(1);
                break;
            case R.id.rl_xx:
                cleaBottomImageState();
                selectDisplayview(2);
                break;
            case R.id.rl_my:
                cleaBottomImageState();
                selectDisplayview(3);
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

    protected long exitTime;//记录第一次的点击时间

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BREAK&&event.getAction()==KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime)>2000){
                Toast.makeText(MainActivity.this,"请再按一次退出",Toast.LENGTH_SHORT).show();
                exitTime=System.currentTimeMillis();
            }else{
                MainActivity.this.finish();
                if(readLoginStatus()){
                    clearLoginStatus();

                }
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    /*
    * 清除SharedPreferences中的登陆状态*/
    private void clearLoginStatus() {
        SharedPreferences loginInfo = getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginInfo.edit();//获取编译器
        editor.putBoolean("isLogin",false);//清除登陆状态
        editor.putString("loginUserName","");//清除登陆时的用户名
        editor.commit();//提交修改
    }

    /*
    * 获取SharedPreferences中的登陆状态*/
    private boolean readLoginStatus() {
        SharedPreferences loginInfo = getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        boolean isLogin = loginInfo.getBoolean("isLogin", false);
        return isLogin;
    }

    /*
    * 移除不需要的视图*/
    private void removeAllView() {
        for(int i=0;i<fl_body.getChildCount();i++){
            fl_body.getChildAt(i).setVisibility(View.GONE);
        }
    }

    /*
    *清空底部的选中状态*/
    private void cleaBottomImageState() {
        tv_main.setTextColor(Color.parseColor("#666666"));
        tv_my.setTextColor(Color.parseColor("#666666"));
        tv_sq.setTextColor(Color.parseColor("#666666"));
        tv_xx.setTextColor(Color.parseColor("#666666"));
        iv_main.setImageResource(R.drawable.sy_icon_1);
        iv_my.setImageResource(R.drawable.my_icon);
        iv_sq.setImageResource(R.drawable.sq_icon);
        iv_xx.setImageResource(R.drawable.xx_icon);
        for(int i=0;i<fl_body.getChildCount();i++){
            fl_body.getChildAt(i).setSelected(false);
        }
    }
}
