package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)
                findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                doOpenChildActivity();
            }
        });
    }
    public void doOpenChildActivity()
    {
        Intent myIntent=new Intent(this, MainActivity2.class);

        startActivity(myIntent);
    }
}