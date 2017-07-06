package com.example.joris.spotvogel;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MultResultsScreen extends ListActivity  {
    CustomListAdapter adapter;

    String[] itemname ={
            "Bosrietzanger",
            "Spotvogel",
            "Roodborst",
            "Fitis",

    };

    Integer[] imgid={
            R.drawable.bosrietzanger,
            R.drawable.spotvogel,
            R.drawable.robin,
            R.drawable.fitis
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        Typeface adobeSC = Typeface.createFromAsset(getAssets(), "fonts/AdobeCaslonProSC.otf");
        TextView tv = (TextView) findViewById(R.id.results);
        tv.setTypeface(adobeSC);

        adapter = new CustomListAdapter(this, itemname, imgid);
        this.setListAdapter(adapter);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}