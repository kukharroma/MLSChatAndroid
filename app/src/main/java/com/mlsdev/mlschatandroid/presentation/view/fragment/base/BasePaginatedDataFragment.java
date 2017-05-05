package com.mlsdev.mlschatandroid.presentation.view.fragment.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mlsdev.mlschatandroid.R;
import com.mlsdev.mlschatandroid.presentation.presenter.base.BasePaginatedPresenter;
import com.mlsdev.mlschatandroid.presentation.presenter.view.PaginatedDataPView;
import com.mlsdev.mlschatandroid.presentation.view.listener.SimplePaginateListener;

import butterknife.BindView;

/**
 * Created by oleksandr on 03.05.17.
 */

public abstract class BasePaginatedDataFragment<P extends BasePaginatedPresenter<V, T>, V extends PaginatedDataPView<T>, T> extends BaseRefreshDataFragment<P, V> {

    @BindView(R.id.recycler_view)
    RecyclerView rvData;

    private SimplePaginateListener pageListener;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvData.setLayoutManager(provideLayoutManager());
        if (rvData.getAdapter() == null)
            rvData.setAdapter(provideAdapter());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (pageListener == null) {
            pageListener = new SimplePaginateListener(rvData.getLayoutManager()) {
                @Override
                public void onLoadMore(int page, int totalItemsCount) {
                    getPresenter().getData(false);
                }
            };
        }
        rvData.addOnScrollListener(pageListener);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (pageListener != null) {
            rvData.removeOnScrollListener(pageListener);
        }
    }

    @Override
    public int provideDataViewLayoutRes() {
        return R.layout.layout_recyclerview;
    }

    @NonNull
    protected abstract RecyclerView.Adapter provideAdapter();

    @NonNull
    protected abstract RecyclerView.LayoutManager provideLayoutManager();

}
