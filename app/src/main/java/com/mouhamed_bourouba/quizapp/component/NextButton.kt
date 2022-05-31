package com.mouhamed_bourouba.quizapp.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mouhamed_bourouba.quizapp.utils.AppColors

@Composable
fun NextButton(
    onClick: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(300.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.mBlue,
            )
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "Next",
                color = AppColors.mOffWhite,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
