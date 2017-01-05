package com.nawin.todo_mvp.main.recentproducts;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nawin.todo_mvp.R;
import com.nawin.todo_mvp.data.models.RecentProducts;
import com.nawin.todo_mvp.databinding.FragmentRecentProductsBinding;

import java.util.List;

/**
 * Created by brain on 1/4/17.
 */

public class RecentProductsFragment extends Fragment implements RecentProductsContract.View {

    private FragmentRecentProductsBinding recentProductsBinding;
    private RecentProductsContract.Presenter presenter;
    private ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recentProductsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_recent_products, container, false);
        recentProductsBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.loadRecentProducts();
        return recentProductsBinding.getRoot();
    }

    @Override
    public void showLoadingProgress() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void showRecentProducts(List<RecentProducts> products) {
        progressDialog.dismiss();
        recentProductsBinding.recyclerView.setAdapter(new RecentProductsAdapter(products, presenter));
    }

    @Override
    public void showLoadingError() {
        progressDialog.dismiss();
    }

    @Override
    public void setPresenter(RecentProductsContract.Presenter presenter) {
        this.presenter = presenter;
    }

}
