package com.cloudtech.sante;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by a.talviy on 28/07/13.
 */
public class CapucineActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.capucine_layout);

        //ACTION BAR
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
}