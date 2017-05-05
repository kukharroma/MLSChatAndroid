package com.mlsdev.mlschatandroid.data.remote.api.contract;

import com.mlsdev.mlschatandroid.domain.model.ModelList;
import com.mlsdev.mlschatandroid.domain.model.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by oleksandr on 03.05.17.
 */

public interface UsersAPIContract {

    @GET(APIUrls.User.GET_USER_BY_ID)
    Observable<User> getUser(@Path("id") long id);

    @GET(APIUrls.User.GET_ALL_USERS)
    Observable<ModelList<User>> getUsers();
}
