package com.cis490.alex.hw6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "CFCV42kqtAgS9yjNeG7s6ItxO22l7dutZZOm0Z8Z", "bVO1GGEh3GDuDaxiLjQWppe3mEOnv9mp3S3zUsBp");
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    // broadcast a custom intent.
    public void broadcastIntent(View view)
    {
        Intent intent = new Intent();
        intent.setAction("com.cis490.alex.hw6.CUSTOM_INTENT");
        sendBroadcast(intent);
    }
}
