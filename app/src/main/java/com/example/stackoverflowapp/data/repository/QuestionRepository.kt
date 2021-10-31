package com.example.stackoverflowapp.data.repository

import com.example.stackoverflowapp.data.api.ApiHelper

class QuestionRepository (private val apiHelper: ApiHelper){

    suspend fun getQuestions() = apiHelper.getQuestions()
}