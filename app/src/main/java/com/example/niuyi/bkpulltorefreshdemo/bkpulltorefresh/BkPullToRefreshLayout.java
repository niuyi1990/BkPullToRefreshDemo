package com.example.niuyi.bkpulltorefreshdemo.bkpulltorefresh;

import android.content.Context;
import android.util.AttributeSet;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * User: niuyi(牛毅)
 * Date: 2017-02-15
 * Time: 11:07
 * Desc: bk下拉刷新布局界面
 */
public class BkPullToRefreshLayout extends PtrFrameLayout {

    public BkPullToRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BkPullToRefreshLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public BkPullToRefreshLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        BkPullToRefreshHeader header = new BkPullToRefreshHeader(getContext());
        setHeaderView(header);
        addPtrUIHandler(header);
    }
}
