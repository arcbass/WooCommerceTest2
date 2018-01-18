package com.example.common.presenter;

import com.example.common.api.APIService;
import com.example.common.api.ServiceGenerator;
import com.example.common.interfaces.ICostumersView;
import com.example.common.model.Customer;

import java.util.List;

import rx.Scheduler;
import rx.Subscriber;

/**
 * Created by user on 18/01/2018.
 */

public class CustomerPresenter {

    ICostumersView mView;

    public CustomerPresenter(ICostumersView view) {
        this.mView = view;
    }

    public void getCustomers(Scheduler postThread, Scheduler subscribeThread){
        APIService service = ServiceGenerator.createService(APIService.class);

        service.getCustomers(ServiceGenerator.getAuthToken())
                .subscribeOn(subscribeThread)
                .observeOn(postThread)
                .subscribe(new Subscriber<List<Customer>>() {

                    @Override
                    public void onNext(List<Customer> customers) {
                        mView.showRepositories(customers);
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable t) {
                    }
                });

    }
}
