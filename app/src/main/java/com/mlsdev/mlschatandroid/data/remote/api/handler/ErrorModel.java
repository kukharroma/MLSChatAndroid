package com.mlsdev.mlschatandroid.data.remote.api.handler;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by oleksandr on 05.10.16.
 */

public class ErrorModel {
    @SerializedName("errors")
    @Expose
    private Map<String, List<String>> errorMap;

    public Map<String, List<String>> getErrorMap() {
        return errorMap;
    }

    public List<String> getErrorMessageListByKey(String key) {
        return errorMap.get(key);
    }
}
