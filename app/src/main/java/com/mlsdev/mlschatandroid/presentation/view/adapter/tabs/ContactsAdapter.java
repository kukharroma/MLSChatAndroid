package com.mlsdev.mlschatandroid.presentation.view.adapter.tabs;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mlsdev.mlschatandroid.R;
import com.mlsdev.mlschatandroid.domain.model.User;
import com.mlsdev.mlschatandroid.presentation.view.adapter.BaseAdapter;
import com.mlsdev.mlschatandroid.presentation.view.adapter.viewholder.BaseAdapterClickListener;
import com.mlsdev.mlschatandroid.presentation.view.adapter.viewholder.tabs.ContactViewHolder;

/**
 * Created by oleksandr on 05.05.17.
 */

public class ContactsAdapter extends BaseAdapter<ContactViewHolder, User, BaseAdapterClickListener<User>> {

    public ContactsAdapter(@NonNull BaseAdapterClickListener<User> listener) {
        super(listener);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ContactViewHolder(view, listener);
    }
}
