package com.cxy.android.xkits;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;

/**
 * Author: xyc000
 * Description: </br>
 * Date: 2017/3/2 0002
 */
public class TelephoneUtil {

    /**
     * 当前网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkEnable(Context context) {
        if (context == null) {
            return false;
        }

        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo info = cm.getActiveNetworkInfo();
                if (info != null) {
                    return info.isAvailable();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 当前是否正在使用wifi
     *
     * @param context
     * @return
     */
    public static boolean isWifiEnable(Context context) {
        if (context == null) {
            return false;
        }

        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo info = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                NetworkInfo active = cm.getActiveNetworkInfo();
                if (info != null && active != null) {
                    return info.getType() == active.getType();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 是否正在使用移动网络
     *
     * @param context
     * @return
     */
    public static boolean isMobileEnable(Context context) {
        if (context == null) {
            return false;
        }

        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo info = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                NetworkInfo active = cm.getActiveNetworkInfo();
                if (info != null && active != null) {
                    return info.getType() == active.getType();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * warning: need permission : android.permission.READ_PHONE_STATE
     *
     * @param context
     * @return
     */
    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = getTelephonyManager(context);
        return telephonyManager.getDeviceId();
    }

    /**
     * warning: need permission : android.permission.READ_PHONE_STATE
     *
     * @param context
     * @return
     */
    public static String getIMSI(Context context) {
        TelephonyManager telephonyManager = getTelephonyManager(context);
        return telephonyManager.getSubscriberId();
    }

    public static boolean isSimExists(Context context) {
        TelephonyManager telephonyManager = getTelephonyManager(context);
        return telephonyManager.getSimState() != 1;
    }

    public static String getReleaseVersion() {
        return Build.VERSION.RELEASE;
    }

    public static ActivityManager.MemoryInfo getMemoryInfo(Context context) {
        ActivityManager activityManager = getActivityManager(context);
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(info);

        return info;
    }

    private static ActivityManager getActivityManager(Context context) {
        return (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager;
    }
}
