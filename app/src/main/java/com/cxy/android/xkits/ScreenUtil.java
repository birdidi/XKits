package com.cxy.android.xkits;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Author: xyc000
 * Description: </br>
 * Date: 2017/3/15 0015
 */
public class ScreenUtil {

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }

        DisplayMetrics metrics = getDisplayMetrics(context);
        return metrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }

        DisplayMetrics metrics = getDisplayMetrics(context);
        return metrics.heightPixels;
    }

    /**
     * 获取当前活动中的屏幕区域（<= full Screen size）
     *
     * @param context
     * @return
     */
    public static Point getRealScreenSize(Context context) {
        Point size = new Point();
        if (context == null) {
            return size;
        }

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(size);
        } else if (Build.VERSION.SDK_INT >= 14) {
            try {
                size.x = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
                size.y = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return size;
    }

    /**
     * pixel convert to dpi base on current screen density
     *
     * @param context
     * @param pixel
     * @return
     */
    public static int px2dp(Context context, int pixel) {
        return (int) (pixel / getDensity(context));
    }

    /**
     * dpi convert to pixel base on current screen density
     *
     * @param context
     * @param dpi
     * @return
     */
    public static float dp2px(Context context, int dpi) {
        return (dpi * getDensity(context));
    }

    /**
     * get current screen density
     *
     * @param context
     * @return
     */
    public static float getDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics;
    }

    /**
     * 获取action bar 高度
     *
     * @param context
     * @return
     */
    public static int getActionBarHeight(Context context) {
        Resources resources = context.getResources();
        int resId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            return resources.getDimensionPixelSize(resId);
        }
        return 0;
    }

    /**
     * 获取navigation bar 高度
     *
     * @param context
     * @return
     */
    public static int getNavigationHeight(Context context) {
        Resources resources = context.getResources();
        int orientation = resources.getConfiguration().orientation;
        int resId = resources.getIdentifier((orientation == Configuration.ORIENTATION_LANDSCAPE ? "navigation_bar_height_landscape" : "navigation_bar_height")
                , "dimen", "android");
        if (resId > 0) {
            return resources.getDimensionPixelSize(resId);
        }
        return 0;
    }

    /**
     * 是否有navigation bar
     *
     * @param context
     * @return
     */
    public static boolean hasNavigationBar(Context context) {
        Resources resources = context.getResources();
        int resId = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (resId > 0) {
            return resources.getBoolean(resId);
        }
        return false;
    }
}
