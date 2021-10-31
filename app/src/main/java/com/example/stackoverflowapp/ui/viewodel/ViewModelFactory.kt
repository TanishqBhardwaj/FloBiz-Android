package com.example.stackoverflowapp.ui.viewodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stackoverflowapp.data.api.ApiHelper
import com.example.stackoverflowapp.data.repository.QuestionRepository

class ViewModelFactory (private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(QuestionViewModel::class.java)) {
//            return QuestionViewModel(QuestionRepository(apiHelper)) as T
//        }
//        throw IllegalArgumentException("Unknown class name")
//    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuestionViewModel::class.java)) {
            return QuestionViewModel(QuestionRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}