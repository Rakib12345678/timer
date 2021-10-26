package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
 TextView sec,mili,min;
 Button btnstart,btnstop,btnpause;
 Timer mytimer;
 int x=0,y=0,z=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mili=findViewById(R.id.mili);
        sec=findViewById(R.id.sec);
        min=findViewById(R.id.min);
        btnpause=findViewById(R.id.bts_pause);
        btnstart=findViewById(R.id.bt_start);
        btnstop=findViewById(R.id.btn_stop);

        btnstart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {if(mytimer!=null)
                return;
                mytimer=new Timer();
                mytimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mili.setText(x%1000+"MS");
                                sec.setText((int)x/1000+"S");
                                min.setText((int)x/(1000*60)+"M");
                                x+=1;

                            }
                        });
                    }
                },0,1);

            }
        });
        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(mytimer!=null)
                {
                    mytimer.cancel();
                    mytimer=null;
                }
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mytimer!=null)
                {
                    mytimer.cancel();
                    mytimer=null;
                }
                x=0;
            }
        });
    }
}