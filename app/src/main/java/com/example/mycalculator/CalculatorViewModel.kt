package com.example.mycalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.math.RoundingMode

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            CalculatorAction.Calculate -> performCalculation()
            CalculatorAction.Clear -> performClarification()
            CalculatorAction.Decimal -> enterDecimal()
            CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.OnHistoryClick -> retrieveHistory(action.history)
            CalculatorAction.OnLongPressOnHistory -> clearHistory()
        }
    }

    private fun clearHistory() {

        state = state.copy(
            history = mutableListOf()
        )
    }

    private fun performClarification() {
        state = state.copy(
            number1 = "",
            number2 = "",
            operation = null
        )
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    private fun performDeletion() {
        when {
            state.number1 == "Infinity" -> state = CalculatorState()
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if (state.number1.isNotBlank() && state.operation == null && !state.number1.contains(".")) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (state.number2.isNotBlank() && state.operation != null && !state.number2.contains(".")) {
            state = state.copy(
                number2 = state.number2 + "."
            )
            return
        }
        if (state.number1.isBlank()) {
            state = state.copy(
                number1 = "0."
            )
            return
        }
        if (state.number2.isBlank() && state.operation != null) {
            state = state.copy(
                number2 = "0."
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                CalculatorOperation.Add -> number1 + number2
                CalculatorOperation.Divide -> number1 / number2
                CalculatorOperation.Multiply -> number1 * number2
                CalculatorOperation.Subtract -> number1 - number2
                null -> return
            }
            val history = state.history.toMutableList().apply {
                add(
                    CalculationHistory(
                        number1,number2,state.operation!!,result
                    )
                )
            }
            state = state.copy(
                number1 = result.toBigDecimal().setScale(2,RoundingMode.CEILING).toString(),
                number2 = "",
                operation = null,
                history = history
            )
        }
    }

    private fun retrieveHistory(history: CalculationHistory){
        state = state.copy(
            number1 = history.number1.toString(),
            number2 = history.number2.toString(),
            operation = history.operator,
        )
    }


    companion object {
        const val MAX_NUM_LENGTH = 8
    }
}