package com.exampletigon.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
        //  WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_start_page);
        Thread thread = new Thread(){
               public void run()
               {
                   try {
                       sleep(100);
                   }
                    catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   finally {
                       Intent intent = new Intent(StartPage.this , StartRules.class);
                       startActivity(intent);
                   }
               }
        };thread.start();
    }

}