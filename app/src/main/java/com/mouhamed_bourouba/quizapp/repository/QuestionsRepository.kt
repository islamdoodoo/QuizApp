package com.mouhamed_bourouba.quizapp.repository

import com.mouhamed_bourouba.quizapp.data.Data
import com.mouhamed_bourouba.quizapp.model.QuestionsItem
import com.mouhamed_bourouba.quizapp.network.QuestionsApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuestionsRepository @Inject constructor(private val api: QuestionsApi) {
    private val dataOrException = Data<ArrayList<QuestionsItem>, Boolean, Exception>(
        data = ArrayList(),
        isLoading = true,
        exception = null
    )
    suspend fun getData(): Data<ArrayList<QuestionsItem>, Boolean, Exception> {
        return try {
            dataOrException.isLoading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.isNullOrEmpty()) {
                dataOrException.isLoading = false
            } else {
                dataOrException.isLoading = false
            }
            dataOrException
        } catch (e: Exception) {
            dataOrException.exception = e
            dataOrException.isLoading = false
            dataOrException
        }
    }
}