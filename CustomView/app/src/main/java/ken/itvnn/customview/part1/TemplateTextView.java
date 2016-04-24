package ken.itvnn.customview.part1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import ken.itvnn.customview.R;

/**
 * Created by ken on 24/04/2016.
 */
public class TemplateTextView extends TextView {

    protected String template;

    public TemplateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TemplateTextView);
        template = attributes.getString(R.styleable.TemplateTextView_template);
        if (template == null || !template.contains("%s")) {
            template = "%s";
        }
        attributes.recycle();
    }

}