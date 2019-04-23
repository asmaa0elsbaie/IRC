package com.example.administrator.irc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sleep ( View view ) {
        Intent intent = new Intent(this, Sleep.class);

        startActivity(intent);

    }

    public void alarm ( View view ) {
        Intent intent = new Intent(this, Alarm.class);

        startActivity(intent);
    }

    public void mosque ( View view ) {
        Intent intent = new Intent(this,Q.class);

        startActivity(intent);
    }

    public void light ( View view ) {
        Intent intent = new Intent(this, LC.class);

        startActivity(intent);
    }

    public void shutter ( View view ) {
        Intent intent = new Intent(this, Shutter.class);

        startActivity(intent);
    }

    public void key ( View view ) {
        Intent intent = new Intent(this, key.class);

        startActivity(intent);
    }

    public void ac ( View view ) {
        Intent intent = new Intent(this, Ac.class);

        startActivity(intent);
    }
}
