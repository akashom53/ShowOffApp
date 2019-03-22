package com.akash.showoffapp.modules.main.view;

import com.akash.showoffapp.base.BaseView;

import io.reactivex.Observable;

public interface IMainView extends BaseView {

    enum Module {
        Toast,
        Snackbar,
        Notification,
        JobScheduler
    }

    Observable<Object> getToastButtonObservable();
    Observable<Object> getSnackbarButtonObservable();
    Observable<Object> getNotificationButtonObservable();
    Observable<Object> getJobsButtonObservable();

    void openModule(Module module);
}
