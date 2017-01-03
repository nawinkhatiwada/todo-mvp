package com.nawin.todo_mvp.auth;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.nawin.todo_mvp.MVPBus;
import com.nawin.todo_mvp.R;
import com.nawin.todo_mvp.auth.login.LoginContract;
import com.nawin.todo_mvp.auth.login.LoginFragment;
import com.nawin.todo_mvp.auth.login.LoginPresenter;
import com.nawin.todo_mvp.auth.signup.SignupContract;
import com.nawin.todo_mvp.auth.signup.SignupFragment;
import com.nawin.todo_mvp.auth.signup.SignupPresenter;
import com.nawin.todo_mvp.databinding.ActivityAuthBinding;
import com.squareup.otto.Subscribe;

public class AuthActivity extends AppCompatActivity  {
    ActivityAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth);
        setSupportActionBar(binding.toolbar);

        requestLogin(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MVPBus.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MVPBus.getInstance().unregister(this);
    }

    @Subscribe
    public void requestLogin(AuthEvents.LoginRequest events) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mainContainer);
        if (fragment == null || !(fragment instanceof LoginFragment)) {
            fragment = new LoginFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment)
                    .commit();
        }
        new LoginPresenter((LoginContract.View) fragment);
    }

    @Subscribe
    public void requestSignUp(AuthEvents.SignupRequest events) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mainContainer);
        if (fragment == null || !(fragment instanceof SignupFragment)) {
            fragment = new SignupFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment)
                    .commit();
        }
        new SignupPresenter((SignupContract.View) fragment);
    }
}
