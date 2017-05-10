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


    //With initializeFragment() we replace the FrameLayout with the home Fragment
    //So that the user can navigate to Login Or Register
    //The reason we do that is because if we would have started the activity with the fragment from xml
    //we couldn't change it later so that the FragHome or FragRegister would have been in the position of the FrameLayout

    private void initializeFragment() {
        Fragment homeFragment=new FragHome();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutStartScreenBottom, homeFragment);
        //fragmentTransaction.addToBackStack(String.valueOf(new FragHome()));
        clearBackStack();
        fragmentTransaction.commit();
    }


    //the method change Fragment changes the fragment of the StartScreen Activity
    //if it's True the new Fragment is the login Fragment, if it's false it is the register fragment.



    //Important! the Home Fragment stays in the back stack so if the user presses back it returns to the Home Fragment!

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


    //this method is to empty the back stack so that if the user presses back when he is at the home fragment
    //he will exit app. Without this method he would be seeing the activity with the framelayout empty.
    private void clearBackStack(){
        FragmentManager fm = getFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }
}
