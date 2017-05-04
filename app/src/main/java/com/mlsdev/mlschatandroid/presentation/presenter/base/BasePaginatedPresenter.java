package com.mlsdev.mlschatandroid.presentation.presenter.base;

import com.mlsdev.mlschatandroid.presentation.presenter.view.PaginatedDataView;

/**
 * Created by oleksandr on 04.05.17.
 */

public abstract class BasePaginatedPresenter<V extends PaginatedDataView<T>, T> extends BasePresenter<V> {

    @Override
    void refreshData() {
        getData(true);
    }

    public abstract void getData(boolean isRefreshing);
}
