package com.example.administrator.irc;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Alarm extends AppCompatActivity /*implements Example_dialog.ExapleDialogListener*/{
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    Context context;
    private TextView update_text;
    PendingIntent pending_intent;
    int startid;
    String value = "alarm on";


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        this.context = this;

        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm_timepicker = findViewById(R.id.picker);
        update_text = findViewById(R.id.textView2);
        final Calendar calender = Calendar.getInstance();
        Button off_Alarm = findViewById(R.id.button);
        final Button set_Alarm = findViewById(R.id.button2);
        final Intent my_intent = new Intent(this.context, Alarm_recievier.class);
        set_Alarm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick ( View v ) {

                calender.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calender.set(Calendar.MINUTE, alarm_timepicker.getMinute());
                String Am_Pm = "AM";
                int Hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();
                String Hour_string = String.valueOf(Hour);
                String minute_string = String.valueOf(minute);
                /////////////////to convert to 12 clock
                if (Hour >= 12) {

                    Am_Pm = "PM";
                    if (Hour ==12){
                     Hour=24;
                    }
                    Hour_string = String.valueOf(Hour - 12);

                }
                if (minute < 10) {
                    minute_string = "0" + String.valueOf(minute);
                }


                set_alarm_text("Alarm set to " + Hour_string + ":" + minute_string + Am_Pm);


                my_intent.putExtra("Extra", "alarm on");
                //////////////////////////pending intent/////////////////////////////////
                pending_intent = PendingIntent.getBroadcast
                        (Alarm.this, 0, my_intent
                                , PendingIntent.FLAG_UPDATE_CURRENT);
                ///////////////////////Alarm manager//////////////////////////////
                alarm_manager.set(AlarmManager.RTC_WAKEUP, calender.
                        getTimeInMillis(), pending_intent);
               // openDialog();





            }


        });
        off_Alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                set_alarm_text("Alarm off");
                alarm_manager.cancel(pending_intent);

                my_intent.putExtra("Extra", "alarm off");


                sendBroadcast(my_intent);
            }


        });

    }

    private void set_alarm_text ( String output ) {

        update_text.setText(output);
    }


   /* public void openDialog () {
        Example_dialog ExampleDialog = new Example_dialog();
        ExampleDialog.show(getSupportFragmentManager(), "Example dialog");
    }

    @Override
    public void applyTexts ( int start ) {
        startid = start;
        if (startid == 0) {
            value = "alarm off";
        } else if (startid == 1) {
            value = "alarm on";
        }*/

    }

