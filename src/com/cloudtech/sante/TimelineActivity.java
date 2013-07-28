package com.cloudtech.sante;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TimelineActivity extends Activity {
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_layout);

        //ACTION BAR
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

//        TextView tall = (TextView)findViewById(R.id.txt_list_allergies);
//        TextView tant = (TextView)findViewById(R.id.txt_list_antecedents);
//        tall.setText(Html.fromHtml(getString(R.string.list_allergies)));
//        tant.setText(Html.fromHtml(getString(R.string.list_antecedents)));
    }
}
