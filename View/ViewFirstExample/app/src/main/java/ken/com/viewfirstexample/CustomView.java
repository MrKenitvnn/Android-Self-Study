package ken.com.viewfirstexample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mryit on 11/12/2016.
 */
public class CustomView extends View {

    private static final String TAG = "mzlog";

    public CustomView(Context context) {
        super(context);
        Log.i(TAG, "CustomView .");
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i(TAG, "CustomView method + attrs");
        int[] set = {
                android.R.attr.background, // idx 0
                android.R.attr.text        // idx 1
        };
        TypedArray a = context.obtainStyledAttributes(attrs, set);
        Drawable d = a.getDrawable(0);
        CharSequence t = a.getText(1);
        Log.d(TAG, "attrs " + d + " " + t);
        a.recycle();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i(TAG, "CustomView method + attrs + def Style attr");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG, "onAttachedToWindow .");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i(TAG, "onMeasure .");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i(TAG, "onLayout .");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw .");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(TAG, "onDetachedFromWindow .");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(TAG, "dispatch Touch Event .");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "dispatchTouchEvent ACTION_DOWN.");
                break;

            case MotionEvent.ACTION_UP:
                Log.i(TAG, "dispatchTouchEvent ACTION_UP.");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "dispatchTouchEvent ACTION_MOVE.");
                break;

            case MotionEvent.ACTION_HOVER_ENTER:
                Log.i(TAG, "dispatchTouchEvent ACTION_HOVER_ENTER.");
                break;

            case MotionEvent.ACTION_HOVER_EXIT:
                Log.i(TAG, "dispatchTouchEvent ACTION_HOVER_EXIT.");
                break;
        }

        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "on Touch Event .");

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "ACTION_DOWN.");
                return true;

            case MotionEvent.ACTION_UP:
                Log.i(TAG, "ACTION_UP.");
                return true;

            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "ACTION_MOVE.");
                return true;

            case MotionEvent.ACTION_HOVER_ENTER:
                Log.i(TAG, "ACTION_HOVER_ENTER.");
                return true;

            case MotionEvent.ACTION_HOVER_EXIT:
                Log.i(TAG, "ACTION_HOVER_EXIT.");
                return true;
        }



        return super.onTouchEvent(event);
    }




}
