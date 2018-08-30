package com.panic1k.leakcanary

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

class LeakApplication : Application() {

    var refwatcher: RefWatcher? = null


    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        refwatcher = LeakCanary.install(this);
    }
}
