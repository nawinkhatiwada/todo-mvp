package com.nawin.todo_mvp.auth.signup;

import android.os.AsyncTask;

import java.util.Random;

/**
 * Created by nawin on 1/3/17.
 */

public class SignupPresenter implements SignupContract.Presenter {
    private SignupContract.View view;

    public SignupPresenter(SignupContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void doRegister(String name, String email, String password) {
        view.showRegisterProgress();
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
                    view.showRegisterError();
                } else {
                    view.showRegisterSuccess();
                }
            }
        }.execute();
    }

    @Override
    public void start() {

    }
}
