package com.mlsdev.mlschatandroid.presentation.presenter.tabs;

import com.mlsdev.mlschatandroid.domain.model.User;
import com.mlsdev.mlschatandroid.presentation.presenter.base.BasePaginatedPresenter;
import com.mlsdev.mlschatandroid.presentation.presenter.view.tabs.ContactsScreenView;

/**
 * Created by oleksandr on 05.05.17.
 */

public class ContactsPresenter extends BasePaginatedPresenter<ContactsScreenView, User> {

    @Override
    public void getData(boolean isRefreshing) {

    }
}
