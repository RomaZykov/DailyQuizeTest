package com.example.dailyquizetest.data.repository

import com.example.dailyquizetest.domain.QuizRepository
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(

) : QuizRepository {
    override suspend fun fetchFiltersCategory() {
        TODO("Not yet implemented")
    }
}