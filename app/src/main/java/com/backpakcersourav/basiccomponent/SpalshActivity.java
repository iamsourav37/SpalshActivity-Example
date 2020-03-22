package com.backpakcersourav.basiccomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SpalshActivity extends AppCompatActivity {

    private static final int TIME_DELAY = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_spalsh);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SpalshActivity.this,MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },1000 * TIME_DELAY);

        SpalshScreenLauncher spalshScreenLauncher = new SpalshScreenLauncher();
        spalshScreenLauncher.start();





    }
    private class SpalshScreenLauncher extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                sleep(1000*TIME_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(SpalshActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
