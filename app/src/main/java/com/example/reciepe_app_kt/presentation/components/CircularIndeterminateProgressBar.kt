package com.example.reciepe_app_kt.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun CircularIndeterminateProgressBar(
    isDisplayed:Boolean,
){
    if (isDisplayed) ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (progressBar, text) = createRefs()
        val topGuideline = createGuidelineFromTop(0.2f)

        CircularProgressIndicator(
            modifier = Modifier.constrainAs(progressBar) {
                top.linkTo(topGuideline)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            color = MaterialTheme.colors.primary
        )
        Text(
            text = "Loading recipes...",
            style = TextStyle(
                color = MaterialTheme.colors.primary,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.constrainAs(text) {
                top.linkTo(progressBar.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }

}