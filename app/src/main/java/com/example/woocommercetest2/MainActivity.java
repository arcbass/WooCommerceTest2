package com.example.woocommercetest2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.common.interfaces.ICostumersView;
import com.example.common.model.Customer;
import com.example.common.presenter.CustomerPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements ICostumersView {

    private List<Customer> customersList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RepositoryAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.customer_recycle_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        CustomerPresenter customerPresenter = new CustomerPresenter(this);
        customerPresenter.getCustomers(AndroidSchedulers.mainThread(), Schedulers.io());

    }

    @Override
    public void showRepositories(List<Customer> allCostumers) {
        customersList = allCostumers;
        adapter = new RepositoryAdapter(customersList);
        recyclerView.setAdapter(adapter);

    }
}
