package com.mobile.countme.menu;

import android.os.Bundle;
import com.mobile.countme.framework.AppMenu;

/**
 * Created by Kristian on 11/09/2015.
 */
public class LoadingScreen extends AppMenu {

    @Override
    public void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);

        //LOAD SHIT

        //AFTER DONE LOADING
        goToNoAnimation(InformationMenu.class);
    }

}