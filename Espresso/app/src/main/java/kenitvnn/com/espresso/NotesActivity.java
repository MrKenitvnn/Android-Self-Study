package kenitvnn.com.espresso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mryit on 10/17/2016.
 */
public class NotesActivity extends Activity {

    @Bind(R.id.button_add_note)
    Button buttonAddNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_notes);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.button_add_note)
    void onButtonAddNote() {
        Intent intent = new Intent(NotesActivity.this, AddNoteActivity.class);
        startActivity(intent);
    }

}
