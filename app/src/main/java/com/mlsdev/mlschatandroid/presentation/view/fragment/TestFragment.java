package com.mlsdev.mlschatandroid.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mlsdev.mlschatandroid.R;
import com.mlsdev.mlschatandroid.presentation.view.navigation.BackButtonListener;
import com.mlsdev.mlschatandroid.presentation.view.navigation.RouterProvider;
import com.mlsdev.mlschatandroid.presentation.view.navigation.Screens;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Router;

/**
 * Created by oleksandr on 05.05.17.
 */

public class TestFragment extends Fragment implements BackButtonListener {
    private static final String COUNTER_KEY = "counter_key";

    @BindView(R.id.text)
    TextView text;
    private Router router;

    public static TestFragment newInstance(String screenName) {
        screenName = screenName + " -- " + TestFragment.class.getSimpleName();
        Bundle args = new Bundle();
        args.putString(COUNTER_KEY, screenName);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment, container, false);
        ButterKnife.bind(this, view);
        router = ((RouterProvider) getParentFragment()).getRouter();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text.setText(getArguments().getString(COUNTER_KEY));
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                router.navigateTo(Screens.CHAT, getArguments().get(COUNTER_KEY));
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        router.exit();
        return true;
    }
}
