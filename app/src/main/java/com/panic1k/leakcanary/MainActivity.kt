package com.panic1k.leakcanary

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.os.SystemClock
import android.os.AsyncTask


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = findViewById<View>(R.id.textView)
        view.setOnClickListener { startAsyncTask() }
    }

    @SuppressLint("StaticFieldLeak")
    fun startAsyncTask() {

        // This async task is an anonymous class and therefore has a hidden reference to the outer
        // class MainActivity. If the activity gets destroyed before the task finishes (e.g. rotation),
        // the activity instance will leak.
        object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg params: Void): Void? {
                // Do some slow work in background
                SystemClock.sleep(20000)
                return null
            }
        }.execute()
    }

}



