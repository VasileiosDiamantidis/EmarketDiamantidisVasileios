package com.example.vdiamant.emarketdiamantidisvasileios.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.vdiamant.emarketdiamantidisvasileios.R;


/**
 * Created by vdiamant on 8/5/2017.
 */

public class FragHome extends android.app.Fragment {

    private static Button btnLogin;
    private static Button btnRegister;

    FragHomeInterface actCommanderHome;

    public interface FragHomeInterface{
        public void changeFragment(boolean loginOrRegister);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            actCommanderHome=(FragHomeInterface) context;
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString());
        }
    }

    public void onAttach(Activity context) {
        super.onAttach(context);
        try{
            actCommanderHome=(FragHomeInterface) context;
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home,container,false);
        btnLogin=(Button) view.findViewById(R.id.btnHomeLogin);
        btnLogin.setOnClickListener(
            new View.OnClickListener(){
                public void onClick(View v){
                    changeFragment(true);
                }
            }
        );

        btnRegister=(Button) view.findViewById(R.id.btnHomeRegister);
        btnRegister.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        changeFragment(false);
                    }
                }
        );



        return view;
    }


    /*
    with the callLoginFragment and callRegisterFragment methods
    we call the changeFragment method to change the inner of the fragment
    of out layout.
    */
    /*
    private void callLoginFragment() {
        changeFragment(true);
    }

    private void callRegisterFragment(){
        changeFragment(false);
    }
*/
    /*
    the method change Fragment changes the fragment of the StartScreen Activity
    if it's True the new Fragment is the login Fragment, if it's false it is the register fragment.

    */

    //Ikportant! the Home Fragment stays in the memory stack so if the user presses back it returns to the Home Fragment!
    private void changeFragment(Boolean loginOrRegister){
        actCommanderHome.changeFragment(loginOrRegister);
        /*
        Fragment NewFragment;
        if(loginOrRegister) {
            NewFragment = new FragLogin();
        }
        else {
            NewFragment = new FragRegister();
        }


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentStartScreenBottom, NewFragment);
        fragmentTransaction.addToBackStack(String.valueOf(new FragHome()));
        fragmentTransaction.commit();*/

    }

}
