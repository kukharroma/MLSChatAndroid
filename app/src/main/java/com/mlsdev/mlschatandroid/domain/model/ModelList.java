package com.mlsdev.mlschatandroid.domain.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleksandr on 05.05.17.
 */

public class ModelList<T> implements Serializable {
    @SerializedName("collection")
    public List<T> data = new ArrayList<>();
    @SerializedName("total_pages")
    private int totalPages = 1;
    @SerializedName("current_page")
    private int currentPage = 0;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean hasNextPage() {
        return currentPage < totalPages;
    }

    public void add(ModelList<T> modelList) {
        data.addAll(modelList.getData());
        currentPage = modelList.getCurrentPage();
        totalPages = modelList.getTotalPages();
    }

    public void reset() {
        data.clear();
        totalPages = 1;
        currentPage = 0;
    }
}
