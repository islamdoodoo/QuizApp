package com.mouhamed_bourouba.quizapp.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mouhamed_bourouba.quizapp.model.Questions
import com.mouhamed_bourouba.quizapp.model.QuestionsItem
import com.mouhamed_bourouba.quizapp.utils.AppColors

@Composable
fun QuestionText(
    questions: MutableState<String>,
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f),
        style = TextStyle(
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = AppColors.mOffWhite
        ),
        text = questions.value
    )
}