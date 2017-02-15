package com.example.niuyi.bkpulltorefreshdemo;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * User: niuyi(牛毅)
 * Date: 2017-02-15
 * Time: 11:42
 * Desc:
 */
public class MainAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MainAdapter(List<String> data) {
        super(R.layout.item_main, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
