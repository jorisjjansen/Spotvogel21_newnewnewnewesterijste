package com.example.joris.spotvogel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements Shaker.Callback {

    public Shaker shaker;
    private static final int CAMERA_PIC_REQUEST = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shaker = new Shaker(this, 10d, 500, this);

        Typeface adobeBold = Typeface.createFromAsset(getAssets(), "fonts/AdobeCaslonProBold.ttf");
        Typeface adobeItalic = Typeface.createFromAsset(getAssets(), "fonts/AdobeCaslonProItalic.ttf");
        Typeface adobeSC = Typeface.createFromAsset(getAssets(), "fonts/AdobeCaslonProSC.otf");


        TextView enter = (TextView) findViewById(R.id.enter_name);
        TextView quest = (TextView) findViewById(R.id.questionaire_fill);
        TextView camera = (TextView) findViewById(R.id.take_photo);
        EditText bird_hint = (EditText) findViewById(R.id.bird_name);

        enter.setTypeface(adobeSC);
        quest.setTypeface(adobeSC);
        camera.setTypeface(adobeSC);
        bird_hint.setTypeface(adobeItalic);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void getBird(View view) {
        Intent getNameScreenIntent = new Intent(this, SingleResultScreen.class);
        final int result = 1;

        getNameScreenIntent.putExtra("callingActivity", "SlideActivity");
        startActivityForResult(getNameScreenIntent, result);

    }

    public void launchQuestionaire(View view) {
        Intent intent = new Intent(this, ssaActivity.class);
        startActivityForResult(intent,0);
    }

    public void launchCamera(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == RESULT_OK) {
            super.onActivityResult(requestCode, resultCode, data);
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            //STUUR DE FOTO NAAR DE API.

            Intent intent = new Intent(this, MultResultsScreen.class);
            startActivity(intent);
        }
    }



    @Override
    public void shakingStarted() {
    }

    @Override
    public void shakingStopped() {
    }
}