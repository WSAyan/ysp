package com.example.ysp;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.SimpleCursorAdapter;

public class psyService extends Service 
{
	SimpleCursorAdapter adapter;
	String tag="SERVICE";
	ContentResolver content;
    ContentResolver contentResolver;
    
    
	
	@Override
	public IBinder onBind(Intent arg0) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void onCreate() 
	{
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) 
	{
		// TODO Auto-generated method stub
		
		// ContentResolver para obtener los SMS salientes
		
		
        
		Log.i(tag,"Service Started");
		new Thread(new Runnable() {
			
			@Override
			public void run() 
			{

		        try 
		        {
					Thread.sleep(5000);
				} 
		        catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        Log.i(tag,"Service running4");
			}
		}).start();
		return Service.START_STICKY;
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		//super.onDestroy();
		sendBroadcast(new Intent("YouWillNeverKillMe"));
	}
	

}
