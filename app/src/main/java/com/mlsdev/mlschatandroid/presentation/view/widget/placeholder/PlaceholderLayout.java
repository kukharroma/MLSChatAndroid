package com.mlsdev.mlschatandroid.presentation.view.widget.placeholder;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.mlsdev.mlschatandroid.presentation.view.widget.layoutprovider.CustomPlaceholderProvider;

/**
 * Created by oleksandr on 04.05.17.
 */

public class PlaceholderLayout extends FrameLayout {

    private CustomPlaceholderProvider placeholderProvider;

    public PlaceholderLayout(Context context) {
        super(context);
        init(context);
    }

    public PlaceholderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PlaceholderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }


    private void init(Context context) {
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attrs) {
        init(context, attrs, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

    }

    private void setPlaceholderProvider(CustomPlaceholderProvider placeholderProvider) {
        this.placeholderProvider = placeholderProvider;
    }

    private void inflatePlaceholder(@LayoutRes int placeholderLayout) {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(placeholderLayout, this, true);
    }

    public void show(PlaceholderType type, CustomPlaceholderProvider placeholderProvider) {
        setPlaceholderProvider(placeholderProvider);
        switch (type) {
            case Empty:
            case NetworkError:
                inflatePlaceholder(type.getLayoutRes());
                break;
            case CustomPlaceholder:
                if (placeholderProvider != null)
                    inflatePlaceholder(this.placeholderProvider.providePlaceholderViewLayoutRes());
                break;
        }
        setVisibility(VISIBLE);
    }

    public void hide() {
        setVisibility(GONE);
    }
}
