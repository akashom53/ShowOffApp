package com.akash.showoffapp.modules.main;

import com.akash.showoffapp.base.BasePresenter;
import com.akash.showoffapp.modules.main.view.IMainView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainPresenter extends BasePresenter<IMainView> {

    @Override
    protected void setupDataObservers() {

    }

    @Override
    protected void createViewSubscriptions() {
        createToastButtonSubscription();
        createSnackbarButtonSubscription();
    }

    private void createToastButtonSubscription() {
        getView().getToastButtonObservable()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(Object o) {
                        getView().openModule(IMainView.Module.Toast);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void createSnackbarButtonSubscription() {
        getView().getSnackbarButtonObservable()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(Object o) {
                        getView().showToast("Module in progress");
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
