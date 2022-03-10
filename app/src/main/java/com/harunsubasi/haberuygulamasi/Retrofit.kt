package com.harunsubasi.haberuygulamasi

import com.harunsubasi.haberuygulamasi.model.News
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Retrofit  {


        // https://newsapi.org/v2/top-headlines
        @GET("v2/top-headlines?country=tr&apiKey=e4ee2e102ed34a58aea1669b7fe5991a")
        fun getNews(): Call<News>





}