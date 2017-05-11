package com.example.vdiamant.emarketdiamantidisvasileios.Fragments;

import com.example.vdiamant.emarketdiamantidisvasileios.Controller.BackgroundTask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.vdiamant.emarketdiamantidisvasileios.Controller.BackgroundTask;
import com.example.vdiamant.emarketdiamantidisvasileios.R;

/**
 * Created by vdiamant on 8/5/2017.
 */

public class FragRegister extends android.app.Fragment {

    EditText etFirst,etLast,etMail,etPass,etRepass;
    String fname,lname,userMail,userPass,userReType;
    Button btnRegister;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.register,container,false);

        etFirst=(EditText)view.findViewById(R.id.ETregfirst);
        etLast=(EditText)view.findViewById(R.id.ETreglast);
        etMail=(EditText)view.findViewById(R.id.ETregmail);
        etPass=(EditText)view.findViewById(R.id.ETregPass);
        etRepass=(EditText)view.findViewById(R.id.ETregRetypePass);

        btnRegister=(Button)view.findViewById(R.id.btnregRegister);

        btnRegister.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        userRegistration();
                    }
                }
        );


        return view;
    }


    public void userRegistration(){
        fname=etFirst.getText().toString();
        lname=etLast.getText().toString();
        userMail=etMail.getText().toString();
        userPass=etPass.getText().toString();
        userReType=etRepass.getText().toString();

        String method="register";
        //edw isws einai lathos to getActivity!!
        BackgroundTask backgroundTask=new BackgroundTask(this.getActivity());
        backgroundTask.execute(method,fname,lname,userMail,userPass);

    }




}
