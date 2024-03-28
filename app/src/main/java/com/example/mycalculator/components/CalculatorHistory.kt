package com.example.mycalculator.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.CalculatorAction
import com.example.mycalculator.CalculatorState
import java.math.RoundingMode

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalculatorHistory(
    modifier: Modifier = Modifier,
    state: CalculatorState,
    onAction: (CalculatorAction) -> Unit
) {
    val listSate = rememberLazyListState()
    val calculationHistoryList = state.history
    LaunchedEffect(calculationHistoryList){
        listSate.animateScrollToItem(listSate.layoutInfo.totalItemsCount)
    }
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.Start,
        state = listSate
    ) {
        items(calculationHistoryList){item->
            Text(
                modifier = Modifier
                    .padding(top = 2.dp, bottom = 2.dp)
                    .clickable(
                        onClick = { onAction(CalculatorAction.OnHistoryClick(item)) }
                    )
                    .combinedClickable(
                        onClick = { onAction(CalculatorAction.OnHistoryClick(item)) },
                        onLongClick = { onAction(CalculatorAction.OnLongPressOnHistory) }
                    ),
                text = "${item.number1} " +
                        item.operator.symbol +
                        " ${item.number2}" +
                        " = " +
                        item.calculationResult.toBigDecimal().setScale(2, RoundingMode.CEILING),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 20.sp,
                textAlign = TextAlign.End,
            )
        }
    }
}