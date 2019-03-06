package com.akash.showoffapp.base;

import java.lang.ref.WeakReference;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<B extends BaseView> extends ViewModel {
    protected CompositeDisposable disposables;
    private WeakReference<B> view;

    final void bind(B view) {
        this.disposables = new CompositeDisposable();
        this.view = new WeakReference<>(view);
        this.createViewSubscriptions();
        this.setupDataObservers();
    }

    /**
     * Reset the view state after a configuration change
     */
    protected abstract void setupDataObservers();

    protected abstract void createViewSubscriptions();

    @Override
    protected final void onCleared() {
        if (disposables != null) {
            disposables.dispose();
        }
    }

    protected B getView() {
        return view.get();
    }
}
