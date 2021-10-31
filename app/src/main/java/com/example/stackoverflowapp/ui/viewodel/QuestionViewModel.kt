package com.example.stackoverflowapp.ui.viewodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowapp.data.repository.QuestionRepository
import com.example.stackoverflowapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class QuestionViewModel (private val questionRepository: QuestionRepository) : ViewModel() {

    fun getQuestions() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = questionRepository.getQuestions()))
        }
        catch (exception : Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}