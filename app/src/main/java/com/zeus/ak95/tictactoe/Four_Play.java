package com.zeus.ak95.tictactoe;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Four_Play extends AppCompatActivity implements View.OnClickListener,TextToSpeech.OnInitListener,Animation.AnimationListener {
    Bundle b;
    Button bt11, bt12, bt13, bt21, bt22, bt23, bt31, bt32, bt33;
    TextView pl1;
    TextToSpeech tts;
    MediaPlayer mp;
    Animation fade0, fade1, fade2, fade3, fade4, fade5, fade6, fade7, fade8;
    Animation fadeh0, fadeh1, fadeh2, fadeh3, fadeh4, fadeh5, fadeh6, fadeh7, fadeh8;
    Animation blink1, blink2, blink3;
    int op = 9;
    int winne = 0, flag, flagwin = 0;
    int[] x = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] c = {0, 0, 0, 0};
    int[] o = {0, 0, 0, 0};

    String playr = "abc", oppnt = "xyz", strt = "x", mod = "beginner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four__play);

        try {
            b = getIntent().getExtras();
            tts = new TextToSpeech(this, this);

            mp = MediaPlayer.create(getApplicationContext(), R.raw.click);

            this.playr = b.getString("player").toString();
            this.oppnt = b.getString("opponent").toString();
            this.strt = b.getString("strt").toString();
            this.mod = b.getString("mode").toString();

            pl1 = (TextView) findViewById(R.id.fptv1);

            fade0 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade7 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fade8 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fadeh0 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fadeh1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fadeh2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fadeh3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fadeh4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fadeh5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fadeh6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fadeh7 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            fadeh8 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roteff);
            //  blink1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
            //   blink2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
            //   blink3=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);

            fade0.setAnimationListener(this);
            fade1.setAnimationListener(this);
            fade2.setAnimationListener(this);
            fade3.setAnimationListener(this);
            fade4.setAnimationListener(this);
            fade5.setAnimationListener(this);
            fade6.setAnimationListener(this);
            fade7.setAnimationListener(this);
            fade8.setAnimationListener(this);

            fadeh0.setAnimationListener(this);
            fadeh1.setAnimationListener(this);
            fadeh2.setAnimationListener(this);
            fadeh3.setAnimationListener(this);
            fadeh4.setAnimationListener(this);
            fadeh5.setAnimationListener(this);
            fadeh6.setAnimationListener(this);
            fadeh7.setAnimationListener(this);
            fadeh8.setAnimationListener(this);

            //     blink1.setAnimationListener(this);
            //    blink2.setAnimationListener(this);
            //    blink3.setAnimationListener(this);

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
        } catch (Exception e) {
            Toast.makeText(Four_Play.this, "Erorrstart " + e.getMessage(), Toast.LENGTH_SHORT).show();
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
            i.setClass(Four_Play.this, Third_One_Player.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.fpfeedback) {
            Intent i = new Intent();
            i.setClass(Four_Play.this, Fifth_About_Us.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.fphelp) {
            Intent i = new Intent();
            i.setClass(Four_Play.this, Sixth_Help.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.fpabout) {
            Intent i = new Intent();
            i.setClass(Four_Play.this, Seventh_About.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.fpexit) {
            super.onStop();
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fpbtn11:
                mp.start();
                if (op % 2 == 1) {
                    bt11.setBackgroundResource(R.drawable.xn1);
                    bt11.setAnimation(fadeh0);
                    x[0] = 1;
                    c[0] = 1;
                }
                bt11.setEnabled(false);
                check();
                vic();
                op--;

                break;

            case R.id.fpbtn12:
                mp.start();
                if (op % 2 == 1) {
                    bt12.setBackgroundResource(R.drawable.xn1);
                    bt12.setAnimation(fadeh1);
                    x[1] = 1;
                    o[0] = 1;
                }

                bt12.setEnabled(false);
                check();
                vic();
                op--;

                break;

            case R.id.fpbtn13:
                mp.start();
                if (op % 2 == 1) {
                    bt13.setBackgroundResource(R.drawable.xn1);
                    bt13.setAnimation(fadeh2);
                    x[2] = 1;
                    c[1] = 1;
                }

                bt13.setEnabled(false);
                check();
                vic();
                op--;

                break;

            case R.id.fpbtn21:
                mp.start();
                if (op % 2 == 1) {
                    bt21.setBackgroundResource(R.drawable.xn1);
                    bt21.setAnimation(fadeh3);
                    x[3] = 1;
                    o[1] = 1;
                }

                bt21.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn22:
                mp.start();
                if (op % 2 == 1) {
                    bt22.setBackgroundResource(R.drawable.xn1);
                    bt22.setAnimation(fadeh4);
                    x[4] = 1;
                }

                bt22.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn23:
                mp.start();
                if (op % 2 == 1) {
                    bt23.setBackgroundResource(R.drawable.xn1);
                    bt23.setAnimation(fadeh5);
                    bt23.setEnabled(false);
                    x[5] = 1;
                    o[2] = 1;
                }

                bt23.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn31:
                mp.start();
                if (op % 2 == 1) {
                    bt31.setBackgroundResource(R.drawable.xn1);
                    bt31.setAnimation(fadeh6);
                    bt31.setEnabled(false);
                    x[6] = 1;
                    c[2] = 1;
                }

                bt31.setEnabled(false);
                check();
                vic();
                op--;
                break;

            case R.id.fpbtn32:
                mp.start();
                if (op % 2 == 1) {
                    bt32.setBackgroundResource(R.drawable.xn1);
                    bt32.setAnimation(fadeh7);
                    bt32.setEnabled(false);
                    x[7] = 1;
                    o[3] = 1;
                }
                bt32.setEnabled(false);
                check();

                vic();
                op--;
                break;

            case R.id.fpbtn33:
                mp.start();
                if (op % 2 == 1) {
                    bt33.setBackgroundResource(R.drawable.xn1);
                    bt33.setAnimation(fadeh8);
                    bt33.setEnabled(false);
                    x[8] = 1;
                    c[3] = 1;
                }

                bt33.setEnabled(false);
                check();
                vic();
                op--;
                break;

        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void check() {

        if (x[0] == x[1] && x[0] == x[2] && x[1] != 0) {
            if (x[0] == 1 || x[1] == 1 || x[2] == 1) {
                this.winne = 1;
            } else if (x[0] == 2 || x[1] == 2 || x[2] == 2) {
                this.winne = 2;
            }
            //   bt11.setAnimation(blink1);
            bt11.setElevation(12);
            //   bt12.setAnimation(blink2);
            bt12.setElevation(12);
            //   bt13.setAnimation(blink3);
            bt13.setElevation(12);
            trans3();
            trans4();
            trans5();
            trans6();
            trans7();
            trans8();
        } else if (x[3] == x[4] && x[3] == x[5] && x[5] != 0) {
            if (x[3] == 1 || x[4] == 1 || x[5] == 1) {
                this.winne = 1;
            } else if (x[3] == 2 || x[4] == 2 || x[5] == 2) {
                this.winne = 2;
            }
            //   bt21.setAnimation(blink1);
            bt21.setElevation(12);
            //      bt22.setAnimation(blink2);
            bt22.setElevation(12);
            //    bt23.setAnimation(blink3);
            bt23.setElevation(12);
            trans0();
            trans1();
            trans2();
            trans6();
            trans7();
            trans8();
        } else if (x[6] == x[7] && x[6] == x[8] && x[7] != 0) {
            if (x[6] == 1 || x[7] == 1 || x[8] == 1) {
                this.winne = 1;
            } else if (x[6] == 2 || x[7] == 2 || x[8] == 2) {
                this.winne = 2;
            }
            //     bt31.setAnimation(blink1);
            bt31.setElevation(12);
            //     bt32.setAnimation(blink2);
            bt32.setElevation(12);
            //      bt33.setAnimation(blink3);
            bt33.setElevation(12);
            trans3();
            trans4();
            trans5();
            trans0();
            trans1();
            trans2();
        } else if (x[0] == x[3] && x[0] == x[6] && x[0] != 0) {
            if (x[0] == 1 || x[3] == 1 || x[6] == 1) {
                this.winne = 1;
            } else if (x[0] == 2 || x[3] == 2 || x[6] == 2) {
                this.winne = 2;
            }
            //      bt11.setAnimation(blink1);
            bt11.setElevation(12);
            //     bt21.setAnimation(blink2);
            bt21.setElevation(12);
            //      bt31.setAnimation(blink3);
            bt31.setElevation(12);
            trans1();
            trans4();
            trans5();
            trans2();
            trans7();
            trans8();
        } else if (x[1] == x[4] && x[1] == x[7] && x[1] != 0) {
            if (x[1] == 1 || x[4] == 1 || x[7] == 1) {
                this.winne = 1;
            } else if (x[1] == 2 || x[4] == 2 || x[7] == 2) {
                this.winne = 2;
            }
            //     bt12.setAnimation(blink1);
            bt12.setElevation(12);
            //    bt22.setAnimation(blink2);
            bt22.setElevation(12);
            //    bt32.setAnimation(blink3);
            bt32.setElevation(12);
            trans3();
            trans0();
            trans5();
            trans6();
            trans2();
            trans8();
        } else if (x[2] == x[5] && x[2] == x[8] && x[2] != 0) {
            if (x[2] == 1 || x[5] == 1 || x[8] == 1) {
                this.winne = 1;
            } else if (x[2] == 2 || x[5] == 2 || x[8] == 2) {
                this.winne = 2;
            }
            //   bt13.setAnimation(blink1);
            bt13.setElevation(12);
            //   bt23.setAnimation(blink2);
            bt23.setElevation(12);
            //    bt33.setAnimation(blink3);
            bt33.setElevation(12);
            trans3();
            trans4();
            trans0();
            trans6();
            trans7();
            trans1();
        } else if (x[0] == x[4] && x[0] == x[8] && x[0] != 0) {
            if (x[0] == 1 || x[4] == 1 || x[8] == 1) {
                this.winne = 1;
            } else if (x[0] == 2 || x[4] == 2 || x[8] == 2) {
                this.winne = 2;
            }
            //      bt11.setAnimation(blink1);
            bt11.setElevation(12);
            //     bt22.setAnimation(blink2);
            bt22.setElevation(12);
            //    bt33.setAnimation(blink3);
            bt33.setElevation(12);
            trans3();
            trans1();
            trans5();
            trans6();
            trans7();
            trans2();
        } else if (x[2] == x[4] && x[2] == x[6] && x[2] != 0) {
            if (x[2] == 1 || x[4] == 1 || x[6] == 1) {
                this.winne = 1;
            } else if (x[2] == 2 || x[4] == 2 || x[6] == 2) {
                this.winne = 2;
            }
            //     bt13.setAnimation(blink1);
            bt13.setElevation(12);
            //     bt22.setAnimation(blink2);
            bt22.setElevation(12);
            //     bt31.setAnimation(blink3);
            bt31.setElevation(12);
            trans3();
            trans0();
            trans5();
            trans1();
            trans7();
            trans8();
        } else if (x[0] != 0 && x[1] != 0 && x[2] != 0 && x[3] != 0 && x[4] != 0 && x[5] != 0 && x[6] != 0 && x[7] != 0 && x[8] != 0) {
            this.winne = 3;
        }
    }

    public void vic() {
        try {
            if (this.winne == 1) {
                reset();
                pl1.setText("Winner is " + this.playr);
                tts.speak(this.playr + " Wins", TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(Four_Play.this, this.playr + " (X) Wins", Toast.LENGTH_SHORT).show();
                flagwin = 1;
                timertk();
            } else if (this.winne == 2) {
                reset();
                pl1.setText("Winner is " + this.oppnt);
                tts.speak(this.oppnt + " Wins", TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(Four_Play.this, this.oppnt + " (O) Wins", Toast.LENGTH_SHORT).show();
                flagwin = 1;
                timertk();
            } else if (this.winne == 3) {
                reset();
                pl1.setText("Match Tie");
                tts.speak("Match Tie", TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(Four_Play.this, "Match Tie", Toast.LENGTH_SHORT).show();
                flagwin = 1;
                timertk();
            }
        } catch (Exception e) {
            Toast.makeText(Four_Play.this, "Error my : " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void timertk() {
        final String plyer = this.playr;
        final String opnt = this.oppnt;
        final String stt = this.strt;
        final String md = this.mod;

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                Intent wit = new Intent();
                wit.setClass(Four_Play.this, Four_Play.class);
                wit.putExtra("player", plyer);
                wit.putExtra("opponent", opnt);
                wit.putExtra("strt", stt);
                wit.putExtra("mode", md);
                startActivity(wit);
                onRestart();
            }
        };
        Timer t1 = new Timer();
        t1.schedule(tt, 2000);
    }

    public void reset() {
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
    protected void onStop() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }

        super.onStop();
        finish();
    }

    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {
            int res = tts.setLanguage(Locale.US);
            if (res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not Supported.");
            }
        } else {
            Log.e("TTS", "Initialisation Failed!");
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans0() {
        bt11.setElevation(0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans1() {
        bt12.setElevation(0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans2() {
        bt13.setElevation(0);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans3() {
        bt21.setElevation(0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans4() {
        bt22.setElevation(0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans5() {
        bt23.setElevation(0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans6() {
        bt31.setElevation(0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans7() {
        bt32.setElevation(0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void trans8() {
        bt33.setElevation(0);
    }

    //ai level_hard , moves recognition
    public void compturn() {
        //for victory
//for no move
        if (x[0] == 0 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 0 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 0) {
            Random r2 = new Random();
            int t = r2.nextInt(8 - 0 + 1);
            if (t == 0 || t == 1 || t == 2 || t == 3) {
                corners();
            } else if (t == 4) {
                zeros();
            } else if (t == 5 || t == 6 || t == 7 || t == 8) {
                centre();
            } else {
                centre();
            }

        }
        //after 1 move
        //ai's 1st move in center
        else if (x[0] == 0 && x[1] == 1 && x[2] == 0 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 0) {
            corners();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 0 && x[3] == 1 && x[4] == 2 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 0) {
            corners();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 2 && x[5] == 1 && x[6] == 0 && x[7] == 0 && x[8] == 0) {
            corners();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 0 && x[7] == 1 && x[8] == 0) {
            corners();
        } else if (x[0] == 1 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 0) {
            button8();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 1) {
            button0();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 1 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 0) {
            button6();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 1 && x[7] == 0 && x[8] == 0) {
            button2();
        }
        //ai's 1st move not in center
        else if (x[0] == 2 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 0) {
            button8();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 2 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 0) {
            button6();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 2 && x[7] == 0 && x[8] == 0) {
            button2();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 2) {
            button0();
        }
        //after exact 2 moves
        //continuing center move by ai
        else if (x[0] == 1 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 2 && x[5] == 1 && x[6] == 0 && x[7] == 0 && x[8] == 2) {
            button6();
        } else if (x[0] == 1 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 0 && x[7] == 1 && x[8] == 2) {
            button2();
        }
        //
        else if (x[0] == 0 && x[1] == 0 && x[2] == 1 && x[3] == 1 && x[4] == 2 && x[5] == 0 && x[6] == 2 && x[7] == 0 && x[8] == 0) {
            button8();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 1 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 2 && x[7] == 1 && x[8] == 0) {
            button0();
        }
        //
        else if (x[0] == 0 && x[1] == 1 && x[2] == 2 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 1 && x[7] == 0 && x[8] == 0) {
            button8();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 2 && x[3] == 0 && x[4] == 2 && x[5] == 1 && x[6] == 1 && x[7] == 0 && x[8] == 0) {
            button0();
        }
        //
        else if (x[0] == 2 && x[1] == 1 && x[2] == 0 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 1) {
            button6();
        } else if (x[0] == 2 && x[1] == 0 && x[2] == 0 && x[3] == 1 && x[4] == 2 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 1) {
            button2();
        }


//continuing for corners L shope fork
        else if (x[0] == 2 && x[1] == 0 && x[2] == 1 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 2) {
            button6();
        } else if (x[0] == 2 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 1 && x[7] == 0 && x[8] == 2) {
            button2();
        } else if (x[0] == 1 && x[1] == 0 && x[2] == 2 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 2 && x[7] == 0 && x[8] == 0) {
            button8();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 2 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 2 && x[7] == 0 && x[8] == 1) {
            button0();
        }

        //to win work after 2 or more than 2 moves
        else if (x[0] == x[1] && x[0] == 2 && x[2] == 0) {
            button2();
        } else if (x[0] == x[2] && x[0] == 2 && x[1] == 0) {
            button1();
        } else if (x[1] == x[2] && x[1] == 2 && x[0] == 0) {
            button0();
        } else if (x[3] == x[4] && x[3] == 2 && x[5] == 0) {
            button5();
        } else if (x[3] == x[5] && x[3] == 2 && x[4] == 0) {
            button4();
        } else if (x[4] == x[5] && x[4] == 2 && x[3] == 0) {
            button3();
        } else if (x[6] == x[7] && x[6] == 2 && x[8] == 0) {
            button8();
        } else if (x[6] == x[8] && x[6] == 2 && x[7] == 0) {
            button7();
        } else if (x[7] == x[8] && x[7] == 2 && x[6] == 0) {
            button6();
        } else if (x[0] == x[3] && x[0] == 2 && x[6] == 0) {
            button6();
        } else if (x[0] == x[6] && x[0] == 2 && x[3] == 0) {
            button3();
        } else if (x[3] == x[6] && x[3] == 2 && x[0] == 0) {
            button0();
        } else if (x[1] == x[4] && x[1] == 2 && x[7] == 0) {
            button7();
        } else if (x[1] == x[7] && x[1] == 2 && x[4] == 0) {
            button4();
        } else if (x[4] == x[7] && x[4] == 2 && x[1] == 0) {
            button1();
        } else if (x[2] == x[5] && x[2] == 2 && x[8] == 0) {
            button8();
        } else if (x[2] == x[8] && x[2] == 2 && x[5] == 0) {
            button5();
        } else if (x[5] == x[8] && x[5] == 2 && x[2] == 0) {
            button2();
        } else if (x[0] == x[4] && x[0] == 2 && x[8] == 0) {
            button8();
        } else if (x[0] == x[8] && x[0] == 2 && x[4] == 0) {
            button4();
        } else if (x[4] == x[8] && x[4] == 2 && x[0] == 0) {
            button0();
        } else if (x[2] == x[4] && x[2] == 2 && x[6] == 0) {
            button6();
        } else if (x[2] == x[6] && x[2] == 2 && x[4] == 0) {
            button4();
        } else if (x[4] == x[6] && x[4] == 2 && x[2] == 0) {
            button2();
        }

        //for defend
        else if (x[0] == x[1] && x[0] == 1 && x[2] == 0) {
            button2();
        } else if (x[0] == x[2] && x[0] == 1 && x[1] == 0) {
            button1();
        } else if (x[1] == x[2] && x[1] == 1 && x[0] == 0) {
            button0();
        } else if (x[3] == x[4] && x[3] == 1 && x[5] == 0) {
            button5();
        } else if (x[3] == x[5] && x[3] == 1 && x[4] == 0) {
            button4();
        } else if (x[4] == x[5] && x[4] == 1 && x[3] == 0) {
            button3();
        } else if (x[6] == x[7] && x[6] == 1 && x[8] == 0) {
            button8();
        } else if (x[6] == x[8] && x[6] == 1 && x[7] == 0) {
            button7();
        } else if (x[7] == x[8] && x[7] == 1 && x[6] == 0) {
            button6();
        } else if (x[0] == x[3] && x[0] == 1 && x[6] == 0) {
            button6();
        } else if (x[0] == x[6] && x[0] == 1 && x[3] == 0) {
            button3();
        } else if (x[3] == x[6] && x[3] == 1 && x[0] == 0) {
            button0();
        } else if (x[1] == x[4] && x[1] == 1 && x[7] == 0) {
            button7();
        } else if (x[1] == x[7] && x[1] == 1 && x[4] == 0) {
            button4();
        } else if (x[4] == x[7] && x[4] == 1 && x[1] == 0) {
            button1();
        } else if (x[2] == x[5] && x[2] == 1 && x[8] == 0) {
            button8();
        } else if (x[2] == x[8] && x[2] == 1 && x[5] == 0) {
            button5();
        } else if (x[5] == x[8] && x[5] == 1 && x[2] == 0) {
            button2();
        } else if (x[0] == x[4] && x[0] == 1 && x[8] == 0) {
            button8();
        } else if (x[0] == x[8] && x[0] == 1 && x[4] == 0) {
            button4();
        } else if (x[4] == x[8] && x[4] == 1 && x[0] == 0) {
            button0();
        } else if (x[2] == x[4] && x[2] == 1 && x[6] == 0) {
            button6();
        } else if (x[2] == x[6] && x[2] == 1 && x[4] == 0) {
            button4();
        } else if (x[4] == x[6] && x[4] == 1 && x[2] == 0) {
            button2();
        }
        //block fork
        else if (x[0] == 1 && x[4] == 0) {
            centre();
        } else if (x[2] == 1 && x[4] == 0) {
            centre();
        } else if (x[4] == 0 && x[6] == 1) {
            centre();
        } else if (x[4] == 0 && x[8] == 1) {
            centre();
        } else if (x[0] == 1 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 1) {
            zeros();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 1 && x[3] == 0 && x[4] == 2 && x[5] == 0 && x[6] == 1 && x[7] == 0 && x[8] == 0) {
            zeros();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 0) {
            corners();
        } else if (x[0] == 1 && x[1] == 0 && x[2] == 1 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 2) {
            corners();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 1 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 2 && x[7] == 0 && x[8] == 0) {
            corners();
        } else if (x[0] == 0 && x[1] == 0 && x[2] == 2 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 1 && x[7] == 0 && x[8] == 0) {
            corners();
        } else if (x[0] == 2 && x[1] == 0 && x[2] == 0 && x[3] == 0 && x[4] == 1 && x[5] == 0 && x[6] == 0 && x[7] == 0 && x[8] == 1) {
            corners();
        }


        //random move
        else {
            test();
        }
        mp.start();
    }

    public void compturneasy() {
        if (x[0] == x[1] && x[0] != 0 && x[2] == 0) {
            button2();
        } else if (x[0] == x[2] && x[0] != 0 && x[1] == 0) {
            button1();
        } else if (x[1] == x[2] && x[1] != 0 && x[0] == 0) {
            button0();
        } else if (x[3] == x[4] && x[3] != 0 && x[5] == 0) {
            button5();
        } else if (x[3] == x[5] && x[3] != 0 && x[4] == 0) {
            button4();
        } else if (x[4] == x[5] && x[4] != 0 && x[3] == 0) {
            button3();
        } else if (x[6] == x[7] && x[6] != 0 && x[8] == 0) {
            button8();
        } else if (x[6] == x[8] && x[6] != 0 && x[7] == 0) {
            button7();
        } else if (x[7] == x[8] && x[7] != 0 && x[6] == 0) {
            button6();
        } else if (x[0] == x[3] && x[0] != 0 && x[6] == 0) {
            button6();
        } else if (x[0] == x[6] && x[0] != 0 && x[3] == 0) {
            button3();
        } else if (x[3] == x[6] && x[3] != 0 && x[0] == 0) {
            button0();
        } else if (x[1] == x[4] && x[1] != 0 && x[7] == 0) {
            button7();
        } else if (x[1] == x[7] && x[1] != 0 && x[4] == 0) {
            button7();
        } else if (x[4] == x[7] && x[4] != 0 && x[1] == 0) {
            button1();
        } else if (x[2] == x[5] && x[2] != 0 && x[8] == 0) {
            button8();
        } else if (x[2] == x[8] && x[2] != 0 && x[5] == 0) {
            button5();
        } else if (x[5] == x[8] && x[5] != 0 && x[2] == 0) {
            button2();
        } else if (x[0] == x[4] && x[0] != 0 && x[8] == 0) {
            button8();
        } else if (x[0] == x[8] && x[0] != 0 && x[4] == 0) {
            button4();
        } else if (x[4] == x[8] && x[4] != 0 && x[0] == 0) {
            button0();
        } else if (x[2] == x[4] && x[2] != 0 && x[6] == 0) {
            button6();
        } else if (x[2] == x[6] && x[2] != 0 && x[4] == 0) {
            button4();
        } else if (x[4] == x[6] && x[4] != 0 && x[2] == 0) {
            button2();
        } else {
            test();
        }
        mp.start();
    }

    public void set1() {
        int i = 0;
        int j;
        while (i <= 8) {
            if (x[i] == 0) {
                j = i;
                if (j == 0) {
                    bt11.setEnabled(true);
                } else if (j == 1) {
                    bt12.setEnabled(true);
                } else if (j == 2) {
                    bt13.setEnabled(true);
                } else if (j == 3) {
                    bt21.setEnabled(true);
                } else if (j == 4) {
                    bt22.setEnabled(true);
                } else if (j == 5) {
                    bt23.setEnabled(true);
                } else if (j == 6) {
                    bt31.setEnabled(true);
                } else if (j == 7) {
                    bt32.setEnabled(true);
                } else if (j == 8) {
                    bt33.setEnabled(true);
                }

            }
            i++;
        }
    }


    public void corners() {
        int i = 1;
        int abc;
        Random r = new Random();
        while (i > 0) {
            abc = (int) r.nextInt(3 - 0 + 1);
            if (c[abc] == 0) {
                c[abc] = 2;
                this.flag = abc;
                break;
            }
            i++;
        }

        if (this.flag == 0) {
            bt11.setBackgroundResource(R.drawable.on1);
            bt11.setAnimation(fade0);
            bt11.setEnabled(false);
            x[0] = 2;
        } else if (this.flag == 1) {
            bt13.setBackgroundResource(R.drawable.on1);
            bt13.setAnimation(fade2);
            bt13.setEnabled(false);
            x[2] = 2;
        } else if (this.flag == 2) {
            bt31.setBackgroundResource(R.drawable.on1);
            bt31.setAnimation(fade6);
            bt31.setEnabled(false);
            x[6] = 2;
        } else if (this.flag == 3) {
            bt33.setBackgroundResource(R.drawable.on1);
            bt33.setAnimation(fade8);
            bt33.setEnabled(false);
            x[8] = 2;
        }

        check();
        vic();
        op--;

    }

    public void zeros() {
        int i = 1;
        int abc;
        Random r = new Random();
        while (i > 0) {
            abc = (int) r.nextInt(3 - 0 + 1);
            if (o[abc] == 0) {
                o[abc] = 2;
                this.flag = abc;
                break;
            }
            i++;
        }

        if (this.flag == 0) {
            bt12.setBackgroundResource(R.drawable.on1);
            bt12.setAnimation(fade1);
            bt12.setEnabled(false);
            x[1] = 2;
        } else if (this.flag == 1) {
            bt21.setBackgroundResource(R.drawable.on1);
            bt21.setAnimation(fade3);
            bt21.setEnabled(false);
            x[3] = 2;
        } else if (this.flag == 2) {
            bt23.setBackgroundResource(R.drawable.on1);
            bt23.setAnimation(fade5);
            bt23.setEnabled(false);
            x[5] = 2;
        } else if (this.flag == 3) {
            bt32.setBackgroundResource(R.drawable.on1);
            bt32.setAnimation(fade7);
            bt32.setEnabled(false);
            x[7] = 2;
        }

        check();
        vic();
        op--;

    }

    public void centre() {
        x[4] = 2;
        bt22.setBackgroundResource(R.drawable.on1);
        bt22.setAnimation(fade4);
        bt22.setEnabled(false);
        op--;
    }

    public void test() {
        int i = 1;
        int abc;
        Random r = new Random();
        while (i > 0) {
            abc = (int) r.nextInt(8 - 0 + 1);
            if (x[abc] == 0) {
                x[abc] = 2;
                this.flag = abc;
                break;
            }
            i++;
        }
        if (this.flag == 0) {
            bt11.setBackgroundResource(R.drawable.on1);
            bt11.setAnimation(fade0);
            bt11.setEnabled(false);
        } else if (this.flag == 1) {
            bt12.setBackgroundResource(R.drawable.on1);
            bt12.setAnimation(fade1);
            bt12.setEnabled(false);
        } else if (this.flag == 2) {
            bt13.setBackgroundResource(R.drawable.on1);
            bt13.setAnimation(fade2);
            bt13.setEnabled(false);
        } else if (this.flag == 3) {
            bt21.setBackgroundResource(R.drawable.on1);
            bt21.setAnimation(fade3);
            bt21.setEnabled(false);
        } else if (this.flag == 4) {
            bt22.setBackgroundResource(R.drawable.on1);
            bt22.setAnimation(fade4);
            bt22.setEnabled(false);
        } else if (this.flag == 5) {
            bt23.setBackgroundResource(R.drawable.on1);
            bt23.setAnimation(fade5);
            bt23.setEnabled(false);
        } else if (this.flag == 6) {
            bt31.setBackgroundResource(R.drawable.on1);
            bt31.setAnimation(fade6);
            bt31.setEnabled(false);
        } else if (this.flag == 7) {
            bt32.setBackgroundResource(R.drawable.on1);
            bt32.setAnimation(fade7);
            bt32.setEnabled(false);
        } else if (this.flag == 8) {
            bt33.setBackgroundResource(R.drawable.on1);
            bt33.setAnimation(fade8);
            bt33.setEnabled(false);
        }

        check();
        vic();
        op--;
    }

    public void startmethod() {
        if (this.strt.length() == 2) {
            mp.start();
            pl1.setText("Wait..." + oppnt + " (O) turn");
            test();
            op++;
        } else if (this.strt.length() == 1) {
            pl1.setText(playr + " (X) turn");
        } else {
            Toast.makeText(Four_Play.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void button0() {
        x[0] = 2;
        bt11.setBackgroundResource(R.drawable.on1);
        bt11.setAnimation(fade0);
        bt11.setEnabled(false);
        op--;
    }

    public void button1() {
        x[1] = 2;
        bt12.setBackgroundResource(R.drawable.on1);
        bt12.setAnimation(fade1);
        bt12.setEnabled(false);
        op--;
    }

    public void button2() {
        x[2] = 2;
        bt13.setBackgroundResource(R.drawable.on1);
        bt13.setAnimation(fade2);
        bt13.setEnabled(false);
        op--;
    }

    public void button3() {
        x[3] = 2;
        bt21.setBackgroundResource(R.drawable.on1);
        bt21.setAnimation(fade3);
        bt21.setEnabled(false);
        op--;
    }

    public void button4() {
        x[4] = 2;
        bt22.setBackgroundResource(R.drawable.on1);
        bt22.setAnimation(fade4);
        bt22.setEnabled(false);
        op--;
    }

    public void button5() {
        x[5] = 2;
        bt23.setBackgroundResource(R.drawable.on1);
        bt23.setAnimation(fade5);
        bt23.setEnabled(false);
        op--;
    }

    public void button6() {
        x[6] = 2;
        bt31.setBackgroundResource(R.drawable.on1);
        bt31.setAnimation(fade6);
        bt31.setEnabled(false);
        op--;
    }

    public void button7() {
        x[7] = 2;
        bt32.setBackgroundResource(R.drawable.on1);
        bt32.setAnimation(fade7);
        bt32.setEnabled(false);
        op--;
    }

    public void button8() {
        x[8] = 2;
        bt33.setBackgroundResource(R.drawable.on1);
        bt33.setAnimation(fade8);
        bt33.setEnabled(false);
        op--;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        reset();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(this.winne==0){
        if (animation == fadeh0 || animation == fadeh1 || animation == fadeh2 || animation == fadeh3 || animation == fadeh4 || animation == fadeh5 || animation == fadeh6 || animation == fadeh7 || animation == fadeh8) {
            pl1.setText("Wait..." + oppnt + " (O) turn");
            mp.start();
            if (flagwin == 0) {
                if (op > 1) {
                    if (this.mod.length() == 12) {
                        compturneasy();
                    } else if (this.mod.length() == 6) {
                        compturn();
                    } else if (this.mod.length() == 8) {
                        test();
                    }
                    check();
                    vic();
                }
            }
        }
        if (animation == fade0 || animation == fade1 || animation == fade2 || animation == fade3 || animation == fade4 || animation == fade5 || animation == fade6 || animation == fade7 || animation == fade8) {
            pl1.setText(playr + " (X) turn");
            set1();
        }
    }

}
    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
