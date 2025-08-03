package com.example.dailyquizetest.data.repository

import com.example.dailyquizetest.data.model.network.NetworkQuizDataSource
import com.example.dailyquizetest.domain.QuizRepository
import com.example.dailyquizetest.domain.model.Category
import com.example.dailyquizetest.domain.model.Difficulty
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val networkQuizDataSource: NetworkQuizDataSource
) : QuizRepository {
//    override suspend fun fetchCategories(): Result<List<Category>> {
//        return try {
//            val categories = networkQuizDataSource.fetchCategories().map {
//                it.map { networkCategory ->
//                    networkCategory.mappedValue()
//                }
//            }
//            categories
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//
//    override suspend fun fetchDifficulties(): Result<List<Difficulty>> {
//        return try {
//            val difficulties = networkQuizDataSource.fetchDifficulties().map {
//                it.map { networkDifficulty ->
//                    networkDifficulty.mappedValue()
//                }
//            }
//            difficulties
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
}