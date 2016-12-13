package com.ali.android.toolbarapp;

import android.content.Context;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/3.
 */
public class CurToolBar extends Toolbar {

    private ImageView mImageView;
    private TextView mSearchEdit;
    private View view;

    public CurToolBar(Context context) {
        this(context, null);
    }

    public CurToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public CurToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        view = LayoutInflater.from(getContext()).inflate(R.layout.tool_bar_layout, null);

       // ViewById(R.id.toolbar_title);
        mImageView = (ImageView) view.findViewById(R.id.toolbar_imgbtn);
        mSearchEdit = (TextView) view.findViewById(R.id.toolbar_search_view);

        if (mImageView != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.CurToolBar, defStyleAttr, 0);
            mImageView.setImageDrawable(a.getDrawable(R.styleable.CurToolBar_rightButtonIcon));
            a.recycle();
        }
        if (mSearchEdit != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.CurToolBar, defStyleAttr, 0);
            boolean isVisible = a.getBoolean(R.styleable.CurToolBar_isShowSearchView, false);
            mSearchEdit.setVisibility(isVisible ? View.VISIBLE : View.GONE);
            a.recycle();
        }

        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER_HORIZONTAL);
        addView(view, lp);
    }
}