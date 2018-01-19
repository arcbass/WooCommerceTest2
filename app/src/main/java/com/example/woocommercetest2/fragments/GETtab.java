package com.example.woocommercetest2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.common.interfaces.ICostumersView;
import com.example.common.model.Customer;
import com.example.common.presenter.CustomerPresenter;
import com.example.woocommercetest2.R;
import com.example.woocommercetest2.RepositoryAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by NitroPc on 18/01/2018.
 */

public class GETtab extends Fragment  implements ICostumersView {

    private List<Customer> customersList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RepositoryAdapter adapter;

    public GETtab() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.get_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.customer_recycle_view);
        layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        CustomerPresenter customerPresenter = new CustomerPresenter(this);
        customerPresenter.getCustomers(AndroidSchedulers.mainThread(), Schedulers.io());


        return view;
    }

    @Override
    public void showRepositories(List<Customer> allCostumers) {
        customersList = allCostumers;
        adapter = new RepositoryAdapter(customersList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void postCustomer(Customer customer) {}
}
