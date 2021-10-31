package com.example.stackoverflowapp.data.model

import com.google.gson.annotations.SerializedName

//model of each object of stackoverflow question response
data class QuestionItemModel (
    @SerializedName("tags")
    val tagList : List<String>,

    @SerializedName("owner")
    val profile : OwnerModel,

    @SerializedName("view_count")
    val viewCount : Int,

    @SerializedName("answer_count")
    val answerCount : Int,

    @SerializedName("creation_date")
    val creationDate : Int,

    @SerializedName("link")
    val questionLink : String,

    @SerializedName("title")
    val questionTitle : String

)