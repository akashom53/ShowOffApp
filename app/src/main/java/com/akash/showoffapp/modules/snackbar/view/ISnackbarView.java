package com.akash.showoffapp.modules.snackbar.view;

import com.akash.showoffapp.base.BaseView;

import io.reactivex.Observable;

public interface ISnackbarView extends BaseView {

    Observable<Object> getSimpleSnackbarButtonObservable();
    Observable<Object> getActionSnackbarButtonObservable();

    void showSimpleSnackbar(String message);
    void showActionSnackbar(String message, String actionText, final int snackbarId);

    Observable<Integer> getSnackbarActionObservable();

}
