package com.akash.showoffapp.modules.toasts.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.akash.androidcore.toasts.ToastLibrary;
import com.akash.showoffapp.R;
import com.akash.showoffapp.base.BaseActivity;
import com.akash.showoffapp.modules.toasts.ToastPresenter;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class ToastActivity extends BaseActivity<ToastPresenter> implements IToastView {
    private Button simpleToastButton;
    private Button customToastButton;

    @Override
    protected Class<ToastPresenter> getPresenterClass() {
        return ToastPresenter.class;
    }

    @Override
    protected void onViewReady() {

    }

    @Override
    protected void findViews() {
        simpleToastButton = findViewById(R.id.btn_simple_toast);
        customToastButton = findViewById(R.id.btn_custom_toast);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_toast;
    }

    @Override
    public Observable<Object> getSimpleToastButtonObservable() {
        return RxView.clicks(simpleToastButton)
                .debounce(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread());
    }

    @Override
    public void showSimpleToast() {
        ToastLibrary.showBasicToast(this, "This is a basic Toast");
    }

    @Override
    public Observable<Object> getCustomToastButtonObservable() {
        return RxView.clicks(customToastButton)
                .debounce(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread());
    }

    @Override
    public void showCustomToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout,
                findViewById(R.id.custom_toast_container));

        TextView text = layout.findViewById(R.id.text);
        text.setText("This is a custom toast");
        ToastLibrary.showCustomToast(this, layout);
    }
}
