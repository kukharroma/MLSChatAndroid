package com.mlsdev.mlschatandroid.presentation.presenter.view;

import com.mlsdev.mlschatandroid.presentation.view.widget.placeholder.PlaceholderType;

import net.grandcentrix.thirtyinch.TiView;

/**
 * Created by oleksandr on 03.05.17.
 */

public interface PView extends TiView {
    void showErrorMessage(String errorMessage);

    void showProgress();

    void hideProgress();

    void showPlaceholder(PlaceholderType type);

    void hidePlaceholder();
}
