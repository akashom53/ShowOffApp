package com.akash.showoffapp.modules.toasts;

import com.akash.showoffapp.base.BasePresenter;
import com.akash.showoffapp.modules.toasts.view.IToastView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ToastPresenter extends BasePresenter<IToastView>  {

    @Override
    protected void setupDataObservers() {

    }

    @Override
    protected void createViewSubscriptions() {
        createSimpleButtonSubscription();
        createCustomButtonSubscription();
    }

    private void createSimpleButtonSubscription() {
        getView().getSimpleToastButtonObservable()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(Object o) {
                        getView().showSimpleToast();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void createCustomButtonSubscription() {
        getView().getCustomToastButtonObservable()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(Object o) {
                        getView().showCustomToast();
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
