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

public class Second_Main extends AppCompatActivity implements View.OnClickListener,Animation.AnimationListener,View.OnLongClickListener {
Button onp,twp,abus,ext;
    Animation fade1,fade2,fade3,fade4;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__main);

        this.i=0;

        fade1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.smrot);
        fade2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.smrot);
        fade3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.smrot);
        fade4 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.smrot);

        fade1.setAnimationListener(this);
        fade2.setAnimationListener(this);
        fade3.setAnimationListener(this);
        fade4.setAnimationListener(this);


        onp = (Button) findViewById(R.id.sbtn1);
        twp = (Button) findViewById(R.id.sbtn2);
        abus = (Button) findViewById(R.id.sbtn3);
        ext = (Button) findViewById(R.id.sbtn4);

        onp.setOnClickListener(this);
        twp.setOnClickListener(this);
        abus.setOnClickListener(this);
        ext.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View view){
        switch(view.getId()){
            case R.id.sbtn1:
                this.i=1;
               onp.setElevation(10);
                onp.startAnimation(fade1);
                break;

            case R.id.sbtn2:
                this.i=2;
                twp.setElevation(10);
                twp.startAnimation(fade2);
                break;

            case R.id.sbtn3:
                this.i=3;
                abus.setElevation(10);
                abus.startAnimation(fade3);
                break;

            case R.id.sbtn4:
                ext.setElevation(10);
                super.onStop();
                finish();
                break;

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second__main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.smfeedback) {
            Intent i = new Intent();
            i.setClass(Second_Main.this,Fifth_About_Us.class);
            startActivity(i);
            return true;
        }
        /*
        if(id == R.id.smhelp){
            Intent i = new Intent();
            i.setClass(Second_Main.this,Sixth_Help.class);
            startActivity(i);

            return  true;
        }

        */

        if(id == R.id.smabout){
            Intent i = new Intent();
            i.setClass(Second_Main.this,Seventh_About.class);
            startActivity(i);
            return  true;
        }
        if(id == R.id.smexit){
            super.onStop();
            finish();
            return  true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(this.i==1){
            Intent it1 = new Intent();
            it1.setClass(Second_Main.this, Second_Extend.class);
            startActivity(it1);
        }
        else if(this.i==2){
            Intent it2 = new Intent();
            it2.setClass(Second_Main.this, Third_Two_Player.class);
            startActivity(it2);
        }
        else if(this.i==3){
            Intent it3 = new Intent();
            it3.setClass(Second_Main.this, Sixth_Help.class);
            startActivity(it3);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()){
            case R.id.sbtn1:
                onp.setElevation(12);
                break;
            case R.id.sbtn2:
                twp.setElevation(12);
                break;
            case R.id.sbtn3:
                abus.setElevation(12);
                break;
            case R.id.sbtn4:
                ext.setElevation(12);
                break;
        }
        return false;
    }


}