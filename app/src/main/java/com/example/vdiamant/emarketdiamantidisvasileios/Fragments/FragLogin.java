package com.example.vdiamant.emarketdiamantidisvasileios.Fragments;

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

public class FragLogin extends android.app.Fragment {

    EditText etLoginMail,etLoginPass;
    Button btnLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.login,container,false);
        etLoginMail=(EditText)view.findViewById(R.id.loginETEmail);
        etLoginPass=(EditText)view.findViewById(R.id.loginETPassword);
        btnLogin=(Button)view.findViewById(R.id.loginBtnLogin);
        btnLogin.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        userLogin();
                    }
                }
        );
        return view;
    }


    private void userLogin() {
        String mail=etLoginMail.getText().toString();
        String password=etLoginPass.getText().toString();
        String method="login";
        BackgroundTask backgroundTask=new BackgroundTask(this.getActivity());
        backgroundTask.execute(method,mail,password);
    }

}
