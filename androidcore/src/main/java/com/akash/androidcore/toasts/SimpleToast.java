package com.akash.androidcore.toasts;

import android.content.Context;
import android.widget.Toast;


class SimpleToast {
    static Toast showBasicToast(Context context,
                                       String message,
                                       @ParameterDefs.ToastLength int duration,
                                       @ParameterDefs.Gravity int gravity,
                                       int xOffset,
                                       int yOffset
    ) {
        Toast t = Toast.makeText(context.getApplicationContext(), message, duration);
        t.setGravity(gravity, xOffset, yOffset);
        t.show();
        return t;
    }

}
