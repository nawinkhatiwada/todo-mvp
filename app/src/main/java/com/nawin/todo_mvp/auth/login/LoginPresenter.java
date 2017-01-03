package com.nawin.todo_mvp.auth.login;

/**
 * Created by nawin on 1/3/17.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void doLogin(String username, String password) {

    }

    @Override
    public void openRegister() {

    }
}
