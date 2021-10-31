package com.example.stackoverflowapp.data.model

import com.google.gson.annotations.SerializedName

data class StackOverflowModel (
    @SerializedName("items")
    val questionObjectList : List<QuestionItemModel>
    )