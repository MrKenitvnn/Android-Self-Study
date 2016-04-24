package ken.itvnn.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ken.itvnn.customview.part1.DurationTextView;

public class MainActivity extends AppCompatActivity {

    DurationTextView textViewDuration1, textViewDuration2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        textViewDuration1.setDuration(23123);
        textViewDuration2.setDuration(23123);

    }


    private void initViews () {
        textViewDuration1 = (DurationTextView) findViewById(R.id.duration_text_view_1);
        textViewDuration2 = (DurationTextView) findViewById(R.id.duration_text_view_2);
    }
}
