package com.cloudtech.sante;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class UrgenceActivity extends Activity{
	   public void onCreate(final Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
     setContentView(R.layout.urgence_layout);

           //ACTION BAR
           ActionBar actionBar = getActionBar();
           actionBar.setDisplayHomeAsUpEnabled(true);


       }
}
