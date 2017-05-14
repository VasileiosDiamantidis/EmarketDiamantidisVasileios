package com.example.vdiamant.emarketdiamantidisvasileios.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.vdiamant.emarketdiamantidisvasileios.Controller.BackgroundTask;
import com.example.vdiamant.emarketdiamantidisvasileios.R;
import com.example.vdiamant.emarketdiamantidisvasileios.View.UserHome;

import java.util.concurrent.ExecutionException;

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
                        try {
                            userLogin();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        return view;
    }


    private void userLogin() throws ExecutionException, InterruptedException {
        String mail=etLoginMail.getText().toString();
        String password=etLoginPass.getText().toString();
        String method="login";
        BackgroundTask backgroundTask=new BackgroundTask(this.getActivity());
        String result=backgroundTask.execute(method,mail,password).get();
        System.out.println(result);
        showErrorMessage(result);

    }


//this method is to show to the user the errors if he could't connect to the database
    private void showErrorMessage(String result) {
            if (result.startsWith("Database connection Success Login Success")) {
                startHomeIntent();
            } else if (result.startsWith("Database connection Success Login Failed")) {
                etLoginPass.setText("");
            }


    }

    private void startHomeIntent() {
        Intent intent = new Intent(this.getActivity(),UserHome.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
