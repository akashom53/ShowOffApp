package com.akash.showoffapp.modules.snackbar;

import com.akash.showoffapp.base.BasePresenter;
import com.akash.showoffapp.modules.snackbar.view.ISnackbarView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SnackbarPresenter extends BasePresenter<ISnackbarView> {

    @Override
    protected void setupDataObservers() {

    }

    @Override
    protected void createViewSubscriptions() {
        createSnackbarActionSubscription();
        createSimpleSnackbarButtonSubscription();
        createActionSnackbarButtonSubscription();
    }

    private void createSimpleSnackbarButtonSubscription() {
        getView().getSimpleSnackbarButtonObservable()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(Object o) {
                        getView().showSimpleSnackbar("This is a simple Snackbar");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void createActionSnackbarButtonSubscription() {
        getView().getActionSnackbarButtonObservable()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(Object o) {
                        getView().showActionSnackbar("This is action snackbar", "Meh", 101);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void createSnackbarActionSubscription() {
        getView().getSnackbarActionObservable()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        getView().showToast("Snabar action clicked: "+integer);
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
