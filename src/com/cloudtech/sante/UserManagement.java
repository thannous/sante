package com.cloudtech.sante;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by a.talviy on 27/07/13.
 * Gestion des utilisateurs
 */
public class UserManagement extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_management);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.usermanagement, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_adduser:
                Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.add_user);
                dialog.setCancelable(true);
                dialog.show();
                break;
            default:
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }
}