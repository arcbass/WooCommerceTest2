package com.example.woocommercetest2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.common.interfaces.ICostumersView;
import com.example.common.model.Customer;
import com.example.common.presenter.CustomerPresenter;
import com.example.woocommercetest2.R;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by NitroPc on 18/01/2018.
 */

public class POSTtab extends Fragment implements ICostumersView{

    private EditText username;
    private EditText email;
    private EditText password;
    private Customer customer;
    private CustomerPresenter customerPresenter;

    public POSTtab() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.post_fragment, container, false);

        username = (EditText) view.findViewById(R.id.post_username);
        email = (EditText) view.findViewById(R.id.post_email);
        password = (EditText) view.findViewById(R.id.post_password);
        customer = new Customer();
        customerPresenter = new CustomerPresenter(this);



        Button postBtn = (Button) view.findViewById(R.id.post_btn);

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sName = username.getText().toString();
                String sEmail = email.getText().toString();
                String sPass = password.getText().toString();

                if(!sName.equals("") && !sEmail.equals("") && !sPass.equals("")){
                    customer.setUsername(sName);
                    customer.setEmail(sEmail);
                    customer.setPassword(sPass);
                    customerPresenter.postCustomer(AndroidSchedulers.mainThread(), Schedulers.io(), customer);
                }
            }
        });


        return view;
    }

    @Override
    public void showRepositories(List<Customer> allCostumers) {

    }

    @Override
    public void postCustomer(Customer customer) {
        if (customer.getUsername().equals(this.customer.getUsername())){
            Toast.makeText(this.getContext(), "User POSTED", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.getContext(), "User not registred", Toast.LENGTH_SHORT).show();
        }


    }
}
