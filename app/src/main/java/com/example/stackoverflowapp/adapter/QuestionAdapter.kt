package com.example.stackoverflowapp.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowapp.R
import com.example.stackoverflowapp.model.QuestionModel
import com.facebook.drawee.view.SimpleDraweeView

class QuestionAdapter(private val questionList: List<QuestionModel>)
    : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_question, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val questionModel = questionList[position]
//        holder.profileImage.setImageURI(Uri.parse("https://lh3.googleusercontent.com/a-/AOh14GhJCbBeLN8I2qeRaoER9O1JjOZp7joD-NM5ho9I9g=k-s256"))
        holder.profileImage.setImageURI(Uri.parse(questionModel.image))
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
        val profileImage : SimpleDraweeView = itemView.findViewById(R.id.circle_profile_image)
        val questionTitle : TextView = itemView.findViewById(R.id.text_view_question_title)
        val personName : TextView = itemView.findViewById(R.id.text_view_person_name)
        val date : TextView = itemView.findViewById(R.id.text_view_date)
    }
}