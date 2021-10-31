package com.example.stackoverflowapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowapp.R
import com.example.stackoverflowapp.adapter.QuestionAdapter
import com.example.stackoverflowapp.model.QuestionModel
import com.facebook.drawee.backends.pipeline.Fresco
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Fresco.initialize(this)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_questions)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fakeData = ArrayList<QuestionModel>()

        for (i in 1..10) {
            fakeData.add(QuestionModel("https://lh3.googleusercontent.com/a-/AOh14GhJCbBeLN8I2qeRaoER9O1JjOZp7joD-NM5ho9I9g=k-s256",
                "Question $i", "Tanishq", "Posted On : Date"))
        }

        val adapter = QuestionAdapter(fakeData)
        recyclerView.adapter = adapter
    }
}