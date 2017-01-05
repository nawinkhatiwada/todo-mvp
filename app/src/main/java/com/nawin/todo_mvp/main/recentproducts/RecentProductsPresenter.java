package com.nawin.todo_mvp.main.recentproducts;

import android.os.AsyncTask;

import com.nawin.todo_mvp.DataHolder;
import com.nawin.todo_mvp.data.models.RecentProducts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brain on 1/4/17.
 */

public class RecentProductsPresenter implements RecentProductsContract.Presenter {

    private RecentProductsContract.View view;

    public RecentProductsPresenter(RecentProductsContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void loadRecentProducts() {
        view.showLoadingProgress();

        new AsyncTask<Void, Void, List<RecentProducts>>() {

            @Override
            protected List<RecentProducts> doInBackground(Void... params) {
                try {
                    Thread.sleep(5000);
                    JSONObject jsonobject = new JSONObject(loadJSONFromAsset());
                    int status = jsonobject.getInt("status");
                    String statusMessage = jsonobject.getString("statusMessage");

                    if (status == DataHolder.STATUS &&
                            statusMessage.equalsIgnoreCase(DataHolder.SUCCESS)) {
                        List<RecentProducts> products = new ArrayList<>();

                        JSONArray jsonArray = jsonobject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = (JSONObject) jsonArray.get(i);
                            int id = object.getInt("productID");
                            String productName = object.getString("productName");
                            String productImage = object.getString("productImage");
                            products.add(new RecentProducts(id, productName, productImage));

                        }
                        return products;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<RecentProducts> recentProducts) {
                if (recentProducts != null) {
                    view.showRecentProducts(recentProducts);
                } else {
                    view.showLoadingError();
                }

            }
        }.execute();

    }

    @Override
    public void onRecentProductsSelected(RecentProducts products, int position) {
        view.showToastMessage(position);
    }


    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream inputStream = view.getContext().getAssets().open("products.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}
