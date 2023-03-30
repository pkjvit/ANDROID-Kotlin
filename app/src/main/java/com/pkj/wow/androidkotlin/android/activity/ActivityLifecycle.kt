package com.pkj.wow.androidkotlin.android.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pkj.wow.androidkotlin.R

class ActivityLifecycle : AppCompatActivity() {

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("PLOG", "ActivityLifecycle->onNewIntent: ${intent?.extras.toString()}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PLOG", "ActivityLifecycle->onCreate: ${savedInstanceState.toString()}")
        setContentView(R.layout.activity_lifecycle)
    }


    override fun onRestart() {
        super.onRestart()
        Log.d("PLOG", "ActivityLifecycle->onRestart: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d("PLOG", "ActivityLifecycle->onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("PLOG", "ActivityLifecycle->onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("PLOG", "ActivityLifecycle->onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("PLOG", "ActivityLifecycle->onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("PLOG", "ActivityLifecycle->onDestroy: ")
    }
}