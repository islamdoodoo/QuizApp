package com.mouhamed_bourouba.quizapp.di

import com.mouhamed_bourouba.quizapp.network.QuestionsApi
import com.mouhamed_bourouba.quizapp.repository.QuestionsRepository
import com.mouhamed_bourouba.quizapp.utils.Constents
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModel {

    @Provides
    @Singleton
    fun providesRepository(api: QuestionsApi) = QuestionsRepository(api)

    @Provides
    @Singleton
    fun providesRetrofit(): QuestionsApi = Retrofit.Builder()
        .baseUrl(Constents.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(QuestionsApi::class.java)

}