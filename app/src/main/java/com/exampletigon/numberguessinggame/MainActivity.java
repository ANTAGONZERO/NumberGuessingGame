package com.exampletigon.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
        //  WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        randomNum();
    }

    private int lives = 6;
    private int x;
    private final String more = "Still Greater";
    private final String less = "Still Lesser";
    private final String equal = "! You Guessed Perfectly !";
    private final String space = "__________?";
    private final String live = "Out Of Lives";

    public void randomNum() {
        TextView hint = (TextView) findViewById(R.id.hint);
        Random rand = new Random();
        int maxBound = 20;
        x = rand.nextInt(maxBound) + 1;
        hint.setText(space);
    }

    public void check(View view) {
        TextView Lives = (TextView) findViewById(R.id.lives);
        TextView hint = (TextView) findViewById(R.id.hint);
        TextView guess_num = (TextView) findViewById(R.id.guess);
        int n = Integer.parseInt(guess_num.getText().toString());
        if (n != x) {
            lives--;
            Lives.setText("Lives = " + lives);
        }
        if (lives == 0) {
            hint.setText(live);
            reset(view);
        } else if (n > x)
            hint.setText(more);
        else if (n < x)
            hint.setText(less);
        else if (n == x)
            hint.setText(equal);
    }

    public void reset(View view) {
        TextView Lives = (TextView) findViewById(R.id.lives);
        TextView hint = (TextView) findViewById(R.id.hint);
        TextView guess_num = (TextView) findViewById(R.id.guess);
        Random rand = new Random();
        int maxBound = 50;
        lives = 6;
        Lives.setText("Lives = " + lives);
        x = rand.nextInt(maxBound) + 1;
        guess_num.setText(String.valueOf(0));
        hint.setText(space);

    }

    public void increase_num(View view) {
        TextView hint = (TextView) findViewById(R.id.hint);
        TextView guess_num = (TextView) findViewById(R.id.guess);
        int n = Integer.parseInt(guess_num.getText().toString());
        n++;
        guess_num.setText(String.valueOf(n));

    }

    public void decrease_num(View view) {
        TextView hint = (TextView) findViewById(R.id.hint);
        TextView guess_num = (TextView) findViewById(R.id.guess);
        int n = Integer.parseInt(guess_num.getText().toString());
        n--;
        guess_num.setText(String.valueOf(n));
    }

    public void rulesPage(View view) {
        Intent intent = new Intent(this, Rules.class);
        startActivity(intent);
    }
    public void CLOSE(View view)
    {
        finishAffinity();
    }
}