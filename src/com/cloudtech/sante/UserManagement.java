package com.cloudtech.sante;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by a.talviy on 27/07/13.
 * Gestion des utilisateurs
 */
public class UserManagement extends Activity {
    private Button bouton;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_management);
        Button backButton = (Button)this.findViewById(R.id.btn_back);
        backButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        bouton = (Button) findViewById(R.id.addUser);
        bouton.setMinimumWidth(100);
        bouton.setText("Ajouter Utilisateur");
        bouton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                // Perform action on click
                final Dialog dialog = new Dialog(v.getContext());
                //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setTitle(R.string.action_adduser);
                dialog.setContentView(R.layout.add_user);
                dialog.setCancelable(true);
                Button button =(Button)dialog.findViewById(R.id.btn_cancel);
                button.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v)
                    {
                        dialog.cancel();
                    }
                });

                //date.init(date.getYear(), date.getMonth(), date.getDayOfMonth(),null);

                dialog.show();
            }
        });
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
                final Dialog dialog = new Dialog(this);
                //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setTitle(R.string.action_adduser);
                dialog.setContentView(R.layout.add_user);
                dialog.setCancelable(true);
                Button button =(Button)dialog.findViewById(R.id.btn_cancel);
                button.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v)
                    {
                        dialog.cancel();
                    }
                });

                //date.init(date.getYear(), date.getMonth(), date.getDayOfMonth(),null);

                dialog.show();
                break;
            default:
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }


}