package com.mobile.countme.framework;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobile.countme.R;
import com.mobile.countme.storage_and_memory.Assets;

/**
 * Created by Kristian on 11/09/2015.
 */
public abstract class AppMenu extends AppCompatActivity {

    public static Assets assets;

    @Override
    public void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        assets = new Assets();
    }





    public void goToNoAnimation(Class javaClass) {
        Intent intent = new Intent(this, javaClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }

    public void goTo(Class javaClass) {
        Intent intent = new Intent(this, javaClass);
        startActivity(intent);
        finish();
    }

    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }

}