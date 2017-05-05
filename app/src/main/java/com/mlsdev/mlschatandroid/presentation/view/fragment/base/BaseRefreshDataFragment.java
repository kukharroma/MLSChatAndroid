package com.mlsdev.mlschatandroid.presentation.view.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.mlsdev.mlschatandroid.R;
import com.mlsdev.mlschatandroid.presentation.presenter.base.BasePresenter;
import com.mlsdev.mlschatandroid.presentation.presenter.view.PView;
import com.mlsdev.mlschatandroid.presentation.view.widget.RefreshDataLayout;
import com.mlsdev.mlschatandroid.presentation.view.widget.layoutprovider.CustomPlaceholderProvider;
import com.mlsdev.mlschatandroid.presentation.view.widget.layoutprovider.DataViewProvider;
import com.mlsdev.mlschatandroid.presentation.view.widget.placeholder.PlaceholderLayout;
import com.mlsdev.mlschatandroid.presentation.view.widget.placeholder.PlaceholderType;

import butterknife.BindView;

/**
 * Created by oleksandr on 04.05.17.
 */

public abstract class BaseRefreshDataFragment<P extends BasePresenter<V>, V extends PView> extends BaseFragment<P, V> implements CustomPlaceholderProvider, DataViewProvider, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.refresh_layout)
    protected SwipeRefreshLayout refreshLayout;
    @BindView(R.id.refresh_data_layout)
    protected RefreshDataLayout refreshDataLayout;
    @BindView(R.id.placeholder)
    protected PlaceholderLayout placeholder;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshDataLayout.inflateDataView(this);
        refreshLayout.setOnRefreshListener(this);
    }


    @Override
    public void showPlaceholder(PlaceholderType type) {
        placeholder.show(type, this);
    }

    @Override
    public void hidePlaceholder() {
        placeholder.hide();
    }

    @Override
    protected int provideFragmentLayoutRes() {
        return R.layout.fragment_refresh_data;
    }

    @Override
    public void onRefresh() {
        getPresenter().refreshData();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (refreshLayout != null) {
            refreshLayout.setRefreshing(false);
            refreshLayout.destroyDrawingCache();
            refreshLayout.clearAnimation();
        }
    }
}
