package com.akash.androidcore.toasts;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

class CustomToast {
    static Toast showCustomToast(Context context,
                                 View layout,
                                 @ParameterDefs.ToastLength int duration,
                                 @ParameterDefs.Gravity int gravity,
                                 int xOffset,
                                 int yOffset) {
        Toast t = new Toast(context.getApplicationContext());
        t.setGravity(gravity, xOffset, yOffset);
        t.setDuration(duration);
        t.setView(layout);
        t.show();
        return t;
    }
}
