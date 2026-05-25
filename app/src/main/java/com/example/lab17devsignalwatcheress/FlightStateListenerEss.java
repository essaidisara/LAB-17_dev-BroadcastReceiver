package com.example.lab17devsignalwatcheress;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class FlightStateListenerEss extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {

            boolean essFlightModeStatus =
                    intent.getBooleanExtra("state", false);

            String essStatusMessage;

            if (essFlightModeStatus) {

                essStatusMessage =
                        "ess : mode avion activé";

            } else {

                essStatusMessage =
                        "ess : mode avion désactivé";
            }

            Toast.makeText(
                    context,
                    essStatusMessage,
                    Toast.LENGTH_LONG
            ).show();

            Toast.makeText(
                    context,
                    essStatusMessage,
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}