package com.example.bagus.quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder builder;
    RadioGroup radiogroup;
    private Handler handler = new Handler();
    private TextView textView;
    MediaPlayer audioBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        //Memanggil file my_sound pada folder raw
        audioBackground = MediaPlayer.create(this, R.raw.my_sound);
        //Set looping ke true untuk mengulang audio jika telah selesai
        audioBackground.setLooping(true);
        //Set volume audio agar berbunyi
        audioBackground.setVolume(1, 1);
        //Memulai audio
        audioBackground.start();

        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);

        textView = (TextView) findViewById(R.id.timeView);
        startTimer();

    }

    int i = 4;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            i--;
            textView.setText("00:" + i);
            startTimer();

            if (i == 0) {
                pindah();
            }

        }
    };

    private void pindah() {
        Intent intent = new Intent(MainActivity.this, Question2.class);
        startActivity(intent);
    }

    public void startTimer() {
        handler.postDelayed(runnable, 1000);
    }

    public void cancelTimer() {
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }


    public void onRadioButton(View view) {

        Boolean checked = ((RadioButton) view).isChecked();

        RadioButton kunci1 = (RadioButton) findViewById(R.id.kunci1);
        RadioButton kunci2 = (RadioButton) findViewById(R.id.kunci2);
        RadioButton kunci3 = (RadioButton) findViewById(R.id.kunci3);
        RadioButton kunci4 = (RadioButton) findViewById(R.id.kunci4);

        int score = 0;
        if (kunci1.isChecked()) score += 25;
        if (kunci2.isChecked()) score += 25;
        if (kunci3.isChecked()) score += 25;
        if (kunci4.isChecked()) score += 25;

        score++;
        textView.setText("score kamu :" + score);


        int nilai = 25;
        switch (nilai) {
            case R.id.kunci1:
                if (kunci1.isChecked())
                    nilai++;
            case R.id.kunci2:
                if (kunci2.isChecked())
                    nilai++;
            case R.id.kunci3:
                if (kunci3.isChecked())
                    nilai++;
            case R.id.kunci4:
                if (kunci4.isChecked())
                    nilai++;
            default:
                break;
        }


    }

    public void nextBtn(View view) {
        Intent intent = new Intent(MainActivity.this, Question2.class);
        startActivity(intent);
    }


}
