package com.zeus.ak95.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Fifth_About_Us extends AppCompatActivity implements View.OnClickListener{
    ImageView im;
    EditText et;
    Animation am;
    MediaPlayer mp;
    Intent in1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth__about__us);
        im = (ImageView) findViewById(R.id.ffiv2);
        am = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fdbkanim);
        im.startAnimation(am);
        mp = MediaPlayer.create(getApplicationContext(),R.raw.about);
       mp.start();
        mp.setLooping(true);
        im.setOnClickListener(this);
        et = (EditText) findViewById(R.id.ffet1);
    }
    @Override
    public void onClick(View view) {
        String feedbacktxt = et.getText().toString();
        switch(view.getId()){

            case R.id.ffiv2:
                in1= new Intent(Intent.ACTION_SEND);
                in1.putExtra(Intent.EXTRA_TEXT, feedbacktxt);
                in1.putExtra(Intent.EXTRA_SUBJECT, "FeedBack Mail TicTacToe");
                in1.putExtra(Intent.EXTRA_EMAIL, new String[]{"yoashish1995@gmail.com"});
                in1.setType("message/rfc822");
                startActivity(in1.createChooser(in1, "Choose an Email Client : "));

        }
    }
@Override
    protected void onStop(){
    super.onStop();
    mp.stop();
    finish();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fifth__about__us, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.ffback) {
            Intent i = new Intent();
            i.setClass(Fifth_About_Us.this,Second_Main.class);
            startActivity(i);
            return true;
        }

        if(id == R.id.ffhelp){
            Intent i = new Intent();
            i.setClass(Fifth_About_Us.this,Sixth_Help.class);
            startActivity(i);
            return  true;
        }
        if(id == R.id.ffabout){
            Intent i = new Intent();
            i.setClass(Fifth_About_Us.this,Seventh_About.class);
            startActivity(i);
            return  true;
        }
        if(id == R.id.ffexit){
            super.onStop();
            finish();
            finishActivity(R.layout.activity_second__main);
            return  true;
        }


        return super.onOptionsItemSelected(item);
    }

}
