package com.akash.showoffapp.modules.notifications.view;

import com.akash.showoffapp.base.BaseView;

import io.reactivex.Observable;

public interface INotificationsView extends BaseView {
    int getBasicNotificationIcon();
    Observable<Object> getShowBasicNotificationButtonObservable();
    void showBasicNotification(String channelId, String channelName, String channelDescription, int notificationId, String title, String text, int icon);
}
