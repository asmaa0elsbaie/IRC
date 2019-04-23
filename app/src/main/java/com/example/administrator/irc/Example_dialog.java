package com.example.administrator.irc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class Example_dialog extends AppCompatDialogFragment {
    private ExapleDialogListener listener;
    int startid;
    private Handler mhandler =new Handler();
    @Override
    public Dialog onCreateDialog ( final Bundle savedInstanceState ) {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.layout_dialog,null);
        builder.setView(view);
        builder.setTitle("Your Alarm Ready ^_^");
        builder.setNegativeButton("stop", new DialogInterface.OnClickListener() {
            @Override
            public void onClick ( DialogInterface dialog, int which ) {
                startid=1;
                listener.applyTexts(startid);

            }
        });
        builder.setPositiveButton("snooze", new DialogInterface.OnClickListener() {
            @Override
            public void onClick ( DialogInterface dialog, int which ) {
                startid = 0;
                listener.applyTexts(startid);
                mhandler.postDelayed(mtoastrunable,5000);
                startid =1;
                listener.applyTexts(startid);


            }
        });
        return builder.create();


    }
    private Runnable mtoastrunable = new Runnable() {
        @Override
        public void run () {
          //  Toast.makeText(Alarm.,"Alarm will repeat after 5 sec *_*",Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public void onAttach ( Context context ) {
        super.onAttach(context);
        try {
            listener =(ExapleDialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context+"must implement example Dialog");

        }
    }

    public interface ExapleDialogListener{
        void applyTexts(int start);
    }
}
