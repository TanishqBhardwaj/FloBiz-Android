package com.example.stackoverflowapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowapp.R
import com.example.stackoverflowapp.data.api.ApiHelper
import com.example.stackoverflowapp.data.api.RetrofitBuilder
import com.example.stackoverflowapp.ui.adapter.QuestionAdapter
import com.example.stackoverflowapp.data.model.StackOverflowModel
import com.example.stackoverflowapp.ui.viewodel.QuestionViewModel
import com.example.stackoverflowapp.ui.viewodel.ViewModelFactory
import com.example.stackoverflowapp.utils.Status
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity : AppCompatActivity() {

    private lateinit var questionViewModel : QuestionViewModel
    private lateinit var questionAdapter: QuestionAdapter
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Fresco.initialize(this)
        setView()
        setViewModel()
        setObservers()
    }

    private fun setView() {
        recyclerView = findViewById(R.id.recycler_view_questions)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        questionAdapter = QuestionAdapter(arrayListOf())
        recyclerView.adapter = questionAdapter
    }

    private fun setViewModel() {
        questionViewModel = ViewModelProvider(this, ViewModelFactory
            (ApiHelper(RetrofitBuilder.apiService, 2.2,
            "ZiXCZbWaOwnDgpVT9Hx8IA((", "desc", "activity",
            "stackoverflow")))[QuestionViewModel::class.java]

    }

    private fun setObservers() {
        questionViewModel.getQuestions().observe(this, Observer {
            it ?. let {
                resource ->
                when(resource.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        resource.data?.let { stackOverflowModel -> retrieveList(stackOverflowModel) }
                    }
                    Status.ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(stackOverflowModel: StackOverflowModel) {
        questionAdapter.apply {
            setQuestions(stackOverflowModel.questionObjectList)
            notifyDataSetChanged()
        }
    }
}