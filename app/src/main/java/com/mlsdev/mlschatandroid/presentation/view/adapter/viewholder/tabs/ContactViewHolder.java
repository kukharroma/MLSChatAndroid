package com.mlsdev.mlschatandroid.presentation.view.adapter.viewholder.tabs;

import android.support.annotation.NonNull;
import android.view.View;

import com.mlsdev.mlschatandroid.domain.model.User;
import com.mlsdev.mlschatandroid.presentation.view.adapter.viewholder.BaseAdapterClickListener;
import com.mlsdev.mlschatandroid.presentation.view.adapter.viewholder.BaseViewHolder;

/**
 * Created by oleksandr on 05.05.17.
 */

public class ContactViewHolder extends BaseViewHolder<User, BaseAdapterClickListener<User>> {

    public ContactViewHolder(View itemView, @NonNull BaseAdapterClickListener<User> listener) {
        super(itemView, listener);
    }

    @Override
    public void bindItem(User item) {
        super.bindItem(item);
    }
}
