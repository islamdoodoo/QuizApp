package com.mouhamed_bourouba.quizapp.network

import com.mouhamed_bourouba.quizapp.model.Questions
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionsApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Questions
}