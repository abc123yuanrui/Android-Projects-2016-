package com.example.administrator.woocongress_modified;

import android.content.Context;
        import android.util.AttributeSet;
        import android.widget.GridView;
        import android.widget.ListView;
/**
 * 不可滑动的dto
 * @author Administrator
 *
 */
public class MyListView extends ListView {

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }


}

