package com.mouhamed_bourouba.quizapp.screen

import android.hardware.camera2.TotalCaptureResult
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mouhamed_bourouba.quizapp.component.ChoiceButtons
import com.mouhamed_bourouba.quizapp.component.NextButton
import com.mouhamed_bourouba.quizapp.component.QuestionText
import com.mouhamed_bourouba.quizapp.component.QuestionsTracker
import com.mouhamed_bourouba.quizapp.data.Data
import com.mouhamed_bourouba.quizapp.model.QuestionsItem

@Composable
fun MainScreen(
    totalQuestions: Int,
    currentQuestionNumber: MutableState<Int>,
    currentQuestion: QuestionsItem,
    onNextClickListener: () -> Unit,
    ) {

    val choicesState = remember(currentQuestion) { currentQuestion.choices.toMutableList() }

    val answerState = remember(currentQuestion) { mutableStateOf<Int?>(null) }

    val correctAnswer = remember(currentQuestion) { mutableStateOf<Boolean?>(null) }

    val updateAnswer: (Int) -> Unit = {
        correctAnswer.value = choicesState[it] == currentQuestion.answer
    }

    val currentQuestionText = remember(currentQuestion) { mutableStateOf(currentQuestion.question)}


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 12.dp,
                end = 12.dp,
                top = 8.dp
            ),
        contentAlignment = Alignment.TopStart
    ) {
        Column {
            QuestionsTracker(currentQuestionsNumber = currentQuestionNumber.value,
                totalQuestionsNumber = totalQuestions)

            Divider(Modifier.padding(bottom = 8.dp))

            QuestionText(currentQuestionText)

           choicesState.forEachIndexed { index, answer ->
                ChoiceButtons(
                    corectAnswerState = correctAnswer,
                    answer = answer,
                    selected = answerState.value == index,
                ) {
                    answerState.value = index
                    updateAnswer(index)
                }
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))

            NextButton {
                onNextClickListener.invoke()
            }

        }
    }

}



