package com.example.android.navigation.Controllers

import android.app.Application
import timber.log.Timber

class QuizApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}