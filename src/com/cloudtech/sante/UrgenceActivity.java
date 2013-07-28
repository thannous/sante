package com.cloudtech.sante;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class UrgenceActivity extends Activity {
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.urgence_layout);

        //ACTION BAR
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.urgence, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add_contact:
                Dialog dialog = new Dialog(this);
                //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setTitle(R.string.action_add_contact);
                dialog.setContentView(R.layout.add_contact_dialog);
                dialog.setCancelable(true);
                dialog.show();
                break;
            default:
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }
}
