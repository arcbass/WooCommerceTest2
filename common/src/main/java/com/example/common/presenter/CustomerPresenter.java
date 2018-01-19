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
    APIService service = null;


    public CustomerPresenter(ICostumersView view) {

        this.mView = view;
        if(service == null){
            service = ServiceGenerator.createService(APIService.class);
        }
    }

    public void getCustomers(Scheduler postThread, Scheduler subscribeThread){

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

    public void postCustomer(Scheduler postThread, Scheduler subscribeThread, Customer customer) {
        service.postCustomer(ServiceGenerator.getAuthToken(), customer)
                .subscribeOn(subscribeThread)
                .observeOn(postThread)
                .subscribe(new Subscriber<Customer>() {

                    @Override
                    public void onNext(Customer customer) {
                        mView.postCustomer(customer);
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
