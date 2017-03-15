package com.cxy.android.xkits;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * activity collector be convenient for yourself activity manage
 */
public class ActivityCollector {

    private static List<Activity> queue = new ArrayList<Activity>();

    public static synchronized void add(Activity activity){
        queue.add(activity);
    }

    public static synchronized boolean remove(Activity activity){
        return queue.remove(activity);
    }

    public static synchronized void remove(int delIndex){
        queue.remove(delIndex);
    }

    public static synchronized void finishAll(){
        for (Activity ac: queue) {
            if(ac != null && !ac.isFinishing()){
                ac.finish();
            }
        }
    }

    public static synchronized void clear(){
        queue.clear();
    }
}
