package com.example.common.api;

import java.io.UnsupportedEncodingException;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 18/01/2018.
 */

public class ServiceGenerator {

    private static final String BASE_URL = "https://arnaurigol.000webhostapp.com/";
    private static final String API_USER_NAME = "ck_74eaefb27b49ba2f5410cabaf1e6d89824151aa2";
    private static final String API_PASSWORD = "cs_37857687a9120e1ccf4506bb98f6dfa567804752";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

    public static String getAuthToken() {
        byte[] data = new byte[0];
        try {
            data = (API_USER_NAME + ":" + API_PASSWORD).getBytes("UTF-8");
            String result = "Basic " + new String(data, "UTF-8");


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //no funciona. solucion temporal
        return "Basic Y2tfNzRlYWVmYjI3YjQ5YmEyZjU0MTBjYWJhZjFlNmQ4OTgyNDE1MWFhMjpjc18zNzg1NzY4N2E5MTIwZTFjY2Y0NTA2YmI5OGY2ZGZhNTY3ODA0NzUy";

    }
}
