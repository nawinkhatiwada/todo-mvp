package com.nawin.todo_mvp.main.recentproducts;

/**
 * Created by brain on 1/4/17.
 */

public class RecentProductsPresenter implements RecentProductsContract.Presenter {

    private RecentProductsContract.View view;

    public RecentProductsPresenter(RecentProductsContract.View view){
        this.view = view;
        view.setPresenter(this);
    }
    @Override
    public void start() {

    }

    @Override
    public void loadRecentProducts() {
        view.showLoadingProgress();
        view.showLoadingSuccess();
        view.showLoadingError();
    }
}
