package com.akash.showoffapp.modules.notifications.view;

import com.akash.showoffapp.R;
import com.akash.showoffapp.base.BaseActivity;
import com.akash.showoffapp.modules.notifications.NotificationsPresenter;

public class NotificationsActivity extends BaseActivity<NotificationsPresenter> implements INotificationsView {
    @Override
    protected Class<NotificationsPresenter> getPresenterClass() {
        return NotificationsPresenter.class;
    }

    @Override
    protected void onViewReady() {

    }

    @Override
    protected void findViews() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_notifications;
    }
}
