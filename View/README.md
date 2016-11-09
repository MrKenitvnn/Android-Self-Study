
Khi add một View hay một ViewGroup(FrameLayout, LinearLayout, RelativeLayout) thì các method sau sẽ được gọi:


<image src="http://eitguide.com/wp-content/uploads/2016/08/add_view_in_viewgroup.png" />

#### onAttachedToWindow: 
được gọi khi chúng ta attach View vào Window.
#### onMesure: 
tính toán, ước lượng kích thước cho View. Sau khi tính toán xong 
phải gọi phương thức setMeasuredDimension() để set Width và Height cho View.

* Phương thức onMesure:
```java
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, "onMeasure: ");
    }
```
Hai giá trị widthMeasureSpect, heightMeasureSpec là hai giá trị mà ViewGroup truyền xuống.
Mỗi tham số này sẽ có hai giá trị chứ trong nó đó là

+ Giá trị kích thước (width, height)

+ Giá trị MeasureSpec gồm có ba giá trị là EXACTLY, AT_MOST, UNSPECIFIED

```java
int width = MeasureSpec.getSize(widthMeasureSpec);
int mode = MeasureSpec.getMode(widthMeasureSpec);
```

+) MeasureSpec.EXACTLY: View sẽ có kích thước chính xác. 
Trong trường hợp layout_width hoặc layout_height là một con số xác định hoặc là match_parent

+) MeasureSpec.AT_MOST: View sẽ có kích thước nhỏ hơn hoặc bằng đúng giá trị kích thước của parent.

+) MeasureSpec.UNSPECIFIED: View sẽ có kích thước như nó mong muốn (có thể lớn hơn kich thước của parent). 
Trường hợp này xảy ra nếu layout_width haowjc layout_height có giá trị là wrap_content.

> Phương thức này được gọi nhiều lần. 
Nếu gặp lỗi getWidth và getHeight của View mà nhận về giá trị 0 thì nguyên nhân là 
do phương thức onMeasure chưa được call và chưa set setMeasureDimension().


### onLayout
Phương thức này dùng để xác định vị trí của View. Thông thường phương thức này sử dụng khi chúng ta muốn tạo một ViewGroup mới.
> Phương thức này cũng được gọi nhiều lần.

### onDraw
Phương thức vẽ của View. Trong Android mọi thứ đều được vẽ lên Canvas. 
Sau khi chạy xong phương thức này thì View chính thức được vẽ lên màn hình Android.
> Nếu View có thuộc tính Visibility = GONE thì Android sẽ không thực hiện vẽ View đó.
> Phương thức này không được gọi nếu View đó là ViewGroup.

### requestLayout
Chúng ta gọi method này khi muốn thay đổi kích thước của View. 
Andoird thực hiện tính toán lại kích thước của View.
Nghĩa là phải chạy vào phương thức onMeasure và đi xuống những phương thức khác để vẽ View.


### invalidate & postInvalidate
Sử dụng phương thức này khi muốn vẽ lại view, nó sẽ gọi onDraw để tiến hành vẽ lại View.
>invalidate khi muốn vẽ trong UI Thread
>postInvalidate khi muốn vẽ trong một Thread khác không phải là Main Thread.

### Các phương thức Touch trên View
Các view cơ bản (không phải ViewGroup) chúng ta có một phương thức touch trên view đó là phương thức onTouchEvent
```java
@Override
public boolean onTouchEvent (MotionEvent event) {
    Log.e(TAG, "onTouchEvent: " + event);
    return super.onTouchEvent(event);
}
```
Đối tượng MotionEvent giữ các thông tin về touch như vị trí x,y,action...

#### Nếu View là ViewGroup thì chúng ta có nhiều phương thức xử lý touch hơn nữa. 

```java
@Override
public boolean dispatchTouchEvent(MotionEvent event) {
    return super.dispatchTouchEvent(event);
}

@Override
public boolean onInterceptTouchEvent(MotionEvent event) {
    return super.onInterceptTouchEvent(event);
}

@Override
public boolean onTouchEvent(MotionEvent event) {
    return super.onTouchEvent(event);
}
```






