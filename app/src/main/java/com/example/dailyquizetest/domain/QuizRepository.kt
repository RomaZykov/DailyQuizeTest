package com.example.dailyquizetest.domain

interface QuizRepository {
    suspend fun fetchFiltersCategory()
}
