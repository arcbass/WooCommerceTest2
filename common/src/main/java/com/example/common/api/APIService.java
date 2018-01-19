package com.example.common.api;

import com.example.common.model.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by user on 18/01/2018.
 */

public interface APIService {
    @GET("/wp-json/wc/v2/customers")
    Observable<List<Customer>> getCustomers(
            @Header("Authorization") String authKey
    );

    @GET("/wp-json/wc/v2/customers/{id}")
    Call<Customer> getCustomer (
            @Path("id") long id
    );

    @POST("/posts")
    Observable<Customer> postCustomer(
            @Header("Authorization") String authKey,
            @Body Customer customer);
}
