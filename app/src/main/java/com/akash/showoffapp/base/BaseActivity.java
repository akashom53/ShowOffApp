package com.akash.showoffapp.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity{
    protected T presenter;
    private ProgressDialog progressDialog;
    protected View rootView;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRootView();
        findViews();
        this.presenter = ViewModelProviders.of(this).get(getPresenterClass());
        onViewReady();
        if (!(this instanceof BaseView)) {
            throw new RuntimeException("View must implement BaseView or an interface extending BaseView");
        } else {
            this.presenter.bind((BaseView) this);
        }
    }

    private void initRootView() {
        rootView = getLayoutInflater().inflate(getContentView(), null);
        setContentView(rootView);
    }

    protected abstract Class<T> getPresenterClass();

    protected abstract void onViewReady();

    protected abstract void findViews();

    protected abstract int getContentView();

    public final void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public final void showLoader(String title, String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public final void hideLoader() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }

}
