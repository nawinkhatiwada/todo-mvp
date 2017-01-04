package com.nawin.todo_mvp.auth.login;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
    private ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        onSignUpClicked();
        onLoginClicked();
        return loginBinding.getRoot();
    }

    @Override
    public void showLoginProgress() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void showLoginSuccess() {
        progressDialog.dismiss();
        Toast.makeText(getActivity(), "Login Success", Toast.LENGTH_LONG).show();
        presenter.openMain();
    }

    @Override
    public void showLoginError() {
        progressDialog.dismiss();
        Toast.makeText(getActivity(), "Cannot Login", Toast.LENGTH_LONG).show();
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

    private void onLoginClicked(){
        loginBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doLogin("a","a");
            }
        });
    }
}
