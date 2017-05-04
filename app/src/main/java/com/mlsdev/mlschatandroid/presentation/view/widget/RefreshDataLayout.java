package com.mlsdev.mlschatandroid.presentation.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mlsdev.mlschatandroid.R;
import com.mlsdev.mlschatandroid.presentation.view.widget.layoutprovider.DataViewProvider;

/**
 * Created by oleksandr on 04.05.17.
 */

public class RefreshDataLayout extends FrameLayout {
    private ViewGroup dataContainer;

    public RefreshDataLayout(Context context) {
        super(context);
        init(context);
    }

    public RefreshDataLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RefreshDataLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, 0);
    }

    private void init(Context context) {
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attrs) {
        init(context, attrs, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.layout_refresh_data_container, this, true);
        dataContainer = (ViewGroup) findViewById(R.id.data_container);
    }

    public void inflateDataView(DataViewProvider provider) {
        if (dataContainer != null) {
            dataContainer.removeAllViews();
            LayoutInflater.from(getContext()).inflate(provider.provideDataViewLayoutRes(), dataContainer, true);
        }
    }
}
