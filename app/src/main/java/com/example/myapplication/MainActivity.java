package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout b1, b2, b3;
    private Button start_stop;
    private boolean run = false;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.bulp1);
        b2 = findViewById(R.id.bulp2);
        b3 = findViewById(R.id.bulp3);
        start_stop = findViewById(R.id.start);
    }


    public void onClickStart(View view) {

        if(!run) {
            start_stop.setText("Stop";
            run = true; //Значение изменяется на true, чтобы при повторном нажатии условие не выполнялось

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (run) {

                        try {Thread.sleep(1500);} catch (InterruptedException e) {e.printStackTrace();}

                        count++;

                        switch (count)
                        {
                            case 1:
                                b1.setBackgroundColor(Color.RED);
                                b2.setBackgroundColor(Color.GRAY);
                                b3.setBackgroundColor(Color.GRAY);
                                break;
                            case 2:
                                b1.setBackgroundColor(Color.GRAY);
                                b2.setBackgroundColor(Color.YELLOW);
                                b3.setBackgroundColor(Color.GRAY);
                                break;
                            case 3:
                                b1.setBackgroundColor(Color.GRAY);
                                b2.setBackgroundColor(Color.GRAY);
                                b3.setBackgroundColor(Color.GREEN);
                                count = 0;
                                break;
                        }
                    }

                }
            }).start();
        }

        else {
            //Если повторно нажать на кнопку, то лог. значение станет true и условие, а с ним и цикл, не выполнится, но выполнится постусловие
            b1.setBackgroundColor(Color.GRAY);
            b2.setBackgroundColor(Color.GRAY);
            b3.setBackgroundColor(Color.GRAY);
            run = false;
            count = -1;
            start_stop.setText("Start");

        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        run = false;
    }
}