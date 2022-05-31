package com.mouhamed_bourouba.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mouhamed_bourouba.quizapp.screen.MainScreen
import com.mouhamed_bourouba.quizapp.screen.QuestionsViewModel
import com.mouhamed_bourouba.quizapp.ui.theme.QuizAppTheme
import com.mouhamed_bourouba.quizapp.utils.AppColors
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAppTheme {
                Surface(
                    color = AppColors.mDarkPurple,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    QuestionsHome()
                }
            }
        }
    }
}

@Composable
fun QuestionsHome(viewModel: QuestionsViewModel = hiltViewModel()) {

    val questions = viewModel.data


    if (questions.value.isLoading!!) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {

        val currentQuestionNumber = remember {
            mutableStateOf(1)
        }

        MainScreen(
            currentQuestionNumber = currentQuestionNumber,
            currentQuestion = questions.value.data!![currentQuestionNumber.value - 1],
            totalQuestions = questions.value.data!!.size,
        ) {
            currentQuestionNumber.value++
        }
    }
}