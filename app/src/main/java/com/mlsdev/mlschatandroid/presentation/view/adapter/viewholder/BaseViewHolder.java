package com.mlsdev.mlschatandroid.presentation.view.adapter.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by oleksandr on 05.05.17.
 */

public class BaseViewHolder<T, L extends BaseAdapterClickListener<T>> extends RecyclerView.ViewHolder {

    private T item;
    private L listener;

    public BaseViewHolder(View itemView, @NonNull final L listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.listener = listener;
        itemView.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.onItemClick(item);
        }
    };

    public void bindItem(T item) {
        this.item = item;
    }
}
