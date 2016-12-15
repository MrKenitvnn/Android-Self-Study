package com.ken.appindexing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.URLSpan;
import android.widget.TextView;

/**
 * Created by mryit on 12/3/2016.
 */
public class BrowableActivity extends Activity {

    TextView textViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browable);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        textViewData = (TextView) findViewById(R.id.text_view_data);
        textViewData.setText("action: " + action + "\r\ndata: " + data.toString());

    }
}
