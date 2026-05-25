package com.example.lab17devsignalwatcheress;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class StartupMonitorEss extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {

            String essBootNotification =
                    "ess : système démarré correctement";

            Toast.makeText(
                    context,
                    essBootNotification,
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}