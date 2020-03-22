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
        // for full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        // this 3 line(20,21,22) is for full screen


        setContentView(R.layout.activity_spalsh);

        // one way to do Spalsh screen activity
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SpalshActivity.this,MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },1000 * TIME_DELAY);
        // end of one way


        SpalshScreenLauncher spalshScreenLauncher = new SpalshScreenLauncher();
        spalshScreenLauncher.start();





    }
    // and the second way to do this, extending Thread class and call the start() method from the object
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
