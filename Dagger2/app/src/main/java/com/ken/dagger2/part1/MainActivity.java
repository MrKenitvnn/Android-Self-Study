package com.ken.dagger2.part1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ken.dagger2.R;
import butterknife.ButterKnife;
import javax.inject.Inject;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.edit_text_name)
    EditText editTextName;

    @InjectView(R.id.button_show_name)
    Button buttonShowName;

    @InjectView(R.id.text_view_name)
    TextView textViewName;

    @Inject
    HelloService helloService;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        DaggerApplication.component().inject(this);
    }

    @OnClick(R.id.button_show_name) void onClickShowName () {
        textViewName.setText(helloService.greet(editTextName.getText().toString().trim()));
    }



}
