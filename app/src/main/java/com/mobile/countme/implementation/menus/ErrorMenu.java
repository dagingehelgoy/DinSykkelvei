package com.mobile.countme.implementation.menus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mobile.countme.R;
import com.mobile.countme.framework.AppMenu;
import com.mobile.countme.implementation.controllers.MainPages;
import com.mobile.countme.implementation.models.ErrorModel;

/**
 * Created by Kristian on 16/09/2015.
 */
public class ErrorMenu extends AppMenu {

    private ImageView photoTaken;
    private String description = "";

    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.error_activity);

        photoTaken = (ImageView)findViewById(R.id.pictureTaken);
        getUser().createError(new ErrorModel());
    }

    public void sendReport(View view){
        //TODO: Set trip init when starting trip track.
        if(getUser().isTripInitialized()){
            goTo(BikingActive.class);
        }else {
            goTo(ResultMenu.class);
        }
    }

    public void createDescription(View view){
        //TODO: Pop up to add description.
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Legg til beskrivelse");

// Set an EditText view to get user input
        final EditText input = new EditText(this);
        input.setText(description);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Do something with value!
                Editable editable = input.getText();
                description = editable.toString();
                getUser().addDescription(description);
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
//        getUser().addDescription();
    }

    public void startCamera(View view){
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            getUser().addPhoto(bp);
            photoTaken.setImageBitmap(bp);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
