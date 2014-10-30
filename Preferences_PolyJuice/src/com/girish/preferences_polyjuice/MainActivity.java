package com.girish.preferences_polyjuice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends PreferenceActivity {
	
	//ListPreference listPreference;
	 //SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	
	@SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {    	
        super.onCreate(savedInstanceState);
        //SavePreferences("Facebook and Whatsapp","skfkjs");
        addPreferencesFromResource(R.xml.preference);   

    
    }
        
        
        
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(Menu.NONE, 0, 0, "Done");
    	return super.onCreateOptionsMenu(menu);
    }

    //@SuppressWarnings("deprecation")
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    		case 0:
    			   {//SavePreferences("None","aada");
    			   //SavePreferences("Facebook and Whatsapp","skfkjs");
    			   
    			    //LoadPreferences();
    				   SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
    					String s = sharedPrefs.getString("updates_interval","-1");
    					if(s.contentEquals("None"))Toast.makeText(getApplicationContext(),"Please choose your preference", Toast.LENGTH_SHORT).show();
    					else startActivity(new Intent(this, DisplayActivity.class));
    					 //bindPreferenceSummaryToValue(findPreference("preference"));
    			return true;}
    	}
    	return false;
    }
   /*private void SavePreferences(String key, String value){
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
       editor.putString(key, value);
        editor.commit();
        
       
       }
  
   private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
	    @Override
	    public boolean onPreferenceChange(Preference preference, Object value) {
	        String stringValue = value.toString();

	        if (preference instanceof ListPreference) {
	            // For list preferences, look up the correct display value in
	            // the preference's 'entries' list.
	            ListPreference listPreference = (ListPreference) preference;
	            int index = listPreference.findIndexOfValue(stringValue);

	            // Set the summary to reflect the new value.
	            preference.setSummary(
	                    index >= 0
	                            ? listPreference.getEntries()[index]
	                            : null);

	        } else {
	            // For all other preferences, set the summary to the value's
	            // simple string representation.
	            preference.setSummary(stringValue);
	        }
	        return true;
	    }
	};
   private static void bindPreferenceSummaryToValue(Preference preference) {
	    // Set the listener to watch for value changes.
	    preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

	    // Trigger the listener immediately with the preference's
	    // current value.
	    sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
	            PreferenceManager
	                    .getDefaultSharedPreferences(preference.getContext())
	                    .getString(preference.getKey(), ""));
	}
    private void LoadPreferences(){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String strSavedMem1 = sharedPreferences.getString("Contacts and Phone", "");
        String strSavedMem2 = sharedPreferences.getString("Facebook and Whatsapp", "");
        
        Toast.makeText(getApplicationContext(),strSavedMem1+strSavedMem2, Toast.LENGTH_SHORT).show();
        
       }*/
    
}