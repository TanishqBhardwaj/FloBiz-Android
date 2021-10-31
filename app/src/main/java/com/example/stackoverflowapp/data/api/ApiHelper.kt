package com.example.stackoverflowapp.data.api

class ApiHelper (
    private val apiService: ApiService,
    private val mId : Double,
    private val key : String,
    private val order : String,
    private val sort : String,
    private val site : String) {

    suspend fun getQuestions() = apiService.getQuestions(mId, key, order, sort, site)
}