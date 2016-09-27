package com.zeus.ak95.tictactoe;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Second_Extend extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {
    Button begn, intr, expt;
    String begin = "beginner";
    String inter = "intermediate";
    String exper = "expert";
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__extend);

        begn = (Button) findViewById(R.id.sebtn1);
        intr = (Button) findViewById(R.id.sebtn2);
        expt = (Button) findViewById(R.id.sebtn3);

        begn.setOnClickListener(this);
        intr.setOnClickListener(this);
        expt.setOnClickListener(this);


    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sebtn1:
                this.i = 1;
                begn.setElevation(10);
                start();
                break;

            case R.id.sebtn2:
                this.i = 2;
                intr.setElevation(10);
                start();
                break;

            case R.id.sebtn3:
                this.i = 3;
                expt.setElevation(10);
                start();
                break;

        }
    }

    public void start() {
        if (this.i == 1) {
            TimerTask tt1 = new TimerTask() {
                @Override
                public void run() {
                    Intent in21 = new Intent();
                    in21.setClass(Second_Extend.this, Third_One_Player.class);
                    in21.putExtra("mode", begin);
                    startActivity(in21);
                }
            };
            Timer t1 = new Timer();
            t1.schedule(tt1, 500);
        } else if (this.i == 2) {
            TimerTask tt2 = new TimerTask() {
                @Override
                public void run() {
                    Intent in22 = new Intent();
                    in22.setClass(Second_Extend.this, Third_One_Player.class);
                    in22.putExtra("mode", inter);
                    startActivity(in22);
                }
            };
            Timer t2 = new Timer();
            t2.schedule(tt2, 500);
        } else if (this.i == 3) {
            TimerTask tt3 = new TimerTask() {
                @Override
                public void run() {
                    Intent in23 = new Intent();
                    in23.setClass(Second_Extend.this, Third_One_Player.class);
                    in23.putExtra("mode", exper);
                    startActivity(in23);
                }
            };
            Timer t3 = new Timer();
            t3.schedule(tt3, 500);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second__extend, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.seback) {
            Intent i = new Intent();
            i.setClass(Second_Extend.this, Second_Main.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.sefeedback) {
            Intent i = new Intent();
            i.setClass(Second_Extend.this, Fifth_About_Us.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.sehelp) {
            Intent i = new Intent();
            i.setClass(Second_Extend.this, Sixth_Help.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.seabout) {
            Intent i = new Intent();
            i.setClass(Second_Extend.this, Seventh_About.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.seexit) {
            onStop();
        }


        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.sebtn1:
                begn.setElevation(12);
                break;
            case R.id.sebtn2:
                intr.setElevation(12);
                break;
            case R.id.sebtn3:
                expt.setElevation(12);
                break;
        }
        return false;
    }
}