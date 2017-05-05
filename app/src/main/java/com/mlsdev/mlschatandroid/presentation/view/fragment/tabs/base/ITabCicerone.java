package com.mlsdev.mlschatandroid.presentation.view.fragment.tabs.base;

import android.support.annotation.NonNull;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;

/**
 * Created by oleksandr on 05.05.17.
 */

public interface ITabCicerone {
    @NonNull
    Cicerone<Router> getCicerone();

    @NonNull
    Navigator getNavigator();
}
