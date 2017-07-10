package com.example.joris.spotvogel;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_frag, container, false);


        final GlobalVariables globalVariable = (GlobalVariables) getActivity().getApplicationContext();
        globalVariable.setColor("");
        Log.d("Kleur", globalVariable.getColor());

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/AdobeCaslonProSC.otf");
        TextView tv = (TextView) v.findViewById(R.id.size_question);
        tv.setTypeface(font);


        TextView mus = (TextView) v.findViewById(R.id.mus);
        TextView merel = (TextView) v.findViewById(R.id.merel);
        TextView kraai = (TextView) v.findViewById(R.id.kraai);
        TextView gans = (TextView) v.findViewById(R.id.gans);
        TextView reiger = (TextView) v.findViewById(R.id.reiger);

        mus.setTypeface(font);
        merel.setTypeface(font);
        kraai.setTypeface(font);
        gans.setTypeface(font);
        reiger.setTypeface(font);


        ImageButton nextButton = (ImageButton) v
                .findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewPager = (ViewPager) getActivity().findViewById(
                        R.id.viewPager);
                viewPager.setCurrentItem(1);

            }
        });


        return v;
    }


    public static FirstFragment newInstance(String text) {

        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}