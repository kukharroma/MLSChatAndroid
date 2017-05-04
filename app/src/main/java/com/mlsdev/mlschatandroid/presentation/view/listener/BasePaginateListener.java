package com.mlsdev.mlschatandroid.presentation.view.listener;

import android.support.v7.widget.RecyclerView;

/**
 * Created by oleksandr on 07.10.16.
 */

public abstract class BasePaginateListener extends RecyclerView.OnScrollListener {
    // The minimum amount of items to have above your current scroll position
    // before mLoading more.
    protected int mVisibleThreshold = 5;
    // The current offset index of data you have loaded
    protected int mCurrentPage = 1;
    // The total number of items in the dataset after the last load
    protected int mPreviousTotalItemCount = 0;
    // True if we are still waiting for the last set of data to load.
    protected boolean mLoading = true;
    // Sets the starting page index
    protected int mStartingPageIndex = 1;
    protected RecyclerView.LayoutManager mLayoutManager;

    public BasePaginateListener(RecyclerView.LayoutManager linearLayoutManager) {
        mLayoutManager = linearLayoutManager;
    }


    public void refreshPage() {
        mCurrentPage = 1;
        mPreviousTotalItemCount = 0;
        mLoading = false;
    }

    // Defines the process for actually mLoading more data based on page
    public abstract void onLoadMore(int page, int totalItemsCount);
}