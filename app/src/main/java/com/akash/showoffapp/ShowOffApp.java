package com.akash.showoffapp;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

//TODO: Localization
//TODO: UI & UX
//TODO: Services (Youtube player, background support)
//TODO: Broadcast Receivers
//TODO: More options in Notifications Library

public class ShowOffApp extends Application {

    public static <T extends AppCompatActivity> void launch(Context context, Class<T> activityClass) {
        Intent intent = new Intent(context, activityClass);
        context.startActivity(intent);
    }

}
