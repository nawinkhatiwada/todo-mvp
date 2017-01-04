package com.nawin.todo_mvp.main.recentproducts;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nawin.todo_mvp.R;
import com.nawin.todo_mvp.databinding.FragmentRecentProductsBinding;

/**
 * Created by brain on 1/4/17.
 */

public class RecentProductsFragment extends Fragment implements RecentProductsContract.View {

    private FragmentRecentProductsBinding recentProductsBinding;
    private RecentProductsContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recentProductsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_recent_products, container, false);
        return recentProductsBinding.getRoot();
    }

    @Override
    public void showLoadingProgress() {

    }

    @Override
    public void showLoadingSuccess() {
        presenter.loadRecentProducts();
    }

    @Override
    public void showLoadingError() {

    }

    @Override
    public void setPresenter(RecentProductsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
