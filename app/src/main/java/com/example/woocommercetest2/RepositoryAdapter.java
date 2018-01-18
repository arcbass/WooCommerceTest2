package com.example.woocommercetest2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.common.model.Customer;

import java.util.List;

/**
 * Created by user on 18/01/2018.
 */

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    private List<Customer> customersList;


    public RepositoryAdapter(List<Customer> customersList){
        this.customersList = customersList;
    }

    @Override
    public RepositoryAdapter.RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_row, parent, false);

        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoryAdapter.RepositoryViewHolder holder, int position) {
        holder.text.setText(customersList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return customersList.size();
    }


    public class RepositoryViewHolder extends RecyclerView.ViewHolder{

        public TextView text;

        public RepositoryViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.titleTextView);

        }
    }
}
