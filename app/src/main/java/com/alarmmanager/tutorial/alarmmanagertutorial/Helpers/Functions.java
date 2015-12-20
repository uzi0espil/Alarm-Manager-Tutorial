package com.alarmmanager.tutorial.alarmmanagertutorial.Helpers;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.alarmmanager.tutorial.alarmmanagertutorial.BroadcastReceivers.AlarmReceiver;
import com.alarmmanager.tutorial.alarmmanagertutorial.MainActivity;
import com.alarmmanager.tutorial.alarmmanagertutorial.R;

import java.util.Calendar;

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

        //it is better to make the notification ID based on the ID of the alarm in the database
        notificationManager.notify(NOTIFY_ID, mBuilder.build());
    }

    public static void setAlarm(Context context, int hourOfDay, int minute){

        Calendar calNow = Calendar.getInstance();
        Calendar calSet = (Calendar) calNow.clone();

        calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calSet.set(Calendar.MINUTE, minute);

        if(calSet.compareTo(calNow) <= 0) //if calendar of set is lesser or equal to the time being we set add a day
            calSet.add(Calendar.DATE, 1);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent AlarmIntent = new Intent(context, AlarmReceiver.class);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(), PendingIntent.getBroadcast(context, 0, AlarmIntent, PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
