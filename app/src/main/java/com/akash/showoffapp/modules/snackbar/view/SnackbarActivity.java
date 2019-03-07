package com.akash.showoffapp.modules.snackbar.view;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.akash.androidcore.snackbars.SnackbarLibrary;
import com.akash.showoffapp.R;
import com.akash.showoffapp.base.BaseActivity;
import com.akash.showoffapp.modules.snackbar.SnackbarPresenter;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SnackbarActivity extends BaseActivity<SnackbarPresenter> implements ISnackbarView, View.OnClickListener {
    private Button simpleSnackbarButton;
    private Button actionSnackbarButton;
    private ObservableEmitter<Integer> snackbarActionEmmitter;

    @Override
    protected Class<SnackbarPresenter> getPresenterClass() {
        return SnackbarPresenter.class;
    }

    @Override
    protected void onViewReady() {

    }

    @Override
    protected void findViews() {
        simpleSnackbarButton = findViewById(R.id.btn_simple_snackbar);
        actionSnackbarButton = findViewById(R.id.btn_action_snackbar);
    }

    @Override
    protected int getContentView() {
        return R.layout.acitivity_snackbar;
    }


    @Override
    public Observable<Object> getSimpleSnackbarButtonObservable() {
        return RxView.clicks(simpleSnackbarButton)
                .debounce(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Object> getActionSnackbarButtonObservable() {
        return RxView.clicks(actionSnackbarButton)
                .debounce(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread());
    }

    @Override
    public void showSimpleSnackbar(String message) {
        SnackbarLibrary.showSimpleSnackbar(rootView, message, Snackbar.LENGTH_SHORT);
    }

    @Override
    public void showActionSnackbar(String message, String actionText, int snackbarId) {
        Snackbar sb = SnackbarLibrary.showSnackbarWithAction(rootView, message, actionText, Snackbar.LENGTH_LONG, this);
        SnackbarContentLayout contentLayout = (SnackbarContentLayout)((FrameLayout)sb.getView()).getChildAt(0);
        contentLayout.getActionView().setTag(snackbarId);
    }

    @Override
    public Observable<Integer> getSnackbarActionObservable() {
        return Observable.create(emitter -> snackbarActionEmmitter = emitter);
    }

    @Override
    public void onClick(View v) {
        snackbarActionEmmitter.onNext((Integer) v.getTag());
    }
}
