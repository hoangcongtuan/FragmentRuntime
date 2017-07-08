package com.example.congtuan.fragmentruntime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity  implements Frag_color.OnColorChangeListener{
    public Frag_one frag_one;
    public Frag_two frag_two;
    public Frag_color frag_color;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        frag_one = new Frag_one();
        frag_two = new Frag_two();
        frag_color = new Frag_color();
        fragmentTransaction.add(R.id.fragContainer, frag_color);
        fragmentTransaction.commit();
        relativeLayout = (RelativeLayout)findViewById(R.id.mainLayout);
    }

    public void replaceFrag(View view) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragContainer, frag_two);
        fragmentTransaction.commit();
    }

    @Override
    public void colorChange(int color) {
        relativeLayout.setBackgroundColor(color);
    }
}
