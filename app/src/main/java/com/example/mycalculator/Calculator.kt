package com.example.mycalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.ui.theme.LightGray
import com.example.mycalculator.ui.theme.Orange

@Composable
fun Calculator(
    modifier: Modifier,
    state: CalculatorState,
    buttonSpacing: Dp,
    onAction: (CalculatorAction) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                horizontalAlignment = Alignment.Start
            ) {
                items(state.history.size) {
                    Text(
                        text = state.history[it],
                        color = LightGray,
                        fontSize = 18.sp,
                        textAlign = TextAlign.End
                    )
                }
            }
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                fontSize = 32.sp,
                color = Color.White,
                maxLines = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                        .background(LightGray),
                    symbol = "AC",
                    onClick = { onAction(CalculatorAction.Clear) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    symbol = "DEL",
                    onClick = { onAction(CalculatorAction.Delete) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Orange),
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
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    symbol = "9",
                    onClick = { onAction(CalculatorAction.Number(9)) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    symbol = "8",
                    onClick = { onAction(CalculatorAction.Number(8)) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    symbol = "7",
                    onClick = { onAction(CalculatorAction.Number(7)) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Orange),
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
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    symbol = "6",
                    onClick = { onAction(CalculatorAction.Number(6)) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    symbol = "5",
                    onClick = { onAction(CalculatorAction.Number(5)) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    symbol = "4",
                    onClick = { onAction(CalculatorAction.Number(4)) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Orange),
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
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    symbol = "3",
                    onClick = { onAction(CalculatorAction.Number(3)) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    symbol = "2",
                    onClick = { onAction(CalculatorAction.Number(2)) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    symbol = "1",
                    onClick = { onAction(CalculatorAction.Number(1)) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Orange),
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
                        .aspectRatio(2f)
                        .weight(2f)
                        .background(LightGray),
                    symbol = "0",
                    onClick = { onAction(CalculatorAction.Number(0)) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(LightGray),
                    symbol = ".",
                    onClick = { onAction(CalculatorAction.Decimal) })
                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .background(Orange),
                    symbol = "=",
                    onClick = { onAction(CalculatorAction.Calculate) })
            }
        }
    }
}