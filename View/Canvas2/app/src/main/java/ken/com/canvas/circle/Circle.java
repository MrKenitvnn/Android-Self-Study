package ken.com.canvas.circle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import ken.com.canvas.util.MZLog;

/**
 * Created by mryit on 11/13/2016.
 */

/**
 * Muốn cái vòng chạy dần tới góc 360 khi tải dữ liệu
 * cần tính toán phần trăm của dữ liệu ở onProgressUpdate,
 * và gọi phương thức setAngle
 */
public class Circle extends View {
    private static final int START_ANGLE_POINT = -90; // -90 = đỉnh trên
                                                    // 90 = đỉnh dưới

    private int mStrokeWidth = 2; // độ rộng của đường viền || đang không cho set ở ngoài được
    private Paint mPaint; // đối tượng vẽ
    private RectF rect; // hình chữ nhật bao quanh
    private float angle; // góc xuất phát (vẽ từ 0 tới angle)

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mStrokeWidth);

        //Circle color
        mPaint.setColor(Color.RED);

        //Initial Angle (optional, it can be zero)
        angle = 0;
    }

    int parentWidth;  // width  |_, đang lấy theo giá trị từ xml
    int parentHeight; // height   |
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
        MZLog.d("parent width: " + parentWidth + "-- parent height: " + parentHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rect = new RectF(mStrokeWidth, mStrokeWidth, parentWidth - mStrokeWidth, parentHeight - mStrokeWidth);
        canvas.drawArc(rect, START_ANGLE_POINT, angle, true, mPaint);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setAngleWithPercent (float percent) {
        this.angle = percent * 360;
    }

    public void setColor (int color) {
        mPaint.setColor(color);
    }

}
