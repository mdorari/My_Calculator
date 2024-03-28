package com.example.mycalculator

data class CalculationHistory(
    val number1: Double,
    val number2: Double,
    val operator:CalculatorOperation,
    val calculationResult: Double
)
