package com.mouhamed_bourouba.quizapp.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mouhamed_bourouba.quizapp.utils.AppColors

@Composable
fun QuestionsTracker(currentQuestionsNumber: Int, totalQuestionsNumber: Int) {
    Text(
        text = buildAnnotatedString {
        withStyle(style = SpanStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = AppColors.mLightGray
        )) {
            append("Question $currentQuestionsNumber/")
        }
        withStyle(style = SpanStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = AppColors.mOffDarkPurple
        )) {
            append("$totalQuestionsNumber")
        }

    },
        modifier = Modifier.padding(20.dp)
    )
}