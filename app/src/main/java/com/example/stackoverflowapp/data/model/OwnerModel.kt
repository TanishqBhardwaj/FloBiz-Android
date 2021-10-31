package com.example.stackoverflowapp.data.model

import com.google.gson.annotations.SerializedName

data class OwnerModel (

        @SerializedName("profile_image")
        val profileImage : String = "",

        @SerializedName("display_name")
        val displayName : String = ""
)