package com.cloudtech.sante;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class EvolutionActivity extends Activity{
	   public void onCreate(final Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
           setContentView(R.layout.timeline_layout);

           //ACTION BAR
           ActionBar actionBar = getActionBar();
           actionBar.setDisplayHomeAsUpEnabled(true);

       }
}
