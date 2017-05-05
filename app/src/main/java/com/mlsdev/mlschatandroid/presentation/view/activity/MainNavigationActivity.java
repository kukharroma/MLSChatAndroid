package com.mlsdev.mlschatandroid.presentation.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.mlsdev.mlschatandroid.MLSChatApplication;
import com.mlsdev.mlschatandroid.R;
import com.mlsdev.mlschatandroid.presentation.view.fragment.tabs.TabChatsFragment;
import com.mlsdev.mlschatandroid.presentation.view.fragment.tabs.TabContactsFragment;
import com.mlsdev.mlschatandroid.presentation.view.fragment.tabs.TabProfileFragment;
import com.mlsdev.mlschatandroid.presentation.view.fragment.tabs.base.BaseTabDataFragment;
import com.mlsdev.mlschatandroid.presentation.view.navigation.BackButtonListener;
import com.mlsdev.mlschatandroid.presentation.view.navigation.RouterProvider;
import com.mlsdev.mlschatandroid.presentation.view.navigation.Screens;

import butterknife.BindView;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.commands.Back;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;
import ru.terrakok.cicerone.commands.SystemMessage;

/**
 * Created by oleksandr on 04.05.17.
 */

public class MainNavigationActivity extends BaseActivity implements RouterProvider {

    private static final int PROFILE_TAB_POSITION = 0;
    private static final int CONTACTS_TAB_POSITION = 1;
    private static final int CHATS_TAB_POSITION = 2;

    BaseTabDataFragment profileFragment;
    BaseTabDataFragment contactsFragment;
    BaseTabDataFragment chatsFragment;

    @BindView(R.id.ab_bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initContainers();
        if (savedInstanceState == null) {
            bottomNavigationBar.selectTab(PROFILE_TAB_POSITION, true);
        }
    }

    private void initViews() {
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.profile))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.contacts))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.chats))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case PROFILE_TAB_POSITION:
                        highlightTab(PROFILE_TAB_POSITION);
                        getRouter().replaceScreen(Screens.PROFILE);
                        break;
                    case CONTACTS_TAB_POSITION:
                        highlightTab(CONTACTS_TAB_POSITION);
                        getRouter().replaceScreen(Screens.CONTACTS);
                        break;
                    case CHATS_TAB_POSITION:
                        highlightTab(CHATS_TAB_POSITION);
                        getRouter().replaceScreen(Screens.CHATS);
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                onTabSelected(position);
            }
        });

    }

    private void initContainers() {
        FragmentManager fm = getSupportFragmentManager();
        profileFragment = (BaseTabDataFragment) fm.findFragmentByTag(Screens.PROFILE);
        if (profileFragment == null) {
            profileFragment = TabProfileFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.fragment_container, profileFragment, Screens.PROFILE)
                    .detach(profileFragment).commitNow();
        }

        contactsFragment = (BaseTabDataFragment) fm.findFragmentByTag(Screens.CONTACTS);
        if (contactsFragment == null) {
            contactsFragment = TabContactsFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.fragment_container, contactsFragment, Screens.CONTACTS)
                    .detach(contactsFragment).commitNow();
        }

        chatsFragment = (BaseTabDataFragment) fm.findFragmentByTag(Screens.CHATS);
        if (chatsFragment == null) {
            chatsFragment = TabChatsFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.fragment_container, chatsFragment, Screens.CHATS)
                    .detach(chatsFragment).commitNow();
        }
    }

    public void highlightTab(int position) {
        bottomNavigationBar.selectTab(position, false);
    }

    @NonNull
    @Override
    protected Navigator provideNavigator() {
        return navigator;
    }

    @Override
    protected int provideActivityLayout() {
        return R.layout.activity_main;
    }

    private Navigator navigator = new Navigator() {
        @Override
        public void applyCommand(Command command) {
            if (command instanceof Back) {
                finish();
            } else if (command instanceof SystemMessage) {
                Toast.makeText(MainNavigationActivity.this, ((SystemMessage) command).getMessage(), Toast.LENGTH_SHORT).show();
            } else if (command instanceof Replace) {
                FragmentManager fm = getSupportFragmentManager();

                switch (((Replace) command).getScreenKey()) {
                    case Screens.PROFILE:
                        fm.beginTransaction()
                                .detach(chatsFragment)
                                .detach(contactsFragment)
                                .attach(profileFragment)
                                .commitNow();
                        break;
                    case Screens.CHATS:
                        fm.beginTransaction()
                                .detach(profileFragment)
                                .detach(contactsFragment)
                                .attach(chatsFragment)
                                .commitNow();
                        break;
                    case Screens.CONTACTS:
                        fm.beginTransaction()
                                .detach(profileFragment)
                                .detach(chatsFragment)
                                .attach(contactsFragment)
                                .commitNow();
                        break;
                }
            }
        }
    };

    @Override
    public Router getRouter() {
        return MLSChatApplication.INSTANCE.getRouter();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment != null
                && fragment instanceof BackButtonListener
                && ((BackButtonListener) fragment).onBackPressed()) {
            return;
        } else {
            getRouter().exit();
        }
    }
}
