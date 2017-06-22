package com.kbeanie.runner;

import android.app.Application;
import android.content.Context;

/**
 * Created by vidushi on 19/6/17.
 */

public class RunnerApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }
}
