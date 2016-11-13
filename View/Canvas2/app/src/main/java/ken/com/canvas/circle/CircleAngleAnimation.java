package ken.com.canvas.circle;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Toast;

import ken.com.canvas.util.MZLog;

/**
 * Created by mryit on 11/13/2016.
 */
public class CircleAngleAnimation extends Animation implements Animation.AnimationListener {

    public static final int ANIMATION_DURATION_FAST = 400;
    public static final int ANIMATION_DURATION_NORMAL = 800;
    public static final int ANIMATION_DURATION_SLOW = 1200;

    private Circle circle;   // hình tròn thực thi animation
    private float oldAngle; // góc xuất phát
    private float newAngle; // góc mới khi vẽ lại

    public CircleAngleAnimation(Circle circle, int newAngle) {
        this.oldAngle = circle.getAngle();
        this.newAngle = newAngle;
        this.circle = circle;

        // đăng ký lắng nghe animation start/end/repeat
        this.onAnimationStart(this);
        this.onAnimationEnd(this);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);
        circle.setAngle(angle);
        circle.requestLayout();
    }

    @Override
    public void onAnimationStart(Animation animation) {
        MZLog.i("animation start _______________________ set lại góc ban đầu để nó chạy lại");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        MZLog.i("animation end____________________________");
    }


    @Override
    public void onAnimationRepeat(Animation animation) {
        MZLog.i("animation repeat___________________________");
    }
}
