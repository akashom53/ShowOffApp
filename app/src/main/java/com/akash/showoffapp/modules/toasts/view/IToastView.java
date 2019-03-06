package com.akash.showoffapp.modules.toasts.view;

import com.akash.showoffapp.base.BaseView;

import io.reactivex.Observable;


public interface IToastView extends BaseView {
    Observable<Object> getSimpleToastButtonObservable();
    void showSimpleToast();

    Observable<Object> getCustomToastButtonObservable();
    void showCustomToast();
}
