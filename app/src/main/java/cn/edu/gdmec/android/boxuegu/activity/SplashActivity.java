package cn.edu.gdmec.android.boxuegu.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import java.util.Timer;
import java.util.TimerTask;

import cn.edu.gdmec.android.boxuegu.R;


/**
 * Created by apple on 18/3/13.
 */

public class SplashActivity extends AppCompatActivity {

    private TextView tv_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //设置界面为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }
        //获取版本号
    private void init(){

        tv_version = findViewById(R.id.tv_version);
        try {
            //获取程序包信息
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
            tv_version.setText("ver:"+info.versionName);
        } catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
            tv_version.setText("ver");
        }
        //延迟3秒进入主界面
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();

            }
        };
        timer.schedule(task,3000);//设置这个task在延迟三秒之后自动执行

    }
}
