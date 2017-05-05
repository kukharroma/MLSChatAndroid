package com.mlsdev.mlschatandroid;

import android.app.Application;

import com.mlsdev.mlschatandroid.presentation.view.navigation.LocalCiceroneHolder;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by oleksandr on 04.05.17.
 */

public class MLSChatApplication extends Application {

    LocalCiceroneHolder ciceroneHolder;
    Cicerone<Router> cicerone;
    public static MLSChatApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initCicerone();
    }

    private void initCicerone() {
        cicerone = Cicerone.create();
        ciceroneHolder = new LocalCiceroneHolder();
    }

    public LocalCiceroneHolder getLocalCiceroneHolder() {
        return ciceroneHolder;
    }

    public NavigatorHolder getNavigatorHolder(String tag) {
        return ciceroneHolder.getCicerone(tag).getNavigatorHolder();
    }

    public Router getRouter(String tag) {
        return ciceroneHolder.getCicerone(tag).getRouter();
    }

    public Router getRouter() {
        return cicerone.getRouter();
    }

    public NavigatorHolder getNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }
}
