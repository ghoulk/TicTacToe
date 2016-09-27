package com.zeus.ak95.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Seventh_About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh__about);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seventh__about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.svaback) {
            Intent i = new Intent();
            i.setClass(Seventh_About.this,Second_Main.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.svafeedback) {
            Intent i = new Intent();
            i.setClass(Seventh_About.this,Fifth_About_Us.class);
            startActivity(i);
            return true;
        }
        if(id == R.id.svahelp){
            Intent i = new Intent();
            i.setClass(Seventh_About.this,Sixth_Help.class);
            startActivity(i);
            return  true;
        }

        if(id == R.id.svaexit){
            super.onStop();
            finish();
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
    }

