package com.akash.androidcore.toasts;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.akash.androidcore.R;

public class ToastLibrary {

    //region Basic Toast

    public static Toast showBasicToast(Context context,
                                       String message,
                                       @ParameterDefs.ToastLength int duration,
                                       @ParameterDefs.Gravity int gravity,
                                       int xOffset,
                                       int yOffset
    ) {
        return SimpleToast.showBasicToast(context, message, duration, gravity, xOffset, yOffset);
    }


    public static Toast showBasicToast(Context context, String message) {
        return showBasicToast(
                context,
                message, Toast.LENGTH_SHORT,
                Gravity.BOTTOM,
                0,
                context.getResources().getDimensionPixelOffset(R.dimen.default_toast_y_offset)
        );
    }

    //endregion

    //region Custom Toast

    public static Toast showCustomToast(Context context,
                                        View layout,
                                        @ParameterDefs.ToastLength int duration,
                                        @ParameterDefs.Gravity int gravity,
                                        int xOffset,
                                        int yOffset) {
        return CustomToast.showCustomToast(context, layout, duration, gravity, xOffset, yOffset);
    }

    public static Toast showCustomToast(Context context,
                                        View layout) {
        return showCustomToast(
                context,
                layout,
                Toast.LENGTH_SHORT,
                Gravity.BOTTOM,
                0,
                context.getResources().getDimensionPixelOffset(R.dimen.default_toast_y_offset)
        );
    }

    //endregion

}
