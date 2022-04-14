package com.example.newsly

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/everything?q=tesla&from=2022-03-09&sortBy=publishedAt&apiKey=940efacbc8c247559b3196af9f25b23e
//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=940efacbc8c247559b3196af9f25b23e

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "940efacbc8c247559b3196af9f25b23e"
interface NewsInterface{

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String, @Query("page")page: Int): Call<News>
}

object NewsService{
    val newsInstance: NewsInterface
    init {
         val retrofit = Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}