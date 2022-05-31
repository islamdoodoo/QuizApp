package com.mouhamed_bourouba.quizapp.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mouhamed_bourouba.quizapp.data.Data
import com.mouhamed_bourouba.quizapp.model.QuestionsItem
import com.mouhamed_bourouba.quizapp.repository.QuestionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val questionsRepository: QuestionsRepository) :
    ViewModel() {

    val data: MutableState<Data<
            ArrayList<QuestionsItem>,
            Boolean,
            Exception>> = mutableStateOf(
                Data(
                    isLoading = true,
                    data = null,
                    exception = null
                )
            )

    init {
        getAllQuestions()
    }


    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.isLoading = true
            data.value = questionsRepository.getData()
            if (data.value.data.toString().isNotEmpty()) {
                data.value.isLoading = false
            }
        }
    }
}