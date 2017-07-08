package com.example.congtuan.fragmentruntime;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by CongTuan on 5/23/2017.
 */

public class Frag_two extends Fragment {
    Button btnReplace1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag_two, container, false);
        btnReplace1 = (Button)view.findViewById(R.id.btnReplace1);
        btnReplace1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragContainer, ((MainActivity)getActivity()).frag_one);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}
