package com.nawin.todo_mvp.main.recentproducts;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nawin.todo_mvp.R;
import com.nawin.todo_mvp.data.models.RecentProducts;
import com.nawin.todo_mvp.databinding.ListItemRecentProductsBinding;

import java.util.List;

/**
 * Created by brain on 1/5/17.
 */

public class RecentProductsAdapter extends RecyclerView.Adapter<RecentProductsAdapter.RecentProductsHolder> {

    private List<RecentProducts> products;
    private RecentProductsContract.RecentProductsActionListener listener;

    RecentProductsAdapter(List<RecentProducts> products, RecentProductsContract.RecentProductsActionListener listener) {
        this.products = products;
        this.listener = listener;
    }

    @Override
    public RecentProductsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemRecentProductsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item_recent_products, parent, false);
        return new RecentProductsHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecentProductsHolder holder, final int position) {
        holder.binding.setRecentProduct(products.get(position));
        holder.binding.cardProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecentProductsSelected(products.get(position),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class RecentProductsHolder extends RecyclerView.ViewHolder {
        private final ListItemRecentProductsBinding binding;

        public RecentProductsHolder(ListItemRecentProductsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
