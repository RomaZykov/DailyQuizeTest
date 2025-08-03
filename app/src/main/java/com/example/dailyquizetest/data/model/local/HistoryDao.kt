package com.example.dailyquizetest.data.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(quizResult: LocalQuizResult)

    @Query("SELECT * FROM history_table")
    suspend fun getHistoryQuizResults(): List<LocalQuizResult>
}