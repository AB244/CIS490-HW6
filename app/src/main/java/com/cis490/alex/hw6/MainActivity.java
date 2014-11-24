package com.cis490.alex.hw6;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;


public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "CFCV42kqtAgS9yjNeG7s6ItxO22l7dutZZOm0Z8Z", "bVO1GGEh3GDuDaxiLjQWppe3mEOnv9mp3S3zUsBp");
        PushService.setDefaultPushCallback(this, MainActivity.class);
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

    public void pushIntent(View view)
    {
        PushFragment pushFrag = new PushFragment();
        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainLayout, pushFrag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void viewPushedItems(View view)
    {
        PushedItemsFragment listFrag = new PushedItemsFragment();
        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainLayout, listFrag);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
