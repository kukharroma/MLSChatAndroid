package com.mlsdev.mlschatandroid.presentation.view.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mlsdev.mlschatandroid.MLSChatApplication;
import com.mlsdev.mlschatandroid.R;
import com.mlsdev.mlschatandroid.presentation.view.navigation.BackButtonListener;

import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;

/**
 * Created by oleksandr on 03.05.17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideActivityLayout());
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MLSChatApplication.INSTANCE.getNavigatorHolder().setNavigator(provideNavigator());
    }

    @Override
    protected void onPause() {
        MLSChatApplication.INSTANCE.getNavigatorHolder().removeNavigator();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment != null
                && fragment instanceof BackButtonListener
                && ((BackButtonListener) fragment).onBackPressed()) {
            return;
        } else {
            MLSChatApplication.INSTANCE.getRouter().exit();
        }
    }

    @NonNull
    protected abstract Navigator provideNavigator();

    @LayoutRes
    protected abstract int provideActivityLayout();
}
