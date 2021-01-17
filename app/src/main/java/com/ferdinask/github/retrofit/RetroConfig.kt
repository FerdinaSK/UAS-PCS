package com.ferdinask.github.retrofit

import com.ferdinask.github.retrofit.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroConfig {

    companion object Factory{
        fun getRetrofit() : ApiService {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)

        }
    }
}