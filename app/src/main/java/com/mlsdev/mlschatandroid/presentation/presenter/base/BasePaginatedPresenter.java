package com.mlsdev.mlschatandroid.presentation.presenter.base;

import com.mlsdev.mlschatandroid.presentation.presenter.view.PaginatedDataPView;

/**
 * Created by oleksandr on 04.05.17.
 */

public abstract class BasePaginatedPresenter<V extends PaginatedDataPView<T>, T> extends BasePresenter<V> {

    public abstract void getData(boolean isRefreshing);

    @Override
    public void refreshData() {
        getData(true);
    }
}
