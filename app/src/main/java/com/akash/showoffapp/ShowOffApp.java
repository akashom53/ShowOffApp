package com.akash.showoffapp;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class ShowOffApp extends Application {

    public static <T extends AppCompatActivity> void launch(Context context, Class<T> activityClass) {
        Intent intent = new Intent(context, activityClass);
        context.startActivity(intent);
    }

}
