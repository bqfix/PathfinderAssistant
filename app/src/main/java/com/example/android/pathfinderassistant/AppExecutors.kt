package com.example.android.pathfinderassistant

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors(val diskIO : Executor) {

    companion object {
        private var sInstance : AppExecutors? = null

        fun getInstance() : AppExecutors? {
            if (sInstance == null) {
                synchronized(AppExecutors::class) {
                    sInstance = AppExecutors(Executors.newSingleThreadExecutor())
                }
            }
            return sInstance
        }
    }
}