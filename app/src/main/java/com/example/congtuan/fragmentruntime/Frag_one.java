package com.example.congtuan.fragmentruntime;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by CongTuan on 5/23/2017.
 */

public class Frag_one extends Fragment {
    Button btnToast;
    Button btnReplace;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_one, container, false);
        btnToast = (Button)view.findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Fragmetn One", Toast.LENGTH_SHORT).show();
            }
        });

        btnReplace = (Button)view.findViewById(R.id.btnReplace);
        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragContainer, ((MainActivity)getActivity()).frag_two);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}
