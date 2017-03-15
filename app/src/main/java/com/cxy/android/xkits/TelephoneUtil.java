package com.cxy.android.xkits;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

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

}
