package com.alarmmanager.tutorial.alarmmanagertutorial.Helpers;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.alarmmanager.tutorial.alarmmanagertutorial.MainActivity;
import com.alarmmanager.tutorial.alarmmanagertutorial.R;

/**
 * Created by Osama on 12/20/2015.
 */
public class Functions {

    private final static int NOTIFY_ID = 1244;

    public static void createNotification(Context context, String title, String msg, String tinker){
        PendingIntent notificationIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setTicker(tinker)
                .setContentText(msg)
                .setContentIntent(notificationIntent)
                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFY_ID, mBuilder.build());
    }
}
