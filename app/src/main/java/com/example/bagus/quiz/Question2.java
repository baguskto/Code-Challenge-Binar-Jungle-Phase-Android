package com.example.bagus.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Question2 extends AppCompatActivity {

    private Handler handler = new Handler();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

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
        Intent intent = new Intent(Question2.this, Question3.class);
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

    }

    public void nextBtn(View view) {
        Intent intent = new Intent(Question2.this, Question3.class);
        startActivity(intent);
    }
}
