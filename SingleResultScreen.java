package com.example.joris.spotvogel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SingleResultScreen extends Activity{
    MediaPlayer mp;
    Integer sound = R.raw.bird_is_the_word;

    //audio file
    //photofile
    //color
    //beschrijvingString
    //..

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_result);
        mp = MediaPlayer.create(this, sound);
        Typeface adobeRegular = Typeface.createFromAsset(getAssets(), "fonts/AdobeCaslonPro.ttf");
        Typeface adobeBold = Typeface.createFromAsset(getAssets(), "fonts/AdobeCaslonProBold.ttf");
        Typeface adobeIta = Typeface.createFromAsset(getAssets(), "fonts/AdobeCaslonProItalic.ttf");
        Typeface adobeSC = Typeface.createFromAsset(getAssets(), "fonts/AdobeCaslonProSC.otf");

        //geluidsbestand VD Vogel

        TextView beschrijving = (TextView) findViewById(R.id.beschrijving);
        beschrijving.setTypeface(adobeBold);
        //beschrijving.setText(beschrijvingString);

        Bundle b = getIntent().getExtras();
        String NLNaam = ""; // or other values

        NLNaam = b.getString("NLNaam");

        TextView dutchName = (TextView) findViewById(R.id.dutch_name);
        TextView latinName = (TextView) findViewById(R.id.latin_name);

        dutchName.setTypeface(adobeBold);
        latinName.setTypeface(adobeIta);
//        dutchName.setText(NLNaam);

//        beschrijving.setTypeface(adobeRegulat);


        //kenmerk fill
        TextView kenmerk1 = (TextView) findViewById(R.id.color);
        TextView kenmerk2 = (TextView) findViewById(R.id.breastColor);
        TextView kenmerk3 = (TextView) findViewById(R.id.snavelColor);
        TextView kenmerk4 = (TextView) findViewById(R.id.birdSize);
        TextView kenmerk5 = (TextView) findViewById(R.id.beakShape);
        TextView kenmerk6 = (TextView) findViewById(R.id.species);



        kenmerk1.setTypeface(adobeBold);
        kenmerk2.setTypeface(adobeBold);
        kenmerk3.setTypeface(adobeBold);
        kenmerk4.setTypeface(adobeBold);
        kenmerk5.setTypeface(adobeBold);
        kenmerk6.setTypeface(adobeBold);


        TextView spec1 = (TextView) findViewById(R.id.color_answer);
        TextView spec2 = (TextView) findViewById(R.id.breastColor_answer);
        TextView spec3 = (TextView) findViewById(R.id.snavelColor_answer);
        TextView spec4 = (TextView) findViewById(R.id.birdSize_answer);
        TextView spec5 = (TextView) findViewById(R.id.beakShape_answer);
        TextView spec6 = (TextView) findViewById(R.id.species_answer);


        spec1.setTypeface(adobeRegular);
        spec2.setTypeface(adobeRegular);
        spec3.setTypeface(adobeRegular);
        spec4.setTypeface(adobeRegular);
        spec5.setTypeface(adobeRegular);
        spec6.setTypeface(adobeRegular);

        TextView sound = (TextView) findViewById(R.id.soundOf);
        sound.setTypeface(adobeSC);

    }

    public void launchCamera(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);

    }

    @Override
    public void onBackPressed()
    {
        mp.release();
        super.onBackPressed();
        startActivity(new Intent(SingleResultScreen.this, MainActivity.class));
        finish();
    }

    public void play(View view){
        ImageButton play = (ImageButton) findViewById(R.id.play_sound);

        if (!mp.isPlaying()) {
            mp.stop();
            mp.reset();
            mp.release();
            mp = MediaPlayer.create(this, sound);
            mp.start();
            play.setBackground(getResources().getDrawable(R.mipmap.ic_stop));
        }
        else{
            if (mp.isPlaying()) {
                mp.stop();
                mp = MediaPlayer.create(this, sound);
                play.setBackground(getResources().getDrawable(R.mipmap.ic_play));
            }
        }

    }
}