package com.mlsdev.mlschatandroid.data;

import android.support.annotation.NonNull;

import com.mlsdev.mlschatandroid.domain.model.User;

import java.util.List;

import io.reactivex.Flowable;


/**
 * Created by oleksandr on 03.05.17.
 */

public interface UsersDataSource {

    Flowable<List<User>> getUsersList(int page);

    Flowable<List<User>> getContacts(int page);

    void addToContacts(long userId);

    void removeFromContacts(long userId);

    Flowable<User> getUser(long userId);
}
