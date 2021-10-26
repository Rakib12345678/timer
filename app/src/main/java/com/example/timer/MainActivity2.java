package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        constraintLayout=findViewById(R.id.constraint);
        setContentView(R.layout.activity_main2);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun();
            }
        });

    }

    public void fun() {
        startActivity(new Intent(MainActivity2.this,MainActivity.class));
    }
}