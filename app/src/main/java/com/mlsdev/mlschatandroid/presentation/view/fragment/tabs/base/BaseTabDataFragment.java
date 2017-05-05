package com.mlsdev.mlschatandroid.presentation.view.fragment.tabs.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mlsdev.mlschatandroid.R;
import com.mlsdev.mlschatandroid.presentation.view.navigation.BackButtonListener;
import com.mlsdev.mlschatandroid.presentation.view.navigation.RouterProvider;
import com.mlsdev.mlschatandroid.presentation.view.navigation.Screens;

import ru.terrakok.cicerone.Router;

/**
 * Created by oleksandr on 05.05.17.
 */

public abstract class BaseTabDataFragment extends Fragment implements ITabCicerone, BackButtonListener, RouterProvider {


    protected abstract String provideFragmentTag();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getChildFragmentManager().findFragmentById(R.id.inside_fragment_container) == null) {
            getCicerone().getRouter().replaceScreen(Screens.CHAT, BaseTabDataFragment.class.getSimpleName());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getCicerone().getNavigatorHolder().setNavigator(getNavigator());
    }

    @Override
    public void onPause() {
        getCicerone().getNavigatorHolder().removeNavigator();
        super.onPause();
    }


    @Override
    public boolean onBackPressed() {
        Fragment fragment = getChildFragmentManager().findFragmentById(R.id.inside_fragment_container);
        if (fragment != null
                && fragment instanceof BackButtonListener
                && ((BackButtonListener) fragment).onBackPressed()) {
            return true;
        } else {
            ((RouterProvider) getActivity()).getRouter().exit();
            return true;
        }
    }

    @Override
    public Router getRouter() {
        return getCicerone().getRouter();
    }
}
