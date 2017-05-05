package com.mlsdev.mlschatandroid.presentation.view.fragment.tabs;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mlsdev.mlschatandroid.MLSChatApplication;
import com.mlsdev.mlschatandroid.R;
import com.mlsdev.mlschatandroid.presentation.view.fragment.TestFragment;
import com.mlsdev.mlschatandroid.presentation.view.fragment.tabs.base.BaseTabDataFragment;
import com.mlsdev.mlschatandroid.presentation.view.navigation.RouterProvider;
import com.mlsdev.mlschatandroid.presentation.view.navigation.Screens;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportAppNavigator;

/**
 * Created by oleksandr on 05.05.17.
 */

public class TabChatsFragment extends BaseTabDataFragment {
    private Navigator navigator;


    public static BaseTabDataFragment newInstance() {
        return new TabChatsFragment();
    }

    @Override
    protected String provideFragmentTag() {
        return Screens.CHATS;
    }

    @NonNull
    @Override
    public Cicerone<Router> getCicerone() {
        return MLSChatApplication.INSTANCE.getLocalCiceroneHolder().getCicerone(provideFragmentTag());
    }

    @NonNull
    @Override
    public Navigator getNavigator() {
        if (navigator == null) {
            navigator = new SupportAppNavigator(getActivity(), getChildFragmentManager(), R.id.inside_fragment_container) {

                @Override
                protected Intent createActivityIntent(String screenKey, Object data) {
//                    if (screenKey.equals(Screens.GITHUB_SCREEN)) {
//                        return new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/terrakok/Cicerone"));
//                    }
                    return null;
                }

                @Override
                protected Fragment createFragment(String screenKey, Object data) {
                    if (screenKey.equals(Screens.CHAT)) {
                        return TestFragment.newInstance((String) data);
                    }
                    return null;
                }

                @Override
                protected void exit() {
                    ((RouterProvider) getActivity()).getRouter().exit();
                }
            };
        }
        return navigator;
    }
}

