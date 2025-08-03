package com.example.dailyquizetest.data.model.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LocalQuizResult::class], version = 1, exportSchema = false)
abstract class HistoryDataBase : RoomDatabase() {

    abstract fun historyDao(): HistoryDao

    companion object {

        private var INSTANCE: HistoryDataBase? = null
        private val LOCK = Any()

        fun getInstance(application: Application): HistoryDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    HistoryDataBase::class.java,
                    "history_table"
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}
