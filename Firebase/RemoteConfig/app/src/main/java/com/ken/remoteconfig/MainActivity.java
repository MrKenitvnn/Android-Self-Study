package com.ken.remoteconfig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init id
        textViewWelcome = (TextView) findViewById(R.id.text_view_welcome);

        // get message and print
        String message = AppConfigs.getInstance().getConfig().getString(FirebaseRemoteKey.WELCOME_MESSAGE);
        textViewWelcome.setText(message);


    }
}
