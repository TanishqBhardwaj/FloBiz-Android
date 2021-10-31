package com.example.stackoverflowapp.ui.adapter

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowapp.R
import com.example.stackoverflowapp.data.model.QuestionItemModel
import com.facebook.drawee.view.SimpleDraweeView

class QuestionAdapter (private val questionList : ArrayList<QuestionItemModel>)
    : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    fun setQuestions(newQuestionList: List<QuestionItemModel>) {
        this.questionList.apply {
            clear()
            addAll(newQuestionList)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_question, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(questionList[position])
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
        val profileImage : SimpleDraweeView = itemView.findViewById(R.id.circle_profile_image)
        val questionTitle : TextView = itemView.findViewById(R.id.text_view_question_title)
        val personName : TextView = itemView.findViewById(R.id.text_view_person_name)
        val date : TextView = itemView.findViewById(R.id.text_view_date)

        fun bind(questionObject : QuestionItemModel) {
            profileImage.setImageURI(Uri.parse(questionObject.profile.profileImage))
            questionTitle.text = questionObject.questionTitle
            personName.text = questionObject.profile.displayName
            date.text = questionObject.creationDate.toString()
        }
    }
}