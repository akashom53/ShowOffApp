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
        createNotificationsButtonSubscription();
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
                        getView().openModule(IMainView.Module.Snackbar);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void createNotificationsButtonSubscription() {
        getView().getNotificationButtonObservable()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(Object o) {
                        getView().openModule(IMainView.Module.Notification);
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
