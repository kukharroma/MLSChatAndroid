package com.mlsdev.mlschatandroid.presentation.presenter.view;

import java.util.List;

/**
 * Created by oleksandr on 03.05.17.
 */

public interface PaginatedDataPView<T> extends PView {
    void showData(List<T> data);
}
