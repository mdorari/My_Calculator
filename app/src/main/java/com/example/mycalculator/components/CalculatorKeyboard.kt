package com.example.mycalculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import com.example.mycalculator.CalculatorAction
import com.example.mycalculator.CalculatorButton
import com.example.mycalculator.CalculatorOperation
import com.example.mycalculator.CalculatorState
import com.example.mycalculator.R

@Composable
fun CalculatorKeyboard(
    modifier: Modifier,
    state: CalculatorState,
    buttonSpacing: Dp,
    isVertical: Boolean,
    onAction: (CalculatorAction) -> Unit
) {
    Column(
        modifier = modifier
//            .align(Alignment.BottomCenter),
        ,
        verticalArrangement = Arrangement.spacedBy(buttonSpacing),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        CalculatorHistory(state = state, onAction = onAction)
//        Text(
//            text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
//            textAlign = TextAlign.End,
//            fontSize = 42.sp,
//            color = MaterialTheme.colorScheme.primary,
//            maxLines = 2,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
//                .height(110.dp)
//        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 3f else 2f)
                    .weight(2f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "AC",
                onClick = { onAction(CalculatorAction.Clear) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 1f)
                    .weight(1f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "DEL",
                onClick = { onAction(CalculatorAction.Delete) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 2f)
                    .weight(if (isVertical) 1f else 2f)
                    .background(colorResource(id = R.color.button_orange)),
                symbol = "/",
                onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Divide)) })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 1f)
                    .weight(1f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "9",
                onClick = { onAction(CalculatorAction.Number(9)) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 1f)
                    .weight(1f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "8",
                onClick = { onAction(CalculatorAction.Number(8)) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 1f)
                    .weight(1f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "7",
                onClick = { onAction(CalculatorAction.Number(7)) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 2f)
                    .weight(if (isVertical) 1f else 2f)
                    .background(colorResource(id = R.color.button_orange)),
                symbol = "x",
                onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Multiply)) })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 1f)
                    .weight(1f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "6",
                onClick = { onAction(CalculatorAction.Number(6)) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 1f)
                    .weight(1f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "5",
                onClick = { onAction(CalculatorAction.Number(5)) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 1f)
                    .weight(1f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "4",
                onClick = { onAction(CalculatorAction.Number(4)) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 2f)
                    .weight(if (isVertical) 1f else 2f)
                    .background(colorResource(id = R.color.button_orange)),
                symbol = "+",
                onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Add)) })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 1f)
                    .weight(1f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "3",
                onClick = { onAction(CalculatorAction.Number(3)) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 1f)
                    .weight(1f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "2",
                onClick = { onAction(CalculatorAction.Number(2)) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 1f)
                    .weight(1f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "1",
                onClick = { onAction(CalculatorAction.Number(1)) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 2f)
                    .weight(if (isVertical) 1f else 2f)
                    .background(colorResource(id = R.color.button_orange)),
                symbol = "-",
                onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Subtract)) })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 3f else 2f)
                    .weight(2f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = "0",
                onClick = { onAction(CalculatorAction.Number(0)) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 1f)
                    .weight(1f)
                    .background(colorResource(id = R.color.button_grey)),
                symbol = ".",
                onClick = { onAction(CalculatorAction.Decimal) })
            CalculatorButton(
                modifier = Modifier
                    .aspectRatio(if (isVertical) 1.5f else 2f)
                    .weight(if (isVertical) 1f else 2f)
                    .background(colorResource(id = R.color.button_orange)),
                symbol = "=",
                onClick = { onAction(CalculatorAction.Calculate) })
        }
    }
}