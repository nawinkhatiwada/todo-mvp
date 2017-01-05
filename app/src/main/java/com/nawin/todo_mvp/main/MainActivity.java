package com.nawin.todo_mvp.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.nawin.todo_mvp.MVPBus;
import com.nawin.todo_mvp.R;
import com.nawin.todo_mvp.databinding.ActivityMainBinding;
import com.nawin.todo_mvp.main.recentproducts.RecentProductsContract;
import com.nawin.todo_mvp.main.recentproducts.RecentProductsFragment;
import com.nawin.todo_mvp.main.recentproducts.RecentProductsPresenter;
import com.squareup.otto.Subscribe;

/**
 * Created by brain on 1/4/17.
 */

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(mainBinding.toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayShowTitleEnabled(true);
        }
        requestRecentProductFragment(null);
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
    public void requestRecentProductFragment(MainEvents.RecentProductFragmentRequest events) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment == null || !(fragment instanceof RecentProductsFragment)) {
            fragment = new RecentProductsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                    .commit();
        }
        new RecentProductsPresenter((RecentProductsContract.View) fragment);
    }
}
