package com.example.stackoverflowapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://api.stackexchange.com/"
    private var client = OkHttpClient.Builder()
    private var logging = HttpLoggingInterceptor()

    private fun getRetrofit(): Retrofit {

        logging.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}
