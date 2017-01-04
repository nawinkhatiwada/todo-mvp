package com.nawin.todo_mvp.auth.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nawin.todo_mvp.MVPBus;
import com.nawin.todo_mvp.R;
import com.nawin.todo_mvp.auth.AuthEvents;
import com.nawin.todo_mvp.databinding.FragmentLoginBinding;

/**
 * Created by nawin on 1/3/17.
 */

public class LoginFragment extends Fragment implements LoginContract.View {
    private FragmentLoginBinding loginBinding;
    private LoginContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        onSignUpClicked();
        return loginBinding.getRoot();
    }

    @Override
    public void showLoginProgress() {

    }

    @Override
    public void showLoginSuccess() {

    }

    @Override
    public void showLoginError() {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    private void onSignUpClicked() {
        loginBinding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              presenter.openRegister();
            }
        });

    }
}
