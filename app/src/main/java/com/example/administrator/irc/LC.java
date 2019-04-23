package com.example.administrator.irc;

import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class LC extends AppCompatActivity {
     int progress=0;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lc);
        /////////////////////////////////////////

        final ToggleButton button_1= findViewById(R.id.toggleButton);
        final ToggleButton button_2=findViewById(R.id.toggleButton2);
        final ToggleButton button_3=findViewById(R.id.toggleButton3);
        final ToggleButton button_4=findViewById(R.id.toggleButton4);
        ///////////////////////////dimar
        final TextView text =findViewById(R.id.textView3);
        final ImageView image=findViewById(R.id.imageView);

        SeekBar bar =findViewById(R.id.seekBar);
       // bar.setMin(0);
        bar.setMax(9);
        bar.setProgress(progress);
        final ArrayList<Integer> list =new ArrayList<>();
        list.add(0,R.drawable.button_off);
        list.add(1,R.drawable.one2);
        list.add(2,R.drawable.two2);
        list.add(3,R.drawable.three2);
        list.add(4,R.drawable.four2);
        list.add(5,R.drawable.five2);
        list.add(6,R.drawable.six2);
        list.add(7,R.drawable.seven2);
        list.add(8,R.drawable.eight2);
        list.add(9,R.drawable.button_on);
        image.setBackgroundResource(list.get(0));

       bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged ( SeekBar seekBar, int progress, boolean fromUser ) {
               text.setText(""+progress);
               image.setBackgroundResource(list.get(progress));
           }

           @Override
           public void onStartTrackingTouch ( SeekBar seekBar ) {



           }

           @Override
           public void onStopTrackingTouch ( SeekBar seekBar ) {

           }
       });

        /////////////////////////////////////////////////////////////////////

        button_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (final  View v ) {
               // TransitionDrawable drawable =(TransitionDrawable)  image_1.getDrawable();
                if(button_1.isChecked()){
                    //drawable.startTransition(100);
                    button_1.setBackgroundResource(list.get(9));
                   // image_1.setBackgroundDrawable(drawable);

                }
                else {
                    //drawable.reverseTransition(100);
                    button_1.setBackgroundResource(list.get(0));
                   // image_1.setBackgroundDrawable(drawable);
                }
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (final  View v ) {
                if(button_2.isChecked()){

                    button_2.setBackgroundResource(list.get(9));

                }
                else {
                    button_2.setBackgroundResource(list.get(0));
                }
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (final  View v ) {
                if(button_3.isChecked()){
                    button_3.setBackgroundResource(list.get(9));
                }
                else {
                    button_3.setBackgroundResource(list.get(0));
                }
            }
        });
        button_4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (final  View v ) {

                if(button_4.isChecked()){
                    button_4.setBackgroundResource(list.get(9));

                }
                else {
                    button_4.setBackgroundResource(list.get(0));
                }
            }
        });

    }
}
