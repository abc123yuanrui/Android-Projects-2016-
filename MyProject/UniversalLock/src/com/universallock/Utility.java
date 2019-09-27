package com.universallock;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Utility
{
  public static void setListViewHeightBasedOnChildren(ListView paramListView)
  {
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    int i = 0;
    int j = View.MeasureSpec.makeMeasureSpec(paramListView.getWidth(), -2147483648);
    for (int k = 0;; k++)
    {
      if (k >= localListAdapter.getCount())
      {
        ViewGroup.LayoutParams localLayoutParams = paramListView.getLayoutParams();
        localLayoutParams.height = (i + paramListView.getDividerHeight() * (-1 + localListAdapter.getCount()));
        paramListView.setLayoutParams(localLayoutParams);
        paramListView.requestLayout();
        return;
      }
      View localView = localListAdapter.getView(k, null, paramListView);
      localView.measure(j, 0);
      i += localView.getMeasuredHeight();
    }
  }
}


/* Location:           D:\file\1\Compressed\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name:     com.app.universallock.Utility
 * JD-Core Version:    0.7.0.1
 */