package com.tooflexdev.dokomaps.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tooflexdev.dokomaps.model.*
import com.tooflexdev.dokomaps.model.weather.CityWeather
import com.tooflexdev.dokomaps.util.Converters
import kotlinx.coroutines.CoroutineScope

/*@Database(entities = [
    Category::class,
    Country::class,
    CountryGeojson::class,
    DokoMap::class,
    Geometry::class,
    Owner::class,
    Photo::class,
    Place::class,
    Properties::class,
    Review::class,
    TopCity::class,
    TopCountry::class,
    TopSearch::class,
    TopTag::class],
    version = 1)*/
@TypeConverters(Converters::class)
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