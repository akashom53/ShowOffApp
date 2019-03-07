package com.akash.androidcore.snackbars;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SnackbarLibrary {

    public static Snackbar showSimpleSnackbar(View view, String message, @ParameterDefs.SnackbarLength int duration) {
        Snackbar snackbar = Snackbar.make(view, message, duration);
        snackbar.show();
        return snackbar;
    }

    public static Snackbar showSnackbarWithAction(
            View view,
            String message,
            String actionString,
            @ParameterDefs.SnackbarLength int duration,
            View.OnClickListener actionClickListener
    ) {
        Snackbar snackbar = Snackbar.make(view, message, duration);
        snackbar.setAction(actionString, actionClickListener);
        snackbar.show();
        return snackbar;
    }

}
