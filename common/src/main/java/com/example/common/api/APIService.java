package com.example.common.api;

import com.example.common.model.Customer;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

/**
 * Created by user on 18/01/2018.
 */

public interface APIService {
    @GET("/wp-json/wc/v2/customers")
    Observable<List<Customer>> getCustomers(
            @Header("Authorization") String authKey
    );
}
