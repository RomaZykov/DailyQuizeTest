package com.example.dailyquizetest.data.model.network

import retrofit2.Response
import retrofit2.http.GET

interface QuizApi {

//    @GET("tv/{category}")
//    suspend fun getTvShowLists(
//        @Path("category") category: String,
//        @Query("language") language: String = "en-US",
//        @Query("page") page: Int
//    ): NetworkContentResponse

//    @GET("api_category.php")
//    suspend fun fetchCategories(): Response<List<NetworkCategory>>
//
//    @GET("difficulty")
//    suspend fun fetchDifficulties(): Response<List<NetworkDifficulty>>

    companion object {
        const val BASE_URL = "https://opentdb.com"
    }
}