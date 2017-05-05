package com.mlsdev.mlschatandroid.data.remote.api.contract;

/**
 * Created by oleksandr on 04.05.17.
 */

public interface APIUrls {

    interface User {
        String GET_USER_BY_ID = "/users/{id}";
        String GET_ALL_USERS = "/users";
    }

    interface Profile {
        String PROFILE = "/profile";
    }

    interface Session {
        String SESSION = "/session";
        String FACEBOOK_SESSION = "/facebook/session";
    }

    interface Recovery {
        String RECOVERY = "/recovery";
    }

    interface Chats {
        String MESSAGE = "/chats/{id}/messages";
        String CHAT = "/chats/{id}";
        String CHATS = "/chats";
    }
}
