package com.example.niuyi.bkpulltorefreshdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.niuyi.bkpulltorefreshdemo.bkpulltorefresh.BkPullToRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class MainActivity extends AppCompatActivity implements PtrHandler,
        BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_demo)
    RecyclerView mRvDemo;
    @BindView(R.id.bk_pull_to_refresh)
    BkPullToRefreshLayout mBkPullToRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBkPullToRefresh.setPtrHandler(this);

        initList();
    }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        new Handler().postDelayed(new Runnable() {

            public void run() {
                mBkPullToRefresh.refreshComplete();
                Toast.makeText(getApplicationContext(), "刷新成功", Toast.LENGTH_SHORT).show();
            }

        }, 3000);
    }

    @Override
    public void onLoadMoreRequested() {

    }

    private void initList() {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add("我是第" + i + "几条数据");
        }

        MainAdapter adapter = new MainAdapter(list);

//        adapter.setLoadMoreView(new CustomLoadMoreView());//自定义上拉加载布局
//        mInlandGoodsAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
//        mAdapter.setAutoLoadMoreSize(3);//距离底布多少item预加载

        mRvDemo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter.setOnLoadMoreListener(this);

        mRvDemo.setAdapter(adapter);
    }
}
