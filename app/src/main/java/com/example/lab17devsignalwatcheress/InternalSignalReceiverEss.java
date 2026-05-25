package com.example.lab17devsignalwatcheress;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class InternalSignalReceiverEss
        extends BroadcastReceiver {

    @Override
    public void onReceive(
            Context context,
            Intent intent
    ) {

        if ("com.example.lab17devsignalwatcheress.INTERNAL_ALERT"
                .equals(intent.getAction())) {

            String essInternalMessage =
                    intent.getStringExtra("payload");

            Toast.makeText(
                    context,
                    "ess reçu : " + essInternalMessage,
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}