package com.ken.secondprojectuselib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.ken.hellojni.EncodeAESUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Của bạn đây: " + EncodeAESUtil.getInstance().getCode(), Toast.LENGTH_SHORT).show();

    }
}
