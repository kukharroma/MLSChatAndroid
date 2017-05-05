package com.mlsdev.mlschatandroid.presentation.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mlsdev.mlschatandroid.presentation.view.adapter.viewholder.BaseAdapterClickListener;
import com.mlsdev.mlschatandroid.presentation.view.adapter.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by oleksandr on 05.05.17.
 */

public abstract class BaseAdapter<VH extends BaseViewHolder<T, L>, T, L extends BaseAdapterClickListener<T>> extends RecyclerView.Adapter<VH> {
    private List<T> data;
    protected L listener;

    public BaseAdapter(@NonNull L listener) {
        this.listener = listener;
    }

    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bindItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
}
