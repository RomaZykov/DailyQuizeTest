package com.example.dailyquizetest.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dailyquizetest.data.mapper.Mapper
import com.example.dailyquizetest.data.model.QuizResult

@Entity(tableName = "history_table")
data class LocalQuizResult(
    @PrimaryKey @ColumnInfo(name = "quiz_result_id") val id: Long,
    @ColumnInfo(name = "quiz_number") val quizNumber: Int,
    @ColumnInfo(name = "stars") val stars: Int,
    @ColumnInfo(name = "last_time") val lastTime: Long,
    @ColumnInfo(name = "last_date") val lastDate: Long
) : Mapper<QuizResult> {
    override fun mappedValue(): QuizResult {
        return QuizResult(
            id = this.id,
            quizNumber = this.quizNumber,
            time = this.lastTime,
            date = this.lastDate
        )
    }
}