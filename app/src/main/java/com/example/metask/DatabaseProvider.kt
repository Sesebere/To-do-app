package com.example.metask

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    var INSTANCE: TaskDatabase? = null
    fun getDatabase(context: Context): TaskDatabase{
        synchronized(this) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "taskDb"
                ).build()
            }
            return INSTANCE!!
        }
    }
}