package com.example.dailyquizetest.data.model.network

import android.accounts.NetworkErrorException
import javax.inject.Inject

interface NetworkQuizDataSource {

//    suspend fun fetchCategories() : Result<List<NetworkCategory>>
//
//    suspend fun fetchDifficulties() : Result<List<NetworkDifficulty>>
//
    class Base @Inject constructor(private val quizApi: QuizApi) : NetworkQuizDataSource {
//        override suspend fun fetchCategories(): Result<List<NetworkCategory>> {
//            return try {
//                val response = quizApi.fetchCategories().body()!!
//                Result.success(response)
//            } catch (e: NetworkErrorException) {
//                Result.failure(e)
//            }
//        }
//
//        override suspend fun fetchDifficulties(): Result<List<NetworkDifficulty>> {
//            return try {
//                val response = quizApi.fetchDifficulties().body()!!
//                Result.success(response)
//            } catch (e: NetworkErrorException) {
//                Result.failure(e)
//            }
//        }
    }
}