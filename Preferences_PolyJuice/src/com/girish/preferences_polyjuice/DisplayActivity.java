package com.girish.preferences_polyjuice;

import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends Activity {
	
	final static int APP1=0;
  	final static int APP2=1;
  	static String APP1packagename="com.girish.Login";
  	static String APP2packagename="com.girish.Quiz_try";
  	static int currApp=APP1;
  	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		
		final TextView t1;
		final TextView t2;
		t1=(TextView) findViewById(R.id.textView1);
		t2=(TextView) findViewById(R.id.textView2);
		SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		String s = sharedPrefs.getString("updates_interval","-1");String s1="";String s2="";String sm[];
		
     	 if(s.contentEquals("1000")){
     		s1="Facebook and Whatsapp";sm=s1.split(" ");s1=sm[0];s2=sm[2];}
     	 else if(s.contentEquals("5000")){
     		s1="Contacts and Phone";sm=s1.split(" ");s1=sm[0];s2=sm[2];}
     	 else if(s.contentEquals("30000")){
     		s1="Messaging and Calculator";sm=s1.split(" ");s1=sm[0];s2=sm[2];}
     	 else if(s.contentEquals("60000")){
     		s1="Pictures and Videos";sm=s1.split(" ");s1=sm[0];s2=sm[2];}
     	 else if(s.contentEquals("300000")){
     		s1="TempleRun and SubwaySurfers";sm=s1.split(" ");s1=sm[0];s2=sm[2];}
     	 else
     	 {     		
     	startActivity(new Intent(this, MainActivity.class));
     	Toast.makeText(getApplicationContext(),"Please choose your preference", Toast.LENGTH_SHORT).show();
     	 }
     	 t1.setText("Not available");
     	 t2.setText("Not available");
     	 
     	PackageManager packageManager = getApplicationContext().getPackageManager();
     	
     	 List<PackageInfo> packs = packageManager.getInstalledPackages(0);
     	for(int i=0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i); ApplicationInfo a = p.applicationInfo;
                        if(s2.contentEquals(packageManager.getApplicationLabel(a).toString())){t2.setText(a.packageName.toString());/*Toast.makeText(getApplicationContext(),a.packageName.toString(), Toast.LENGTH_SHORT).show();*/}
                        if(s1.contentEquals(packageManager.getApplicationLabel(a).toString())){t1.setText(a.packageName.toString());/*Toast.makeText(getApplicationContext(),a.packageName.toString(), Toast.LENGTH_SHORT).show();*/}}
            // skip system apps if they shall not be included
            //if ((!includeSysApps) && ((a.flags & ApplicationInfo.FLAG_SYSTEM) == 1)) {
             //  continue;
            //}
     	setApp_Targets(t1.getText().toString(),t2.getText().toString());
     	
     	Button b1;b1=(Button) findViewById(R.id.button1);
b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v.getId()==R.id.button1){
			        if(t1.getText().equals("Not available")||t2.getText().equals("Not available")){Toast.makeText(getApplicationContext(),"No such app", Toast.LENGTH_SHORT).show();}
			        else{
			        Intent intent=new Intent();
		        	if(currApp==APP1) {
		        		intent=getPackageManager().getLaunchIntentForPackage(APP1packagename);
		        		startActivity(intent);
		        		currApp=APP2;}
		        	else{
		        		intent=getPackageManager().getLaunchIntentForPackage(APP2packagename);
		        		startActivity(intent);
		        		currApp=APP1;}
			        }
				
	
				}}});}

	
     
	private void setApp_Targets(String app1,String app2){
       	APP1packagename=app1;
       	APP2packagename=app2;
       }
	
	//void setApp_Targets(t1.getText().toString(),t2.getText().toString());
     	/*public void switchapps(View view){
        	Intent intent;
        	if(currApp==APP1) {
        		intent=getPackageManager().getLaunchIntentForPackage(APP1packagename);
        		startActivity(intent);
        		currApp=APP2;
        	}else{
        		intent=getPackageManager().getLaunchIntentForPackage(APP2packagename);
        		startActivity(intent);
        		currApp=APP1;
        	}*/
     	 
     	//t1.setText(s1); t2.setText(s2);
		/*StringBuilder builder = new StringBuilder();

		builder.append("\n" + sharedPrefs.getBoolean("perform_updates", false));
		builder.append("\n" + sharedPrefs.getString("updates_interval", "-1"));
		builder.append("\n" + sharedPrefs.getString("welcome_message", "NULL"));

		TextView settingsTextView = (TextView) findViewById(R.id.settings_text_view);
		settingsTextView.setText(builder.toString());*/
        	
     	
	

	
	
	
	

}
