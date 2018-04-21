package com.ruthvik.bgservicesfornotifications;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.PeriodicTask;
import com.ruthvik.bgservicesfornotifications.Reciever.OnAlarmReceive;
import com.ruthvik.bgservicesfornotifications.Services.NotificationTaskService;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        setUpServicesToReceiveNotifications();
    }

    private void setUpServicesToReceiveNotifications() {
        if ("Asus".equalsIgnoreCase(Build.MANUFACTURER) ||
                "XIAOMI".equalsIgnoreCase(Build.MANUFACTURER)) {
            scheduleUsingGcmNetworkManager(mContext);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            scheduleUsingJobScheduler(mContext);
        } else {
            scheduleUsingAlarmManager();
        }
    }



    public void scheduleUsingGcmNetworkManager(Context mContext) {
        final GcmNetworkManager gcmNetworkManager = GcmNetworkManager.getInstance(mContext);
        final long interval = TimeUnit.MINUTES.toSeconds(18);
        final long flex = TimeUnit.MINUTES.toSeconds(5);
        final PeriodicTask task = new PeriodicTask.Builder()
                .setService(NotificationTaskService.class)
                .setTag("")
                .setPersisted(true)
                .setPeriod(interval)
                .setFlex(flex)
                .build();

        try {
            gcmNetworkManager.cancelTask("", NotificationTaskService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        gcmNetworkManager.schedule(task);
    }


    private void scheduleUsingJobScheduler(Context context) {
        try {
            final ComponentName componentName = new ComponentName(context, NotificationJobService.class);
            final long interval = TimeUnit.MINUTES.toMillis(18);
            final long flex = TimeUnit.MINUTES.toMillis(5);
            final JobInfo.Builder jobInfoBuilder = new JobInfo.Builder(2017, componentName)
                    .setPersisted(true)
                    .setBackoffCriteria(TimeUnit.SECONDS.toMillis(5), JobInfo.BACKOFF_POLICY_LINEAR);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                jobInfoBuilder.setPeriodic(interval, flex);
            } else {
                jobInfoBuilder.setPeriodic(interval);
                jobInfoBuilder.setRequiredNetworkType(1);
            }

            final JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
            if (jobScheduler != null) {
                try {
                    jobScheduler.cancel(2017);
                } catch (Exception e) {
                    Log.e("", "scheduleUsingJobScheduler: ");
                }
                jobScheduler.schedule(jobInfoBuilder.build());
            }
        } catch (Throwable throwable) {
            Log.e("", "scheduleUsingJobScheduler: ");
        }
    }

    public void scheduleUsingAlarmManager() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, OnAlarmReceive.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1001, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1080000, 1080000,
                pendingIntent);

    }


}
