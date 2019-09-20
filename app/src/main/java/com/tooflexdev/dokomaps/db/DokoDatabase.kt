package com.tooflexdev.dokomaps.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tooflexdev.dokomaps.model.weather.CityWeather
import kotlinx.coroutines.CoroutineScope

abstract class DokoDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: DokoDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): DokoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DokoDatabase::class.java,
                    "DOKO_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}