package com.cloudtech.sante;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;

public class SanteWidgetConfigure extends PreferenceActivity {
	 int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
	 
	    ListPreference listeTimePref;
	 
	    SharedPreferences prefs;
	 
	    public SanteWidgetConfigure() {
	        super();
	    }
	 
	 
		@Override
	    public void onCreate(Bundle icicle) {
	        super.onCreate(icicle);
	 
	        setResult(RESULT_CANCELED);
	 
			addPreferencesFromResource(R.xml.sante_widget_preference);
	 
			this.listeTimePref = (ListPreference) findPreference("widget_time");
	 
	        Intent intent = getIntent();
	        Bundle extras = intent.getExtras();
	        if (extras != null) {
	            mAppWidgetId = extras.getInt(
	                    AppWidgetManager.EXTRA_APPWIDGET_ID,
	                    AppWidgetManager.INVALID_APPWIDGET_ID);
	        }
	 
	        // Si l'id du widget == 0
	        if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
	            finish();
	        }
	 
			this.prefs = PreferenceManager.getDefaultSharedPreferences(this);
	 
			// Preferences par default
			updateWidgetDefaultPrefs();
	    }
	 
		private void updateWidgetPrefs()
		{
			Editor prefeditor = this.prefs.edit();
	 
	        // Time
	        prefeditor.putString("widget"+mAppWidgetId+"time", this.listeTimePref.getValue());
	 
	        // Set default values
	        prefeditor.putString("widget_time", "");
	 
	        prefeditor.commit();
		}
	 
		/*
		 * Valeur par defaut
		 */
		private void updateWidgetDefaultPrefs()
		{
			if(this.prefs.contains("widget"+mAppWidgetId+"time"))
				this.listeTimePref.setValue(this.prefs.getString("widget"+mAppWidgetId+"time", ""));
			else
				this.listeTimePref.setValue("60");
		}
	 
		/*
		 * Mise a jour du widget
		 */
	    private void confirm()
	    {
			Intent resultValue = new Intent();
			resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
			setResult(RESULT_OK, resultValue);
			finish();
	 
	        new SanteWidgetProvider()
	        .onUpdate(this,
	                  AppWidgetManager.getInstance(this),
	                  new int[] { mAppWidgetId }
	         );
	    }
	 
	    @Override
	    public void onBackPressed()
	    {
	    	this.updateWidgetPrefs();
	 
	    	this.confirm();
	 
	    	super.onBackPressed();
	    }
}

