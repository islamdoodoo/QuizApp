package com.mouhamed_bourouba.quizapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mouhamed_bourouba.quizapp.utils.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChoiceButtons(
    answer: String,
    selected: Boolean,
    corectAnswerState: MutableState<Boolean?>,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 4.dp, brush = Brush.linearGradient(
                colors = listOf(
                    AppColors.mOffDarkPurple,
                    AppColors.mOffDarkPurple
                ),
            ),
                shape = RoundedCornerShape(15.dp)
            )
            .background(Color.Transparent)
            .height(50.dp)
            .clickable {
                onClick.invoke()
            },
        verticalAlignment = Alignment.CenterVertically

    ) {
        RadioButton(
            selected = selected,
            onClick = { onClick.invoke() },
            modifier = Modifier
                .padding(8.dp),
            colors = RadioButtonDefaults.colors(
                if (corectAnswerState.value == true) {
                    Color.Green.copy(alpha = 0.4f)
                } else {
                    Color.Red.copy(alpha = 0.4f)
                }
            )
        )

        Text(
            text = answer,
            modifier = Modifier.padding(8.dp),
            style = TextStyle(
                fontWeight = FontWeight.Thin,
                fontSize = 20.sp,
                color = AppColors.mOffWhite
            )
        )

    }

    Spacer(modifier = Modifier.padding(bottom = 8.dp))
}
