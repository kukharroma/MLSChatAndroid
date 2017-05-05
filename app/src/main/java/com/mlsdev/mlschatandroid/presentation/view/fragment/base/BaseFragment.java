package com.mlsdev.mlschatandroid.presentation.view.fragment.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mlsdev.mlschatandroid.MLSChatApplication;
import com.mlsdev.mlschatandroid.R;
import com.mlsdev.mlschatandroid.presentation.presenter.base.BasePresenter;
import com.mlsdev.mlschatandroid.presentation.presenter.view.PView;
import com.mlsdev.mlschatandroid.presentation.view.navigation.BackButtonListener;

import net.grandcentrix.thirtyinch.TiFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by oleksandr on 03.05.17.
 */

public abstract class BaseFragment<P extends BasePresenter<V>, V extends PView> extends TiFragment<P, V> implements PView{
    private static final String EXTRA_NAME = "tcf_extra_name";
    private Unbinder unbinder;

    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(provideFragmentLayoutRes(), container, false);
        unbinder = ButterKnife.bind(this, view);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getString(R.string.wait));
        progressDialog.setCancelable(false);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }


    @LayoutRes
    protected abstract int provideFragmentLayoutRes();
}
