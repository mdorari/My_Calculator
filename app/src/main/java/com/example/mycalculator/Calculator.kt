package com.example.mycalculator

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.components.CalculatorHistory
import com.example.mycalculator.components.CalculatorKeyboard

import java.math.RoundingMode

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Calculator(
    modifier: Modifier,
    state: CalculatorState,
    buttonSpacing: Dp,
    onAction: (CalculatorAction) -> Unit
) {
    val configuration = LocalConfiguration.current
    if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        Row(
            modifier = modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.fillMaxHeight().width(400.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End) {
                Text(
                    text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    textAlign = TextAlign.End,
                    fontSize = 32.sp,
                    color = colorResource(id = R.color.button_grey),
                    maxLines = 2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
                        .height(60.dp)
                )
                CalculatorHistory(
                    state = state,
                    onAction = onAction,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(400.dp)
                )
            }
            CalculatorKeyboard(
                modifier = Modifier.fillMaxHeight().aspectRatio(1f),
                state = state,
                buttonSpacing = (buttonSpacing),
                isVertical = false,
                onAction = onAction
            )
//            Column(
//                Modifier.weight(1f),
//                verticalArrangement = Arrangement.SpaceBetween,
//                horizontalAlignment = Alignment.End
//            ) {
//            }
        }
    } else {
        Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
            CalculatorHistory(
                state = state,
                onAction = onAction,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                fontSize = 42.sp,
                color = colorResource(id = R.color.button_grey),
                maxLines = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
                    .height(110.dp)
            )
            CalculatorKeyboard(
                modifier = Modifier,
                state = state,
                buttonSpacing = buttonSpacing,
                isVertical = true,
                onAction = onAction
            )
        }
    }
}

//@Composable
//@Preview(
//    device = "spec:parent=pixel_7_pro,orientation=landscape",
//    showSystemUi = true,
//    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
//    wallpaper = Wallpapers.NONE, showBackground = true,
//)
//fun CalculatorPreview() {
//    Calculator(modifier = Modifier
//        .padding(8.dp)
//        .fillMaxSize(), state = CalculatorState(
//        "1", "2", CalculatorOperation.Add,
//        mutableListOf(
//            CalculationHistory(
//                number1 = 1.0,
//                number2 = 2.0,
//                operator = CalculatorOperation.Add,
//                calculationResult = 3222.0000000004
//            )
//        )
//    ), buttonSpacing = 8.dp, onAction = {})
//}