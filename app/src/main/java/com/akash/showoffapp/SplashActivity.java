package com.akash.showoffapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akash.androidcore.toasts.ToastLibrary;
import com.akash.showoffapp.modules.main.MainPresenter;
import com.akash.showoffapp.modules.main.view.MainActivity;
import com.akash.showoffapp.modules.toasts.view.ToastActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShowOffApp.launch(this, MainActivity.class);
        finish();
    }

}
