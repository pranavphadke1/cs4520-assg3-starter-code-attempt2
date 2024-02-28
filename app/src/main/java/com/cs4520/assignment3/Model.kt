package com.cs4520.assignment3

class Model: MVPContract.Model {
    override fun performOperation(number1: Double, number2: Double, operation: String): String {
        var result: Double = 0.0;
        when (operation) {
            "add" -> {
                result = number1 + number2
            }
            "subtract" -> {
                result = number1 - number2
            }
            "multiply" -> {
                result = number1 * number2
            }
            "divide" -> {
                result = number1/number2
            }
        }
        return result.toString()
    }
}