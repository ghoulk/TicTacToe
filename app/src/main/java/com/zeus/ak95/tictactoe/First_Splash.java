package com.zeus.ak95.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class First_Splash extends AppCompatActivity implements Animation.AnimationListener{
    Animation a2;
    MediaPlayer mp1;
    ImageView anim1,anim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__splash);
        mp1 = MediaPlayer.create(getApplicationContext(),R.raw.splash_sound);
        mp1.start();
        a2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splfst);
        a2.setAnimationListener(this);
        anim1 = (ImageView) findViewById(R.id.fsiv1);
        anim2 = (ImageView) findViewById(R.id.fsiv2);
        anim1.startAnimation(a2);

    }

    @Override
    protected void onStop(){
        super.onStop();
        mp1.stop();
        finish();
    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
if(animation==a2){
    Intent i = new Intent(First_Splash.this,Second_Main.class);
    startActivity(i);
}
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
