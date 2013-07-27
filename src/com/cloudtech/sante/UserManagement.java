package com.cloudtech.sante;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

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
}