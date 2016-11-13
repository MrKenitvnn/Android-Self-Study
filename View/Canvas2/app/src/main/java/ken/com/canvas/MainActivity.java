package ken.com.canvas;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ken.com.canvas.circle.Circle;
import ken.com.canvas.circle.CircleAngleAnimation;

public class MainActivity extends AppCompatActivity {

    Button buttonStart;
    Circle circle;

    private float percent = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.button_start);
        circle = (Circle) findViewById(R.id.circle);

        // set giá trị ban đầu cho vòng tròn,
        circle.setColor(Color.BLACK);
        circle.setAngle(90);
        circle.requestLayout(); // để cập nhật lại view

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // phải làm đúng thứ tự khởi tạo và set giá trị
                CircleAngleAnimation animation = new CircleAngleAnimation(circle, 360);
                animation.setDuration(CircleAngleAnimation.ANIMATION_DURATION_SLOW);
                circle.startAnimation(animation);

                /*
                // [START] demo chạy vòng tròn ở onProgressUpdate
                if (percent >= 1) {
                    return;
                }
                percent += 0.2f;
                circle.setAngleWithPercent(percent);
                circle.requestLayout();
                // [END] demo chạy vòng tròn ở onProgressUpdate
                */

            }
        });
    }
}
