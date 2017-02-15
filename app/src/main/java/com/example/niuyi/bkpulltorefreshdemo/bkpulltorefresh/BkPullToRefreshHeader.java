package com.example.niuyi.bkpulltorefreshdemo.bkpulltorefresh;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.niuyi.bkpulltorefreshdemo.R;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * User: niuyi(牛毅)
 * Date: 2017-02-15
 * Time: 11:05
 * Desc: bk项目下拉刷新
 */
public class BkPullToRefreshHeader extends FrameLayout implements PtrUIHandler {

    private static final int STATE_RESET = 0;//重置
    private static final int STATE_PRE = 1;//准备
    private static final int STATE_BEGIN = 2;//开始
    private static final int STATE_COM = 3;//完成

    private int mState;//状态标识{下拉状态分为：重置，准备，开始，完成四种}

    private ImageView mIvPullDefault;
    private ImageView mIvPullAnim;

    private AnimationDrawable mAnim;

    public BkPullToRefreshHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BkPullToRefreshHeader(Context context) {
        super(context);
        init();
    }

    public BkPullToRefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bk_refresh_header_view, this, false);
        mIvPullDefault = (ImageView) view.findViewById(R.id.iv_pull_default);
        mIvPullAnim = (ImageView) view.findViewById(R.id.iv_pull_anim);

        addView(view);
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {
        mState = STATE_RESET;
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        mState = STATE_PRE;
    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        mState = STATE_BEGIN;
        //开始执行刷新动画,此时需要隐藏掉默认显示图
        mIvPullDefault.setVisibility(View.GONE);
        mIvPullAnim.setVisibility(View.VISIBLE);
        mIvPullAnim.setBackgroundResource(R.drawable.anim_pull_to_refresh);
        mAnim = (AnimationDrawable) mIvPullAnim.getBackground();
        if (mAnim != null && !mAnim.isRunning()) {
            mAnim.start();
        }
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        mState = STATE_COM;
        //刷新完成，停止动画，显示默认展位图
        mIvPullDefault.setVisibility(View.VISIBLE);
        mIvPullAnim.setVisibility(View.GONE);
        if (mAnim != null && mAnim.isRunning()) {
            mAnim.stop();
        }
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        switch (mState) {
            case STATE_RESET:

                break;
            case STATE_PRE:

                break;
            case STATE_BEGIN:

                break;
            case STATE_COM:

                break;
        }
    }
}
