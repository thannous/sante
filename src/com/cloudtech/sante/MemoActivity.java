package com.cloudtech.sante;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class MemoActivity extends Activity {
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_layout);

        //ACTION BAR
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
}
