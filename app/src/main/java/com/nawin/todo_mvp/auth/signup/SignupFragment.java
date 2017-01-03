package com.nawin.todo_mvp.auth.signup;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nawin.todo_mvp.R;
import com.nawin.todo_mvp.databinding.FragmentSignupBinding;

/**
 * Created by nawin on 1/3/17.
 */

public class SignupFragment extends Fragment implements SignupContract.View {
    private FragmentSignupBinding signUpBinding;
    private SignupContract.Presenter presenter;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        signUpBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false);
        onSignUpClicked();
        return signUpBinding.getRoot();
    }

    @Override
    public void showRegisterProgress() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    public void showRegisterSuccess() {
        progressDialog.dismiss();
        Toast.makeText(getActivity(),"Sign Up Success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showRegisterError() {
        progressDialog.dismiss();
        Toast.makeText(getActivity(),"Sign Up Error",Toast.LENGTH_LONG).show();

    }

    @Override
    public void setPresenter(SignupContract.Presenter presenter) {
        this.presenter = presenter;
    }

    private void onSignUpClicked() {
        presenter.doRegister("a", "b", "c");
    }
}
