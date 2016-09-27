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

public class Third_One_Player extends AppCompatActivity implements View.OnClickListener {
    Bundle b;
    EditText player,opponent;
    Button x,o;
    String mode;
    Intent in1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third__player);

        player = (EditText) findViewById(R.id.thet1);
        opponent = (EditText) findViewById(R.id.thet2);

        b=getIntent().getExtras();
        mode = b.getString("mode").toString();

        x = (Button) findViewById(R.id.thbtn3);
        o = (Button) findViewById(R.id.thbtn4);

        x.setOnClickListener(this);
        o.setOnClickListener(this);

            }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View view){
        String playr = player.getText().toString();
        String oppnt = opponent.getText().toString();
        mode = b.getString("mode").toString();
        switch(view.getId()){

            case R.id.thbtn3:
                String startx ="x";
               x.setElevation(10);
                if(playr.length()==0||oppnt.length()==0){
                    Toast.makeText(Third_One_Player.this, "Enter Players", Toast.LENGTH_SHORT).show();
                }
                else{
                    in1 =new Intent();
                    in1.setClass(Third_One_Player.this, Four_Play.class);
                    in1.putExtra("player", playr);
                    in1.putExtra("opponent", oppnt);
                    in1.putExtra("strt",startx);
                    in1.putExtra("mode",mode);
                    startActivity(in1);
                }
                break;

            case R.id.thbtn4:
                String starto ="os";
                o.setElevation(10);
                if(playr.length()==0||oppnt.length()==0){
                    Toast.makeText(Third_One_Player.this, "Enter Players", Toast.LENGTH_SHORT).show();
                }
                else{
                    in1 =new Intent();
                    in1.setClass(Third_One_Player.this, Four_Play.class);
                    in1.putExtra("player", playr);
                    in1.putExtra("opponent", oppnt);
                    in1.putExtra("strt",starto);
                    in1.putExtra("mode",mode);
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
            i.setClass(Third_One_Player.this,Second_Extend.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.thfeedback) {
            Intent i = new Intent();
            i.setClass(Third_One_Player.this,Fifth_About_Us.class);
            startActivity(i);
            return true;
        }
        if(id == R.id.thhelp){
            Intent i = new Intent();
            i.setClass(Third_One_Player.this,Sixth_Help.class);
            startActivity(i);
            return  true;
        }
        if(id == R.id.thabout){
            Intent i = new Intent();
            i.setClass(Third_One_Player.this,Seventh_About.class);
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