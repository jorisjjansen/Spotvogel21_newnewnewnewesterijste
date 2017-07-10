package com.example.joris.spotvogel;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second_frag, container, false);

        final GlobalVariables globalVariable = (GlobalVariables) getActivity().getApplicationContext();

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/AdobeCaslonProSC.otf");
        TextView tv = (TextView) v.findViewById(R.id.color_question);
        tv.setTypeface(font);




        TextView zwart = (TextView) v.findViewById(R.id.zwart);
        TextView bruin = (TextView) v.findViewById(R.id.bruin);
        TextView blauw = (TextView) v.findViewById(R.id.blauw);
        TextView groen = (TextView) v.findViewById(R.id.groen);
        TextView grijs = (TextView) v.findViewById(R.id.grijs);
        TextView wit = (TextView) v.findViewById(R.id.wit);
        TextView geel = (TextView) v.findViewById(R.id.geel);
        TextView vraagteken = (TextView) v.findViewById(R.id.vraagteken);


        zwart.setTypeface(font);
        bruin.setTypeface(font);
        blauw.setTypeface(font);
        groen.setTypeface(font);
        grijs.setTypeface(font);
        wit.setTypeface(font);
        geel.setTypeface(font);
        vraagteken.setTypeface(font);

        ImageButton nextButton = (ImageButton) v
                .findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewPager = (ViewPager) getActivity().findViewById(
                        R.id.viewPager);
                viewPager.setCurrentItem(2);

            }
        });

        ImageButton previousButton = (ImageButton) v
                .findViewById(R.id.previous_button);
        previousButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewPager = (ViewPager) getActivity().findViewById(
                        R.id.viewPager);
                viewPager.setCurrentItem(0);

            }
        });

        return v;
    }

    public static SecondFragment newInstance(String text) {

        SecondFragment f = new SecondFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}