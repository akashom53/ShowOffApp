package com.akash.androidcore.snackbars;


import com.google.android.material.snackbar.Snackbar;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

public class ParameterDefs {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Snackbar.LENGTH_SHORT, Snackbar.LENGTH_LONG, Snackbar.LENGTH_INDEFINITE})
    @interface SnackbarLength {
    }
}
