package com.example.administrator.irc;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.Intent;
import android.graphics.PostProcessor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.security.Provider;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;

import static com.example.administrator.irc.R.*;

public class Ring_tone extends Service {
    MediaPlayer media_song;
    boolean isRuning;
    int startId;



    @Nullable
    @Override
    public IBinder onBind ( Intent intent ) {

        return null;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public int onStartCommand ( Intent intent, int flage, int startId ) {
        Log.i("local Servies", " Recieved Start Id" + startId + ":" + intent);

        //////////////////////fetch the extra string value
        String state = intent.getExtras().getString("Extra");
        Log.e("Ringtone state:Extra is", state);
        //////////////////////////
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run () {

            }
        });


        ////////////////this convert Extra string from the intent to 0 or 1
       assert state != null;
        switch (state) {
            case "alarm on":
                startId = 1;
                break;
            case "alarm off":
                startId = 0;
                break;
            default:
                startId = 0;
                break;

        }

        if(!this.isRuning && startId==1){
            media_song = MediaPlayer.create(this,R.raw.clock);

            Log.e("there is no music,","and you want to start");


            /////start Ringtone
            media_song.start();
            this.isRuning=true;
            this.startId=0;
            showNotification();

            ////////////////////////////////////////notifications /////////////

          /*  //setup notification
            NotificationManager notif_manger =(NotificationManager)getSystemService
                    (NOTIFICATION_SERVICE);
            //setup intent that goes to Alarm
            Intent alarm_intent1 =new Intent(this.getApplicationContext(),Alarm.class);
            //setup pending intent
            PendingIntent alarm_pending_intent =PendingIntent.getActivity(this,
                    0,alarm_intent1,0)   ;
            //notif parameters
            NotificationCompat.Builder notifi_popu =new NotificationCompat
                    .Builder(getApplicationContext()).
                    setContentTitle("An alarm is going off!").
                    setContentIntent(alarm_pending_intent)
                    .setContentText("click me")
                    .setSmallIcon(R.drawable.ic_icon_alarm)
                    .setAutoCancel(true);
            ////set up notification on command


            notif_manger.notify(0,notifi_popu.build());*/

        }

        else if (this.isRuning &&  startId==0){
            Log.e("there is  music,","and you want to end");
            /////stop ring tone
            media_song.stop();
            media_song.reset();
            this.isRuning =false;
            this.startId = 0;
        }

        else if (!this.isRuning && startId==0){
            Log.e("there is no music,","and you want to end");
            this.isRuning =false;
            this.startId =0;

        }
        else if( this.isRuning && startId==1) {
            Log.e("there is  music,","and you want to start");
            this.isRuning=true;
            this.startId =1;
        }
        else {
            Log.e("else","somehow you reach this");
        }


        return START_NOT_STICKY;


    }
    public void onDestroy(){
        super.onDestroy();
        this.isRuning=false;
    }

    private void showNotification(){
        Context context = getApplicationContext();


        Intent alarm_intent1 =new Intent(this.getApplicationContext(),Alarm.class);
        PendingIntent alarm_pending_intent =PendingIntent.getActivity(this,
                0,alarm_intent1,0)   ;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"default")
                .setSmallIcon(R.drawable.ic_icon_alarm).
                        setContentTitle("An alarm is going off!").setContentText("click me")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(alarm_pending_intent);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId("com.myApp");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "com.myApp",
                    "My App",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
        notificationManager.notify(2,builder.build());

    }
    }


