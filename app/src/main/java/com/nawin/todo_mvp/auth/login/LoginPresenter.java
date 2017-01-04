package com.nawin.todo_mvp.auth.login;

import android.os.AsyncTask;

import com.nawin.todo_mvp.MVPBus;
import com.nawin.todo_mvp.auth.AuthEvents;

import java.util.Random;

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
        view.showLoginProgress();
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Random random = new Random();
                int num = random.nextInt(100);
                if (num < 30) {
                    view.showLoginError();
                } else {
                    view.showLoginSuccess();
                }
            }
        }.execute();
    }

    @Override
    public void openRegister() {
        MVPBus.getInstance().post(new AuthEvents.SignupRequest());
    }

    @Override
    public void openMain() {
        MVPBus.getInstance().post(new AuthEvents.LoginSuccess());    }
}
