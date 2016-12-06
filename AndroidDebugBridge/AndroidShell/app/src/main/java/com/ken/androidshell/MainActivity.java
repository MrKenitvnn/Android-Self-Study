package com.ken.androidshell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ken.androidshell.utils.ShellExecuter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "mzlog";
    EditText editTextCommand;
    Button buttonExecute;
    TextView textViewLog;

    String command = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCommand = (EditText) findViewById(R.id.edit_text_command);
        buttonExecute = (Button) findViewById(R.id.button_excute);
        textViewLog = (TextView) findViewById(R.id.text_view_log);


        buttonExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO Auto-generated method stub
                ShellExecuter exe = new ShellExecuter();
                command = editTextCommand.getText().toString();

                String outp = exe.Executer(command);
                textViewLog.setText(outp);
                Log.w(TAG, outp);
            }
        });

    }
}
