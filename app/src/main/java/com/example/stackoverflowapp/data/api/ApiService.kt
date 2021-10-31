package com.example.stackoverflowapp.data.api

import com.example.stackoverflowapp.data.model.StackOverflowModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("{id}/questions")
    suspend fun getQuestions(@Path("id") mId : Double,
                             @Query("key") key : String,
                             @Query("order") order : String,
                             @Query("sort") sort : String,
                             @Query("site") site : String ) : StackOverflowModel
}