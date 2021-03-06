package com.example.joris.spotvogel;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ThirdFragment extends Fragment {

    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.third_frag, container, false);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/AdobeCaslonProSC.otf");

        final GlobalVariables globalVariable = (GlobalVariables) getActivity().getApplicationContext();

        Button button = (Button) v.findViewById(R.id.zoek);
        TextView tv = (TextView) v.findViewById(R.id.beak_question);
        tv.setTypeface(font);
        button.setTypeface(font);

        Button button1 = (Button) v.findViewById(R.id.ans1);
        button1.setSelected(true);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MultResultsScreen.class);
                startActivityForResult(intent,0);
            }
        });

        ImageButton previousButton = (ImageButton) v
                .findViewById(R.id.previous_button);
        previousButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewPager = (ViewPager) getActivity().findViewById(
                        R.id.viewPager);
                viewPager.setCurrentItem(1);

            }
        });

        return v;
    }

    public static ThirdFragment newInstance(String text) {

        ThirdFragment f = new ThirdFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}