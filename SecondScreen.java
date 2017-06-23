package com.example.joris.spotvogel;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondScreen extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for the layout we created
        setContentView(R.layout.second_layout);

        // Get the Intent that called for this Activity to open
//
//        Intent activityThatCalled = getIntent();
//
//        // Get the data that was sent
//
//        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
//
//        TextView callingActivityMessage = (TextView)
//                findViewById(R.id.calling_activity_info_text_view);
//
//        callingActivityMessage.append(" " + previousActivity);
    }

    public void launchCamera(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(SecondScreen.this, MainActivity.class));
        finish();

    }
}