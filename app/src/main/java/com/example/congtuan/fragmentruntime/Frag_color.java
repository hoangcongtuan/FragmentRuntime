package com.example.congtuan.fragmentruntime;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * Created by CongTuan on 5/23/2017.
 */

public class Frag_color extends Fragment {
    RadioGroup radioGroup;
    OnColorChangeListener onColorChangeListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_color, container, false);
        radioGroup = (RadioGroup)view.findViewById(R.id.rgColor);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rbBlue:
                        onColorChangeListener.colorChange(Color.BLUE);
                        break;
                    case R.id.rbGreen:
                        onColorChangeListener.colorChange(Color.GREEN);
                        break;
                    case R.id.rbRed:
                        onColorChangeListener.colorChange(Color.RED);
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onColorChangeListener = (OnColorChangeListener)activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity)context;
        onColorChangeListener = (OnColorChangeListener)activity;
    }

    public interface OnColorChangeListener {
        public void colorChange(int color);
    }
}
