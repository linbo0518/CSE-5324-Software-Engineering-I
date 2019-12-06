package com.uta.cse.team7.newscenter.receivers;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.uta.cse.team7.newscenter.services.SyncArticlesIntentService;

public class SyncArticlesReceiver extends BroadcastReceiver {
    public SyncArticlesReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int notificationId = intent.getIntExtra("notificationId", 0);

        //Cancel the notification
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(notificationId);

        SyncArticlesIntentService.STATUS = false;

        //Stop the service
        context.stopService(new Intent(context, SyncArticlesIntentService.class));
    }
}
