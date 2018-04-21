package com.ruthvik.bgservicesfornotifications.Reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.newsdistill.mobile.CustomCommunity.Service.CustomCommunityService;
import com.ruthvik.bgservicesfornotifications.Services.NotificationService;

/**
 * Created by welcome on 11/13/17.
 */

public class OnAlarmReceive extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //  Log.d(Globals.TAG, "BroadcastReceiver, in onReceive:");

        // Start the NotificationService
        Intent i = new Intent(context, NotificationService.class);
        context.startService(i);
    }
}
