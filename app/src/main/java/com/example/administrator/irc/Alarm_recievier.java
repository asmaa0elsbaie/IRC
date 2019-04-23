package com.example.administrator.irc;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import  android.content.BroadcastReceiver;
import android.content.ComponentName;
import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;

    public class Alarm_recievier extends BroadcastReceiver {

        @Override
        public void onReceive ( Context context, Intent intent ) {

            Log.e(" We are on the Reciever","Yay!");
            ////////////fetch string value from intent
            String get_your_string=intent.getExtras().getString("Extra");
            Log.e(" what's your key ?",get_your_string);
            Intent Servics_intent = new Intent(context,Ring_tone.class);
            //////////////pass string from activity to Ring tone
            Servics_intent.putExtra("Extra",get_your_string);
            //////////start the Ring tone servics
            context.startService(Servics_intent);
            /**ComponentName comp = new ComponentName(context.getPackageName(),
                    Ring_tone.class.getName());
            startWakefulService(context, (intent.setComponent(comp)));*/

        }
    }


