package com.example.android.proyectokaraoke.Util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

import com.example.android.proyectokaraoke.R;

/**
 * Created by USUARIO1 on 20/03/2016.
 */
public class UtilPiqueoBadge {
    public static void setBadgeCount(Context context, LayerDrawable icon, int count) {

        PiqueoBadgeDrawable badge;

        // Reuse drawable if possible
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof PiqueoBadgeDrawable) {
            badge = (PiqueoBadgeDrawable) reuse;
        } else {
            badge = new PiqueoBadgeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);
    }
}
