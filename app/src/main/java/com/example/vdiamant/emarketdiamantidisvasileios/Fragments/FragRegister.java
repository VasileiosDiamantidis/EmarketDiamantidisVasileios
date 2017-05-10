package com.example.vdiamant.emarketdiamantidisvasileios.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vdiamant.emarketdiamantidisvasileios.R;

/**
 * Created by vdiamant on 8/5/2017.
 */

public class FragRegister extends android.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.register,container,false);
        return view;
    }
}
