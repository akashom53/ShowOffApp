package com.akash.androidcore.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class NotificationsLibrary {

    private NotificationManager notificationManager;
    private static NotificationsLibrary instance;



    private NotificationsLibrary() {
    }

    private static NotificationsLibrary getInstance() {
        if (instance == null) {
            instance = new NotificationsLibrary();
        }
        return instance;
    }

    private void createNotificationChannel(String CHANNEL_ID, String channelName, String description, AppCompatActivity activity) {
        notificationManager = (NotificationManager) activity.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE);
        if (notificationManager == null) {
            throw new NotificationLibraryException("Unable to get Notification Manager Service");
        }
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription(description);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder(AppCompatActivity activity, String channelId, String title, String text, int iconRes) {
        return new NotificationCompat.Builder(activity, channelId)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(iconRes);
    }

    private void showNotification(NotificationCompat.Builder notificationBuilder, int notificationId) {
        notificationManager.notify(notificationId, notificationBuilder.build());
    }

    public static void showBasicNotification(AppCompatActivity activity, ChannelConfig config,int notificationId, String title, String text, int iconRes) {
        NotificationsLibrary instance = getInstance();
        instance.createNotificationChannel(config.channelId, config.channelName, config.description, activity);
        instance.showNotification(
                instance.getNotificationBuilder(activity, config.channelId, title, text, iconRes),
                notificationId
        );
    }


    public static class ChannelConfig {
        String channelId;
        String channelName;
        String description;


        public ChannelConfig(String channelId, String channelName, String description) {
            this.channelId = channelId;
            this.channelName = channelName;
            this.description = description;
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof ChannelConfig) {
                return ((ChannelConfig) obj).channelId.equals(this.channelId);
            }
            return false;
        }
    }
}
