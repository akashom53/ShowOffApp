package com.akash.showoffapp.modules.main.view;

import com.akash.showoffapp.base.BaseView;

import io.reactivex.Observable;

public interface IMainView extends BaseView {

    enum Module {
        Toast,
        Snackbar
    }

    Observable<Object> getToastButtonObservable();
    Observable<Object> getSnackbarButtonObservable();
    void openModule(Module module);
}
