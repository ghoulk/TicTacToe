package com.zeus.ak95.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Sixth_Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth__help);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sixth__help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sihback) {
            Intent i = new Intent();
            i.setClass(Sixth_Help.this,Second_Main.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.sihfeedback) {
            Intent i = new Intent();
            i.setClass(Sixth_Help.this,Fifth_About_Us.class);
            startActivity(i);
            return true;
        }
        if(id == R.id.sihabout){
            Intent i = new Intent();
            i.setClass(Sixth_Help.this,Seventh_About.class);
            startActivity(i);
            return  true;
        }
        if(id == R.id.sihexit){
            super.onStop();
            finish();
            finishActivity(R.layout.activity_second__main);
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
