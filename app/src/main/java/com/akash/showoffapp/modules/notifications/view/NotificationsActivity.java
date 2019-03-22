package com.akash.showoffapp.modules.notifications.view;

import android.widget.Button;

import com.akash.androidcore.notifications.NotificationsLibrary;
import com.akash.showoffapp.R;
import com.akash.showoffapp.base.BaseActivity;
import com.akash.showoffapp.modules.notifications.NotificationsPresenter;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class NotificationsActivity extends BaseActivity<NotificationsPresenter> implements INotificationsView {
    private Button basicNotificationButton;

    @Override
    protected Class<NotificationsPresenter> getPresenterClass() {
        return NotificationsPresenter.class;
    }

    @Override
    protected void onViewReady() {
        setTitle("Notifications");
    }

    @Override
    protected void findViews() {
        basicNotificationButton = findViewById(R.id.btn_basic_notification);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_notifications;
    }


    @Override
    public int getBasicNotificationIcon() {
        return R.drawable.ic_android;
    }

    @Override
    public Observable<Object> getShowBasicNotificationButtonObservable() {
        return RxView.clicks(basicNotificationButton)
                .debounce(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread());
    }

    @Override
    public void showBasicNotification(String channelId, String channelName, String channelDescription, int notificationId, String title, String text, int icon) {
        NotificationsLibrary.showBasicNotification(
                this,
                new NotificationsLibrary.ChannelConfig(channelId, channelName, channelDescription),
                notificationId,
                title,
                text,
                icon
        );
    }
}
