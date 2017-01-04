package com.nawin.todo_mvp.main.recentproducts;

import com.nawin.todo_mvp.BasePresenter;
import com.nawin.todo_mvp.BaseView;

/**
 * Created by brain on 1/4/17.
 */

public interface RecentProductsContract {

    interface View extends BaseView<Presenter> {
        void showLoadingProgress();

        void showLoadingSuccess();

        void showLoadingError();
    }

    interface Presenter extends BasePresenter {

        void loadRecentProducts();

    }
}
