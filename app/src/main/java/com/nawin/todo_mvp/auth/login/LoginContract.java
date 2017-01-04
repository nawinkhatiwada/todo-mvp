package com.nawin.todo_mvp.auth.login;

import com.nawin.todo_mvp.BasePresenter;
import com.nawin.todo_mvp.BaseView;

/**
 * Created by nawin on 1/3/17.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void showLoginProgress();

        void showLoginSuccess();

        void showLoginError();
    }

    interface Presenter extends BasePresenter {
        void doLogin(String username, String password);
        void openRegister();
        void openMain();
    }
}
