package com.mlsdev.mlschatandroid.data.remote.api.handler;

import android.util.Log;

import com.google.gson.Gson;

/**
 * Created by oleksandr on 05.10.16.
 */

public class ErrorModelParser {
    public static ErrorModel parse(String jsonString) {
        ErrorModel errorModel = null;
        Gson gson = new Gson();
        try {
            errorModel = gson.fromJson(jsonString, ErrorModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return errorModel;
    }
}
