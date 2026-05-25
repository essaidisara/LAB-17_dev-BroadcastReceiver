package com.example.lab17devsignalwatcheress;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private FlightStateListenerEss essFlightReceiver;

    private boolean essReceiverEnabled = false;

    private Button btnEssActivation;
    private Button btnEssBroadcast;

    private TextView txtEssStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        essFlightReceiver =
                new FlightStateListenerEss();

        txtEssStatus =
                findViewById(R.id.txtEssStatus);

        btnEssActivation =
                findViewById(R.id.btnEssActivation);

        btnEssBroadcast =
                findViewById(R.id.btnEssBroadcast);

        btnEssActivation.setOnClickListener(v -> {
            manageEssReceiver();
        });

        btnEssBroadcast.setOnClickListener(v -> {
            sendEssBroadcast();
        });
    }

    private void manageEssReceiver() {

        if (!essReceiverEnabled) {

            IntentFilter essIntentFilter =
                    new IntentFilter();

            essIntentFilter.addAction(
                    Intent.ACTION_AIRPLANE_MODE_CHANGED
            );

            registerReceiver(
                    essFlightReceiver,
                    essIntentFilter
            );

            essReceiverEnabled = true;

            txtEssStatus.setText(
                    " écoute du mode avion activée"
            );

            Toast.makeText(
                    this,
                    "ess : receiver mode avion démarré",
                    Toast.LENGTH_LONG
            ).show();

            btnEssActivation.setText(
                    "Désactiver receiver ess"
            );

        } else {

            unregisterReceiver(essFlightReceiver);

            essReceiverEnabled = false;

            txtEssStatus.setText(
                    "ess : écoute désactivée"
            );

            Toast.makeText(
                    this,
                    "ess : receiver mode avion arrêté",
                    Toast.LENGTH_LONG
            ).show();

            btnEssActivation.setText(
                    "Activer receiver ess"
            );
        }
    }

    private void sendEssBroadcast() {

        Intent essCustomIntent =
                new Intent(
                        "com.example.lab17devsignalwatcheress.INTERNAL_ALERT"
                );

        essCustomIntent.putExtra(
                "payload",
                "broadcast personnalisé ess envoyé"
        );

        sendBroadcast(essCustomIntent);

        Toast.makeText(
                this,
                "ess : custom broadcast transmis",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    protected void onDestroy() {

        if (essReceiverEnabled) {

            unregisterReceiver(essFlightReceiver);
        }

        super.onDestroy();
    }
}