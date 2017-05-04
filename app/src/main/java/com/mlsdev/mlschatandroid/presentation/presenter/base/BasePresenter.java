package com.mlsdev.mlschatandroid.presentation.presenter.base;

import com.mlsdev.mlschatandroid.presentation.presenter.view.PView;

import net.grandcentrix.thirtyinch.TiConfiguration;
import net.grandcentrix.thirtyinch.TiPresenter;

/**
 * Created by oleksandr on 03.05.17.
 */

public abstract class BasePresenter<V extends PView> extends TiPresenter<V> {

    public static final TiConfiguration PRESENTER_CONFIG =
            new TiConfiguration.Builder()
                    .setRetainPresenterEnabled(true)
                    .setUseStaticSaviorToRetain(true)
                    .setCallOnMainThreadInterceptorEnabled(true)
                    .setDistinctUntilChangedInterceptorEnabled(true)
                    .build();

    public BasePresenter() {
        super(PRESENTER_CONFIG);
    }

    public abstract void refreshData();
}
