package com.example.administrator.irc;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.jesusm.holocircleseekbar.lib.HoloCircleSeekBar;


public class Ac extends AppCompatActivity {
    HoloCircleSeekBar seekBar;
    TextView text;
    int pointer = 0;
    int pointer1 = 0;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        seekBar = findViewById(R.id.picker);

        Button fan_button = findViewById(R.id.button9);
        Button Modes_button = findViewById(R.id.button10);
        ///////////////fan speed/////////////
        final ToggleButton button_h = findViewById(R.id.toggleButton5);
        final ImageView image_h = findViewById(R.id.imageView5);

        Button button = findViewById(R.id.button);

        final ToggleButton button_m = findViewById(R.id.toggleButton6);
        final ImageView image_m = findViewById(R.id.imageView6);

        final ToggleButton button_l = findViewById(R.id.toggleButton7);
        final ImageView image_l = findViewById(R.id.imageView7);

        final ToggleButton button_a = findViewById(R.id.toggleButton8);
        final ImageView image_a = findViewById(R.id.imageView8);

        /////////////////////Modes//////////////////////
        final ToggleButton button_ho = findViewById(R.id.toggleButton9);
        final ImageView image_ho = findViewById(R.id.imageView9);

        final ToggleButton button_f = findViewById(R.id.toggleButton10);
        final ImageView image_f = findViewById(R.id.imageView10);

        final ToggleButton button_c = findViewById(R.id.toggleButton11);
        final ImageView image_c = findViewById(R.id.imageView11);

        //defindButtons();
        text = findViewById(R.id.textView);
         text.setText(Integer.toString(16));
        seekBar.setOnSeekBarChangeListener(new HoloCircleSeekBar.OnCircleSeekBarChangeListener() {
            @Override
            public void onProgressChanged ( HoloCircleSeekBar holoCircleSeekBar, int i, boolean b ) {
                int x = (seekBar.getValue() + 16);
                text.setText(Integer.toString(x));
            }

            @Override
            public void onStartTrackingTouch ( HoloCircleSeekBar holoCircleSeekBar ) {

            }

            @Override
            public void onStopTrackingTouch ( HoloCircleSeekBar holoCircleSeekBar ) {

            }
        });
//////////////////////////////////fan speeds/////////////////////////////////////////
       /* button_h.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick ( View v ) {
                    TransitionDrawable drawable1 = (TransitionDrawable) image_m.getDrawable();
                    TransitionDrawable drawable = (TransitionDrawable) image_h.getDrawable();
                    TransitionDrawable drawable2 = (TransitionDrawable) image_l.getDrawable();
                    TransitionDrawable drawable3 = (TransitionDrawable) image_a.getDrawable();


                    if (button_h.isChecked()) {
                        drawable1.resetTransition();
                        drawable2.resetTransition();
                        drawable3.resetTransition();
                            button_h.setBackgroundDrawable(drawable);
                            drawable.startTransition(1000);
                    } else {
                        button_h.setBackgroundDrawable(drawable);
                        drawable.reverseTransition(1000);


                    }


                }

            });
            button_m.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick ( View v ) {
                    TransitionDrawable drawable1 = (TransitionDrawable) image_m.getDrawable();
                    TransitionDrawable drawable = (TransitionDrawable) image_h.getDrawable();
                    TransitionDrawable drawable2 = (TransitionDrawable) image_l.getDrawable();
                    TransitionDrawable drawable3 = (TransitionDrawable) image_a.getDrawable();


                    if (button_m.isChecked()) {
                        drawable.resetTransition();
                        drawable2.resetTransition();
                        drawable3.resetTransition();
                        button_m.setBackgroundDrawable(drawable1);
                            drawable1.startTransition(1000);

                    } else {

                        button_m.setBackgroundDrawable(drawable1);
                        drawable1.reverseTransition(1000);


                    }
                }

            });


            button_l.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick ( View v ) {
                    TransitionDrawable drawable1 = (TransitionDrawable) image_m.getDrawable();
                    TransitionDrawable drawable = (TransitionDrawable) image_h.getDrawable();
                    TransitionDrawable drawable2 = (TransitionDrawable) image_l.getDrawable();
                    TransitionDrawable drawable3 = (TransitionDrawable) image_a.getDrawable();


                    if (button_l.isChecked()) {
                        drawable.resetTransition();
                        drawable1.resetTransition();
                        drawable3.resetTransition();
                            button_l.setBackgroundDrawable(drawable2);
                            drawable2.startTransition(1000);

                    }
                    else {
                        button_l.setBackgroundDrawable(drawable2);
                        drawable2.reverseTransition(1000);


                    }


                }
            });


            button_a.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick ( View v ) {
                    TransitionDrawable drawable1 = (TransitionDrawable) image_m.getDrawable();
                    TransitionDrawable drawable = (TransitionDrawable) image_h.getDrawable();
                    TransitionDrawable drawable2 = (TransitionDrawable) image_l.getDrawable();
                    TransitionDrawable drawable3 = (TransitionDrawable) image_a.getDrawable();


                    if (button_a.isChecked()) {
                        drawable.resetTransition();
                        drawable1.resetTransition();
                        drawable2.resetTransition();
                        button_a.setBackgroundDrawable(drawable3);
                        drawable3.startTransition(1000);
                    } else {
                        button_a.setBackgroundDrawable(drawable3);
                        drawable3.reverseTransition(1000);


                    }
                }
            });
            /////////////////////////////////////MOdes////////////////////////////////

            button_ho.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick ( View v ) {
                    TransitionDrawable drawable2 = (TransitionDrawable) image_c.getDrawable();
                    TransitionDrawable drawable1 = (TransitionDrawable) image_f.getDrawable();
                    TransitionDrawable drawable = (TransitionDrawable) image_ho.getDrawable();
                    if (button_ho.isChecked()) {
                        drawable1.resetTransition();
                        drawable2.resetTransition();
                        button_ho.setBackgroundDrawable(drawable);
                        drawable.startTransition(1000);
                    } else {
                        button_ho.setBackgroundDrawable(drawable);
                        drawable.reverseTransition(1000);


                    }
                }
            });

            button_f.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick ( View v ) {
                    TransitionDrawable drawable2 = (TransitionDrawable) image_c.getDrawable();
                    TransitionDrawable drawable1 = (TransitionDrawable) image_f.getDrawable();
                    TransitionDrawable drawable = (TransitionDrawable) image_ho.getDrawable();

                    if (button_f.isChecked()) {
                        drawable.resetTransition();
                        drawable2.resetTransition();
                        button_f.setBackgroundDrawable(drawable1);
                        drawable1.startTransition(1000);
                    } else {
                        button_f.setBackgroundDrawable(drawable1);
                        drawable1.reverseTransition(1000);


                    }
                }

            });
            button_c.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick ( View v ) {
                    TransitionDrawable drawable2 = (TransitionDrawable) image_c.getDrawable();
                    TransitionDrawable drawable1 = (TransitionDrawable) image_f.getDrawable();
                    TransitionDrawable drawable = (TransitionDrawable) image_ho.getDrawable();

                    if (button_c.isChecked()) {
                        drawable.resetTransition();
                        drawable1.resetTransition();
                        button_c.setBackgroundDrawable(drawable2);
                        drawable2.startTransition(1000);
                    } else {
                        button_c.setBackgroundDrawable(drawable2);
                        drawable2.reverseTransition(1000);


                    }
                }

            });*/
        fan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                pointer++;
                TransitionDrawable drawable1 = (TransitionDrawable) image_m.getDrawable();
                TransitionDrawable drawable = (TransitionDrawable) image_h.getDrawable();
                TransitionDrawable drawable2 = (TransitionDrawable) image_l.getDrawable();
                TransitionDrawable drawable3 = (TransitionDrawable) image_a.getDrawable();
                if (pointer == 1) {
                    button_l.setBackgroundDrawable(drawable2);
                    drawable2.startTransition(1000);
                    drawable.resetTransition();
                    drawable1.resetTransition();
                    drawable3.resetTransition();

                } else if (pointer == 2) {
                    button_m.setBackgroundDrawable(drawable1);
                    drawable1.startTransition(1000);
                    drawable.resetTransition();
                    drawable3.resetTransition();
                    drawable2.resetTransition();
                } else if (pointer == 3) {
                    button_h.setBackgroundDrawable(drawable);
                    drawable.startTransition(1000);
                    drawable3.resetTransition();
                    drawable1.resetTransition();
                    drawable2.resetTransition();
                } else if (pointer == 4) {
                    button_a.setBackgroundDrawable(drawable3);
                    drawable3.startTransition(1000);
                    drawable.resetTransition();
                    drawable1.resetTransition();
                    drawable2.resetTransition();
                } else {
                    pointer = 0;

                }

            }
        });
        Modes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                pointer1++;
                TransitionDrawable drawable2 = (TransitionDrawable) image_c.getDrawable();
                TransitionDrawable drawable1 = (TransitionDrawable) image_f.getDrawable();
                TransitionDrawable drawable = (TransitionDrawable) image_ho.getDrawable();
                if (pointer1 == 1) {
                    drawable1.resetTransition();
                    drawable1.resetTransition();
                    drawable2.resetTransition();
                    button_ho.setBackgroundDrawable(drawable);
                    drawable.startTransition(1000);

                } else if (pointer1 == 2) {
                    drawable.resetTransition();
                    drawable2.resetTransition();
                    button_f.setBackgroundDrawable(drawable1);
                    drawable1.startTransition(1000);
                } else if (pointer1 == 3) {
                    drawable.resetTransition();
                    drawable1.resetTransition();
                    button_c.setBackgroundDrawable(drawable2);
                    drawable2.startTransition(1000);
                } else {
                    pointer1 = 0;
                }
            }
        });


    }

}
