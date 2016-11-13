package ken.com.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mryit on 11/13/2016.
 */
public class GraphicView extends View {

    Paint mPaint;

    public GraphicView(Context context) {
        this(context, null);
    }

    public GraphicView (Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public GraphicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    /** Canvas
     *  Canvas cung cấp cho chúng ta rất nhiều các phương thức để chúng ta vẽ các đối tượng hình học
     *  bắt đầu bởi phương thức canvas.draw
     *  Draw Point/Line/Rect/Circle/Ovals/Arc..
     */

    /** Paint
     *  Paint trong java dùng để định nghĩa size, color, kiểu nét vẽ
     *  mà chúng ta sẽ sử dụng để vẽ bỏi canvas
     */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw component in here

        // vẽ 1 điểm
        drawPoint(canvas);

        // vẽ 1 đường thẳng
        drawLine(canvas);

        // vẽ 1 hình chữ nhật
        drawRect(canvas);

        // update paint color
        setPaintColor(Color.YELLOW);
        // vẽ 1 hình tròn
        drawCircle(canvas);

        // vẽ 1 hình oval
        drawOval(canvas);

        // vẽ một hình cung
        drawArc(canvas);
    }


    private void initPaint () {
        /**
         * ANTI_ALIAS_FLAG: chỉ định cho Pain vẽ smooth các biên của các đối tượng.
         * Ví dụ: như vẽ hình tròn sẽ loại bỏ những hình răng cưa bao quanh,
         *        cho cảm giác mượt mà hơn.
         */
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE); // màu để vẽ là BLUE
        mPaint.setStrokeWidth(30);  // độ rộng nét vẽ là 30
    }

    /**
     * Draw Point: Sử dụng đối tượng Paint để vẽ
     */
    private void drawPoint (Canvas canvas) {
        /**
         * 1. Vẽ tại một điểm
         *    drawPoint(x, y, Paint paint)
         *
         * 2. Vẽ danh sách các điểm trong mảng pts hai vị trí kề này là x và y.
         *    drawPoints(@NonNull float[]pts, @NonNull Paint paint)
         *
         * 3. Vẽ danh sách các điểm trong mảng pts và có giới hạn vẽ từ khoảng nào và độ dài bao nhiêu
         *    drawPoints(float[] pts, int offset, int count, @NonNull Paint paint)
         */

        // Ví dụ dùng phương thức 1: Vẽ tại tọa độ x, y
        int x = 100;
        int y = 150;
        canvas.drawPoint(x, y, mPaint);
    }

    /**
     * Draw Line: Sử dụng đối tượng Paint để vẽ
     */
    private void drawLine (Canvas canvas) {

        /**
         * 1. Vẽ đoạn thẳng với 4 tham số, điểm x, y bắt đầu, x, y kết thúc
         *    drawLine(float startX, float startY, float stopX, float stopY, Paint paint)
         *
         * 2. Vẽ đoạn thẳng trong mảng pts với 4 phần từ liên tiếp là startX, startY, stopX, stopY
         *    với độ dời offset bao nhiêu trong mảng, và số phần tử để vẽ.
         *    drawLines(float[] pts, int offset, int count, Paint paint
         *
         * 3. Vẽ đoạn thẳng trong mảng pts với 4 phần từ liên tiếp sẽ là startX, startY, stopX, stopY
         *    drawLines(float[] pts, Paint paint)
         */

        // Ví dụ dùng phương thức 1
        float startX = 0;
        float startY = 0;
        float stopX = getWidth();
        float stopY = getHeight();
        canvas.drawLine(startX, startY, stopX, stopY, mPaint);
    }


    /**
     * Draw Rect: Sử dụng đối tượng Paint để vẽ
     */
    private void drawRect (Canvas canvas) {
        /**
         * 1. Vẽ Rect với data rect là kiểu số thực
         *    drawRect(@NonNull RectF rect, @NonNull Paint paint)
         *
         * 2. Vẽ Rect với data r là số nguyên
         *    drawRect(@NonNull Rect r, @NonNull Paint paint)
         *
         * 3. Vẽ Rect với các thông số cơ bản left, top, right, bottom.
         *    drawRect(float left, float top, float right, float bottom, @NonNull Paint paint)
         */

        // Ví dụ sau vẽ hình chữ nhật 100x200 ở chính giữa màn hình
        float width = 100;
        float height = 200;
        float left = (getWidth() - width) / 2.0f;
        float top = (getHeight() - height) / 2.0f;
        canvas.drawRect(left, top, left + width, top + height, mPaint);
    }


    /**
     * Draw Circle
     */
    private void drawCircle (Canvas canvas) {
        float radius = 50.0f; // vẽ một vòng bán kính 50
        float cx = radius; // từ tâm tới trục x
        float cy = radius; // từ tâm tới trục y

        // chỉ có một phương thức để vẽ hình tròn
        canvas.drawCircle(cx, cy, radius, mPaint);
    }


    /**
     * Draw Oval
     */
    private void drawOval (Canvas canvas) {
        /**
         * 1. Vẽ hình oval có các yếu tố là left, top, right, bottom
         *    drawOval(float left, float top, float right, float bottom, @NonNull Paint paint)
         *
         * 2. Vẽ hình oval trong hình chữ nhật có các yếu tố là left, top, right, bottom.
         *    Phương thức này chỉ gọi được trên Android API 21
         *    drawOval(@NonNull RectF oval, @NonNull Paint paint)
         */

        // Ví dụ sử dụng phương thức thứ 2
        float width = 150;
        float height = 100;
        float left = (getWidth() - width) / 2.0f; // giữa màn hình
        float top = (getHeight() - height) - 10; // cách bottom 10

        canvas.drawOval(new RectF(left, top, left + width, top + height), mPaint);
    }


    /**
     * Draw Hình cung
     */
    private void drawArc (Canvas canvas) {
        /**
         * 1. Vẽ Arc với các đối số:
         *    drawArc(
         *    @NonNull RectF oval,  -- Hình chữ nhật bao quanh,
         *    float startAngle,     -- góc bắt đầu vẽ,
         *    float sweepAngle,     -- cung vẽ bao nhiêu,
         *    boolean useCenter,    -- có nối 2 đầu mút của cung vào tâm không?
         *    @NonNull Paint paint) -- đối tượng Paint.
         *
         * 2. Phương thức này chỉ sử dụng từ API 21
         *    Vẽ Arc với các đối số left, top, right, bottom đại diện cho hình chữ nhật bao quanh arc,
         *    góc bắt đầu vẽ, cung vẽ bao nhiêu, có sử dụng tâm để vẽ không, và đối tượng paint.
         *    drawArc(float left, float top, float right, float bottom,
         *            float startAngle, float sweepAngle, boolean useCenter, @NonNull Paint paint)
         */

        // ví dụ sử dụng phương thức 1
        float width = 150;
        float height = 150;
        float left = (getWidth() - width) / 2.0f;
        float top = height / 2.0f;

        canvas.drawArc(new RectF(left, top, left+width, top+height), 10, 350, false, mPaint);
    }

    private void setPaintColor (int color) {
        mPaint.setColor(color);
    }

}
