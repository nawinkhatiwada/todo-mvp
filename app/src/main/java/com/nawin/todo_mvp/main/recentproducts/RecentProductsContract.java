package com.nawin.todo_mvp.main.recentproducts;

import com.nawin.todo_mvp.BasePresenter;
import com.nawin.todo_mvp.BaseView;
import com.nawin.todo_mvp.data.models.RecentProducts;

import java.util.List;

/**
 * Created by brain on 1/4/17.
 */

public interface RecentProductsContract {

    interface View extends BaseView<Presenter> {
        void showLoadingProgress();

        void showLoadingSuccess();

        void showLoadingError();
    }

    interface Presenter extends BasePresenter,RecentProductsActionListener {

        void loadRecentProducts();

    }

    interface RecentProductsActionListener{
        void onRecentProductsSelected(RecentProducts products);
    }
}
