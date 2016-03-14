package com.smallfish.qiongyou.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by smallfish on 16-3-14.
 */
public abstract class BaseListviewAdapter<T> extends BaseAdapter {

    public List<T> datas;
    public Context context;
    private View itemView;

    public BaseListviewAdapter(List<T> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position,convertView,parent);
    }

    protected abstract View getItemView(int position, View convertView, ViewGroup parent);


}
