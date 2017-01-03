package com.nawin.todo_mvp.auth.signup;

import com.nawin.todo_mvp.BasePresenter;
import com.nawin.todo_mvp.BaseView;

/**
 * Created by nawin on 1/3/17.
 */

public interface SignupContract {

    interface View extends BaseView<Presenter> {
        void showRegisterProgress();
        void showRegisterSuccess();
        void showRegisterError();
    }

    interface Presenter extends BasePresenter {
        void doRegister(String name, String email, String password);
    }
}
