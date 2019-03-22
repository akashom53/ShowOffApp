package com.akash.showoffapp.modules.notifications;

import com.akash.showoffapp.base.BasePresenter;
import com.akash.showoffapp.modules.notifications.view.INotificationsView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class NotificationsPresenter extends BasePresenter<INotificationsView> {
    @Override
    protected void setupDataObservers() {

    }

    @Override
    protected void createViewSubscriptions() {
        createShowBasicNotificationSubscription();
    }

    private void createShowBasicNotificationSubscription() {
        getView().getShowBasicNotificationButtonObservable()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(Object o) {
                        getView().showBasicNotification(
                                "com.akash.showoffapp.PRIMARY_CHANNEL",
                                "ShowOff Notifications",
                                "Notifications from ShowOff app by Akash Srivastava",
                                101,
                                "Basic Notification",
                                "Hello! This is a basic notification from the ShowOff Application!",
                                getView().getBasicNotificationIcon()
                        );
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
