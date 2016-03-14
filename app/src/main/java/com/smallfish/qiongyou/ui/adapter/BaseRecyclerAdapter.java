package com.smallfish.qiongyou.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by smallfish on 16-3-14.
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder> {

    public Context context;
    public List<T> datas;

    public BaseRecyclerAdapter(Context context, List<T> datas) {
        this.context = context;
        this.datas = datas;
    }

    public abstract int getResId();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(getResId(), parent, false);
        return new ViewHolder(view);
    }

    @Override
    public abstract void onBindViewHolder(ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
