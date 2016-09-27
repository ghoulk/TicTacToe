package com.zeus.ak95.tictactoe;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Third_Two_Player extends AppCompatActivity implements View.OnClickListener {
    EditText player,opponent;
    Button x,o;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third__player);

    player = (EditText) findViewById(R.id.thet1);
    opponent = (EditText) findViewById(R.id.thet2);

    x = (Button) findViewById(R.id.thbtn3);
    o = (Button) findViewById(R.id.thbtn4);

    x.setOnClickListener(this);
    o.setOnClickListener(this);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View view){
        final String player1tt = player.getText().toString();
        final String player2tt = opponent.getText().toString();
        switch(view.getId()){
            case R.id.thbtn3:
                try {
                    String startx = "x";
                    x.setElevation(10);
                    if (player.getText().length() == 0 || opponent.getText().length() == 0) {
                        Toast.makeText(Third_Two_Player.this, "Enter Players", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent in1 = new Intent();
                        in1.setClass(Third_Two_Player.this, Four_Play_Two.class);
                        in1.putExtra("player2", player1tt);
                        in1.putExtra("opponent2", player2tt);
                        in1.putExtra("strt2",startx);
                        startActivity(in1);
                    }
                }catch (Exception e){
                    Toast.makeText(Third_Two_Player.this, "eRROR Thirdtwo "+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.thbtn4:
                String starto = "os";
                o.setElevation(10);
                if(player.getText().length()==0||opponent.getText().length()==0){
                    Toast.makeText(Third_Two_Player.this, "Enter Players", Toast.LENGTH_SHORT).show();
                }
                else{
                        Intent in1 =new Intent();
                        in1.setClass(Third_Two_Player.this, Four_Play_Two.class);
                    in1.putExtra("player2", player1tt);
                    in1.putExtra("opponent2", player2tt);
                    in1.putExtra("strt2",starto);
                    startActivity(in1);
                    }
                break;

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_third__player, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.thback) {
            Intent i = new Intent();
            i.setClass(Third_Two_Player.this,Second_Main.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.thfeedback) {
            Intent i = new Intent();
            i.setClass(Third_Two_Player.this,Fifth_About_Us.class);
            startActivity(i);
            return true;
        }
        if(id == R.id.thhelp){
            Intent i = new Intent();
            i.setClass(Third_Two_Player.this,Sixth_Help.class);
            startActivity(i);
            return  true;
        }
        if(id == R.id.thabout){
            Intent i = new Intent();
            i.setClass(Third_Two_Player.this,Seventh_About.class);
            startActivity(i);
            return  true;
        }
        if(id == R.id.thexit){
           onStop();
            return  true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop(){
      super.onStop();
        finish();
    }

    }


