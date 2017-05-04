package com.mlsdev.mlschatandroid.data.remote;

import com.mlsdev.mlschatandroid.data.UsersDataSource;
import com.mlsdev.mlschatandroid.domain.model.User;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by oleksandr on 03.05.17.
 */

public class RemoteUsersDataSource implements UsersDataSource {

    @Override
    public Flowable<List<User>> getUsersList(int page) {
        return null;
    }

    @Override
    public Flowable<List<User>> getContacts(int page) {
        return null;
    }

    @Override
    public void addToContacts(long userId) {

    }

    @Override
    public void removeFromContacts(long userId) {

    }

    @Override
    public Flowable<User> getUser(long userId) {
        return null;
    }
}
