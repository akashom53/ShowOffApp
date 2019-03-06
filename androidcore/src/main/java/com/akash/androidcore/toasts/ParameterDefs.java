package com.akash.androidcore.toasts;

import androidx.annotation.IntDef;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class ParameterDefs {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Toast.LENGTH_SHORT, Toast.LENGTH_LONG})
    @interface ToastLength {
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef(flag = true, value = {
            android.view.Gravity.TOP,
            android.view.Gravity.START,
            android.view.Gravity.BOTTOM,
            android.view.Gravity.END
    })
    @interface Gravity {
    }
}
