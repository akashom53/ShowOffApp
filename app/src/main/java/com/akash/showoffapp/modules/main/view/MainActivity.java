package com.akash.showoffapp.modules.main.view;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.akash.showoffapp.R;
import com.akash.showoffapp.ShowOffApp;
import com.akash.showoffapp.base.BaseActivity;
import com.akash.showoffapp.modules.jobs.view.JobsActivity;
import com.akash.showoffapp.modules.main.MainPresenter;
import com.akash.showoffapp.modules.notifications.view.NotificationsActivity;
import com.akash.showoffapp.modules.snackbar.SnackbarPresenter;
import com.akash.showoffapp.modules.snackbar.view.SnackbarActivity;
import com.akash.showoffapp.modules.toasts.view.ToastActivity;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {
    private Button toastButton;
    private Button snackbarButton;
    private Button notificationButton;
    private Button jobButton;

    @Override
    protected Class<MainPresenter> getPresenterClass() {
        return MainPresenter.class;
    }

    @Override
    protected void onViewReady() {

    }

    @Override
    protected void findViews() {
        toastButton = findViewById(R.id.btn_toast);
        snackbarButton = findViewById(R.id.btn_snackbar);
        notificationButton = findViewById(R.id.btn_notification);
        jobButton = findViewById(R.id.btn_job_scheduler);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public Observable<Object> getToastButtonObservable() {
        return RxView.clicks(toastButton)
                .debounce(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Object> getSnackbarButtonObservable() {
        return RxView.clicks(snackbarButton)
                .debounce(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Object> getNotificationButtonObservable() {
        return RxView.clicks(notificationButton)
                .debounce(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Object> getJobsButtonObservable() {
        return RxView.clicks(jobButton)
                .debounce(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread());
    }

    @Override
    public void openModule(Module module) {
        Class<? extends AppCompatActivity> activityClass = null;
        switch (module) {
            case Toast:
                activityClass = ToastActivity.class;
                break;
            case Snackbar:
                activityClass = SnackbarActivity.class;
                break;
            case Notification:
                activityClass = NotificationsActivity.class;
                break;
            case JobScheduler:
                activityClass = JobsActivity.class;
                break;
        }

        if (activityClass != null) {
            ShowOffApp.launch(this, activityClass);
        }
    }
}
