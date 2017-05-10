package com.example.vdiamant.emarketdiamantidisvasileios.View;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.vdiamant.emarketdiamantidisvasileios.Fragments.FragHome;
import com.example.vdiamant.emarketdiamantidisvasileios.Fragments.FragLogin;
import com.example.vdiamant.emarketdiamantidisvasileios.Fragments.FragRegister;
import com.example.vdiamant.emarketdiamantidisvasileios.R;

public class StartScreen extends AppCompatActivity implements FragHome.FragHomeInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        initializeFragment();

    }

    private void initializeFragment() {
        Fragment homeFragment=new FragHome();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutStartScreenBottom, homeFragment);
        //fragmentTransaction.addToBackStack(String.valueOf(new FragHome()));
        clearBackStack();
        fragmentTransaction.commit();
    }


    @Override
    public void changeFragment(boolean loginOrRegister) {
        Fragment NewFragment;
        if(loginOrRegister) {
            NewFragment = new FragLogin();
        }
        else {
            NewFragment = new FragRegister();
        }


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutStartScreenBottom, NewFragment);
        //fragmentTransaction.addToBackStack(String.valueOf(new FragHome()));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void clearBackStack(){
        FragmentManager fm = getFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }
}
