package com.alarmmanager.tutorial.alarmmanagertutorial.BroadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.alarmmanager.tutorial.alarmmanagertutorial.Helpers.Functions;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Functions.createNotification(context, "Alarm tutorial", "The duraion set has been passed", "Alert");
    }
}
