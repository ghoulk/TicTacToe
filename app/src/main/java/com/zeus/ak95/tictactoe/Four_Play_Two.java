package com.zeus.ak95.tictactoe;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Zeu$ on 9/11/2015.
 */
public class Four_Play_Two extends AppCompatActivity implements View.OnClickListener,TextToSpeech.OnInitListener,Animation.AnimationListener {
    Button bt11,bt12,bt13,bt21,bt22,bt23,bt31,bt32,bt33;
    Bundle b;
    TextView pl1;
    int op=9; int winne = 0;
    int[] x ={0,0,0,0,0,0,0,0,0};
    Animation fade0,fade1,fade2,fade3,fade4,fade5,fade6,fade7,fade8;
    Animation blink1,blink2,blink3;
    MediaPlayer mp;
    TextToSpeech tts;
    String playr="abc",oppnt="xyz",strt="x";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_four__play);

            mp = MediaPlayer.create(getApplicationContext(), R.raw.click);

            tts = new TextToSpeech(this, this);

            pl1 = (TextView) findViewById(R.id.fptv1);

            fade0 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade1 =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade2=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade3 =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade4=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade5 =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade6=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade7 =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade8=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
          //  blink1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.roteff);
           // blink2=blink1;
          //  blink3=blink1;


            fade0.setAnimationListener(this);
            fade1.setAnimationListener(this);
            fade2.setAnimationListener(this);
            fade3.setAnimationListener(this);
            fade4.setAnimationListener(this);
            fade5.setAnimationListener(this);
            fade6.setAnimationListener(this);
            fade7.setAnimationListener(this);
            fade8.setAnimationListener(this);
          //  blink1.setAnimationListener(this);
        //    blink2.setAnimationListener(this);
         //   blink3.setAnimationListener(this);


            b = getIntent().getExtras();


            this.playr = b.getString("player2").toString();
            this.oppnt = b.getString("opponent2").toString();
            this.strt = b.getString("strt2").toString();

    bt11 = (Button) findViewById(R.id.fpbtn11);
    bt12 = (Button) findViewById(R.id.fpbtn12);
    bt13 = (Button) findViewById(R.id.fpbtn13);
    bt21 = (Button) findViewById(R.id.fpbtn21);
    bt22 = (Button) findViewById(R.id.fpbtn22);
    bt23 = (Button) findViewById(R.id.fpbtn23);
    bt31 = (Button) findViewById(R.id.fpbtn31);
    bt32 = (Button) findViewById(R.id.fpbtn32);
    bt33 = (Button) findViewById(R.id.fpbtn33);

    bt11.setOnClickListener(this);
    bt12.setOnClickListener(this);
    bt13.setOnClickListener(this);
    bt21.setOnClickListener(this);
    bt22.setOnClickListener(this);
    bt23.setOnClickListener(this);
    bt31.setOnClickListener(this);
    bt32.setOnClickListener(this);
    bt33.setOnClickListener(this);

    startmethod();

        }catch (Exception e){
    Toast.makeText(Four_Play_Two.this, "Error FourTwoStart "+e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_four__play, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.fpback) {
            Intent i = new Intent();
            i.setClass(Four_Play_Two.this,Third_Two_Player.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.fpfeedback) {
            Intent i = new Intent();
            i.setClass(Four_Play_Two.this,Fifth_About_Us.class);
            startActivity(i);
            return true;
        }
        if(id == R.id.fphelp){
            Intent i = new Intent();
            i.setClass(Four_Play_Two.this,Sixth_Help.class);
            startActivity(i);
            return  true;
        }
        if(id == R.id.fpabout){
            Intent i = new Intent();
            i.setClass(Four_Play_Two.this,Seventh_About.class);
            startActivity(i);
            return  true;
        }
        if(id == R.id.fpexit){
            super.onStop();
            finish();
            return  true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fpbtn11:
                mp.start();
                if(op%2==1) {
                    bt11.setBackgroundResource(R.drawable.xn1);
                    bt11.setAnimation(fade0);
                    x[0]=1;
                    pl1.setText(""+this.oppnt+" (O) Turn");
                }
                else {
                    bt11.setBackgroundResource(R.drawable.on1);
                    bt11.setAnimation(fade0);
                    x[0]=2;
                    pl1.setText(""+this.playr+" (X) Turn");
                }
                bt11.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn12:
                mp.start();
                if(op%2==1) {
                    bt12.setBackgroundResource(R.drawable.xn1);
                    bt12.setAnimation(fade1);
                    x[1]=1;
                    pl1.setText(""+this.oppnt+" (O) Turn");
                }
                else {
                    bt12.setBackgroundResource(R.drawable.on1);
                    bt12.setAnimation(fade1);
                    x[1]=2;
                    pl1.setText(""+this.playr+" (X) Turn");
                }
                bt12.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn13:
                mp.start();
                if(op%2==1) {
                    bt13.setBackgroundResource(R.drawable.xn1);
                    bt13.setAnimation(fade2);
                    x[2]=1;
                    pl1.setText(""+this.oppnt+" (O) Turn");
                }
                else {
                    bt13.setBackgroundResource(R.drawable.on1);
                    bt13.setAnimation(fade2);
                    x[2]=2;
                    pl1.setText(""+this.playr+" (X) Turn");
                }
                bt13.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn21:
                mp.start();
                if(op%2==1) {
                    bt21.setBackgroundResource(R.drawable.xn1);
                    bt21.setAnimation(fade3);
                    x[3]=1;
                    pl1.setText(""+this.oppnt+" (O) Turn");
                }
                else {
                    bt21.setBackgroundResource(R.drawable.on1);
                    bt21.setAnimation(fade3);
                    x[3]=2;
                    pl1.setText(""+this.playr+" (X) Turn");
                }
                bt21.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn22:
                mp.start();
                if(op%2==1) {
                    bt22.setBackgroundResource(R.drawable.xn1);
                    bt22.setAnimation(fade4);
                    x[4]=1;
                    pl1.setText(""+this.oppnt+" (O) Turn");
                }
                else {
                    bt22.setBackgroundResource(R.drawable.on1);
                    bt22.setAnimation(fade4);
                    x[4]=2;
                    pl1.setText(""+this.playr+" (X) Turn");
                }
                bt22.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn23:
                mp.start();
                if(op%2==1) {
                    bt23.setBackgroundResource(R.drawable.xn1);
                    bt23.setAnimation(fade5);
                    x[5]=1;
                    pl1.setText(""+this.oppnt+" (O) Turn");
                }
                else {
                    bt23.setBackgroundResource(R.drawable.on1);
                    bt23.setAnimation(fade5);
                    x[5]=2;
                    pl1.setText(""+this.playr+" (X) Turn");
                }
                bt23.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn31:
                mp.start();
                if(op%2==1) {
                    bt31.setBackgroundResource(R.drawable.xn1);
                    bt31.setAnimation(fade6);
                    x[6]=1;
                    pl1.setText(""+this.oppnt+" (O) Turn");
                }
                else {
                    bt31.setBackgroundResource(R.drawable.on1);
                    bt31.setAnimation(fade6);
                    x[6]=2;
                    pl1.setText(""+this.playr+" (X) Turn");
                }
                bt31.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn32:
                mp.start();
                if(op%2==1) {
                    bt32.setBackgroundResource(R.drawable.xn1);
                    bt32.setAnimation(fade7);
                    x[7]=1;
                    pl1.setText(""+this.oppnt+" (O) Turn");
                }
                else {
                    bt32.setBackgroundResource(R.drawable.on1);
                    bt32.setAnimation(fade7);
                    x[7]=2;
                    pl1.setText(""+this.playr+" (X) Turn");
                }
                bt32.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn33:
                mp.start();
                if(op%2==1) {
                    bt33.setBackgroundResource(R.drawable.xn1);
                    bt33.setAnimation(fade8);
                    x[8]=1;
                    pl1.setText(""+this.oppnt+" (O) Turn");
                }
                else {
                    bt33.setBackgroundResource(R.drawable.on1);
                    bt33.setAnimation(fade8);
                    x[8]=2;
                    pl1.setText(""+this.playr+" (X) Turn");
                }
                bt33.setEnabled(false);
                check();
                vic();
                op--;

                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void check(){

        if(x[0]==x[1]&&x[0]==x[2]&&x[1]!=0){
            if(x[0]==1||x[1]==1||x[2]==1){
                this.winne =1;
            }
            else if(x[0]==2||x[1]==2||x[2]==2){
                this.winne =2;
            }
            //   bt11.setAnimation(blink1);
            bt11.setElevation(12);
            //   bt12.setAnimation(blink2);
            bt12.setElevation(12);
            //   bt13.setAnimation(blink3);
            bt13.setElevation(12);
            trans3();trans4();trans5();trans6();trans7();trans8();
        }
        else if(x[3]==x[4]&&x[3]==x[5]&&x[5]!=0){
            if(x[3]==1||x[4]==1||x[5]==1){
                this.winne =1;
            }
            else if(x[3]==2||x[4]==2||x[5]==2){
                this.winne =2;
            }
            //   bt21.setAnimation(blink1);
            bt21.setElevation(12);
            //      bt22.setAnimation(blink2);
            bt22.setElevation(12);
            //    bt23.setAnimation(blink3);
            bt23.setElevation(12);
            trans0();trans1();trans2();trans6();trans7();trans8();
        }
        else if(x[6]==x[7]&&x[6]==x[8]&&x[7]!=0){
            if(x[6]==1||x[7]==1||x[8]==1){
                this.winne =1;
            }
            else if(x[6]==2||x[7]==2||x[8]==2){
                this.winne =2;
            }
            //     bt31.setAnimation(blink1);
            bt31.setElevation(12);
            //     bt32.setAnimation(blink2);
            bt32.setElevation(12);
            //      bt33.setAnimation(blink3);
            bt33.setElevation(12);
            trans3();trans4();trans5();trans0();trans1();trans2();
        }
        else if(x[0]==x[3]&&x[0]==x[6]&&x[0]!=0){
            if(x[0]==1||x[3]==1||x[6]==1){
                this.winne =1;
            }
            else if(x[0]==2||x[3]==2||x[6]==2){
                this.winne =2;
            }
            //      bt11.setAnimation(blink1);
            bt11.setElevation(12);
            //     bt21.setAnimation(blink2);
            bt21.setElevation(12);
            //      bt31.setAnimation(blink3);
            bt31.setElevation(12);
            trans1();trans4();trans5();trans2();trans7();trans8();
        }
        else if(x[1]==x[4]&&x[1]==x[7]&&x[1]!=0){
            if(x[1]==1||x[4]==1||x[7]==1){
                this.winne =1;
            }
            else if(x[1]==2||x[4]==2||x[7]==2){
                this.winne =2;
            }
            //     bt12.setAnimation(blink1);
            bt12.setElevation(12);
            //    bt22.setAnimation(blink2);
            bt22.setElevation(12);
            //    bt32.setAnimation(blink3);
            bt32.setElevation(12);
            trans3();trans0();trans5();trans6();trans2();trans8();
        }
        else if(x[2]==x[5]&&x[2]==x[8]&&x[2]!=0){
            if(x[2]==1||x[5]==1||x[8]==1){
                this.winne =1;
            }
            else if(x[2]==2||x[5]==2||x[8]==2){
                this.winne =2;
            }
            //   bt13.setAnimation(blink1);
            bt13.setElevation(12);
            //   bt23.setAnimation(blink2);
            bt23.setElevation(12);
            //    bt33.setAnimation(blink3);
            bt33.setElevation(12);
            trans3();trans4();trans0();trans6();trans7();trans1();
        }
        else if(x[0]==x[4]&&x[0]==x[8]&&x[0]!=0){
            if(x[0]==1||x[4]==1||x[8]==1){
                this.winne =1;
            }
            else if(x[0]==2||x[4]==2||x[8]==2){
                this.winne =2;
            }
            //      bt11.setAnimation(blink1);
            bt11.setElevation(12);
            //     bt22.setAnimation(blink2);
            bt22.setElevation(12);
            //    bt33.setAnimation(blink3);
            bt33.setElevation(12);
            trans3();trans1();trans5();trans6();trans7();trans2();
        }
        else if(x[2]==x[4]&&x[2]==x[6]&&x[2]!=0){
            if(x[2]==1||x[4]==1||x[6]==1){
                this.winne =1;
            }
            else if(x[2]==2||x[4]==2||x[6]==2){
                this.winne =2;
            }
            //     bt13.setAnimation(blink1);
            bt13.setElevation(12);
            //     bt22.setAnimation(blink2);
            bt22.setElevation(12);
            //     bt31.setAnimation(blink3);
            bt31.setElevation(12);
            trans3();trans0();trans5();trans1();trans7();trans8();
        }
        else if(x[0]!=0&&x[1]!=0&&x[2]!=0&&x[3]!=0&&x[4]!=0&&x[5]!=0&&x[6]!=0&&x[7]!=0&&x[8]!=0){
            this.winne =3;
        }
    }

    public void vic(){
        final String player1 = b.getString("player2").toString();
        final String player2 = b.getString("opponent2").toString();
        final String startfp = b.getString("strt2").toString();
        try{ if(this.winne==1){
            reset();
            pl1.setText("Winner is "+player1);
            String wine = this.playr+" (X) Wins";
            tts.speak(this.playr+" Wins",TextToSpeech.QUEUE_FLUSH,null);
            Toast.makeText(Four_Play_Two.this, wine, Toast.LENGTH_SHORT).show();
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    Intent wit = new Intent();
                    wit.setClass(Four_Play_Two.this, Four_Play_Two.class);
                    wit.putExtra("player2", player1);
                    wit.putExtra("opponent2", player2);
                    wit.putExtra("strt2", startfp);
                    startActivity(wit);
                    onRestart();
                }
            };
            Timer t1=new Timer();
            t1.schedule(tt, 2000);
        }
        else if(this.winne==2){
            reset();
            pl1.setText("Winner is "+player2);
            String wine = this.oppnt+" (O) Wins";
            tts.speak(this.oppnt+" Wins",TextToSpeech.QUEUE_FLUSH,null);
            Toast.makeText(Four_Play_Two.this, wine, Toast.LENGTH_SHORT).show();
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    Intent wit = new Intent();
                    wit.setClass(Four_Play_Two.this, Four_Play_Two.class);
                    wit.putExtra("player2", player1);
                    wit.putExtra("opponent2",player2);
                    wit.putExtra("strt2", startfp);
                    startActivity(wit);
                    onRestart();
                }
            };
            Timer t1=new Timer();
            t1.schedule(tt, 2000);        }
        else if(this.winne==3){
            reset();
            pl1.setText("Match Tie");
            String wine = "Match Tie";
            tts.speak(wine, TextToSpeech.QUEUE_FLUSH, null);
            Toast.makeText(Four_Play_Two.this, wine, Toast.LENGTH_SHORT).show();
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    String draw = "Draw";
                    Intent wit = new Intent();
                    wit.setClass(Four_Play_Two.this, Four_Play_Two.class);
                    wit.putExtra("player2", player1);
                    wit.putExtra("opponent2", player2);
                    wit.putExtra("strt2", startfp);
                    startActivity(wit);
                    onRestart();
                }
            };
            Timer t1=new Timer();
            t1.schedule(tt, 3000);
        }
        }catch(Exception e){
            Toast.makeText(Four_Play_Two.this, "Error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void winset(){

    }

    public void reset(){
        bt11.setEnabled(false);
        bt12.setEnabled(false);
        bt13.setEnabled(false);
        bt21.setEnabled(false);
        bt22.setEnabled(false);
        bt23.setEnabled(false);
        bt31.setEnabled(false);
        bt32.setEnabled(false);
        bt33.setEnabled(false);
    }

    @Override
    protected void onStop(){
        if(tts!=null){
            tts.stop();
            tts.shutdown();
        }
        super.onStop();
        finish();
    }

    @Override
    public void onInit(int i) {
        if(i==TextToSpeech.SUCCESS){
            int res = tts.setLanguage(Locale.US);
            if(res==TextToSpeech.LANG_MISSING_DATA||res==TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS", "This Language is not Supported.");
            }
        }else{
            Log.e("TTS", "Initialisation Failed!");
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans0()
    {
        bt11.setElevation(0);    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans1()
    {
        bt12.setElevation(0);    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans2() {
        bt13.setElevation(0);    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans3()
    {
        bt21.setElevation(0);    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans4()
    {
        bt22.setElevation(0);    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans5()
    {
        bt23.setElevation(0);    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans6()
    {
        bt31.setElevation(0);    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans7()
    {
        bt32.setElevation(0);    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans8()
    {
        bt33.setElevation(0);    }


    public void startmethod(){
        if(this.strt.length()==2){
            pl1.setText(this.oppnt+" (O) turn");
            this.op=10;

        }
        else if(this.strt.length()==1){
            pl1.setText(this.playr+" (X) turn");
        this.op=9;
        }
        else{
            Toast.makeText(Four_Play_Two.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
