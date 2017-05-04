package com.mlsdev.mlschatandroid.presentation.view.widget.placeholder;

import android.support.annotation.LayoutRes;

import com.mlsdev.mlschatandroid.R;

/**
 * Created by oleksandr on 04.05.17.
 */

public enum PlaceholderType {

    Empty(R.layout.placeholder_empty_data), NetworkError(R.layout.placeholder_empty_data), CustomPlaceholder(-1);

    PlaceholderType(int layoutRes) {
        this.layoutRes = layoutRes;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    @LayoutRes
    int layoutRes;
}
