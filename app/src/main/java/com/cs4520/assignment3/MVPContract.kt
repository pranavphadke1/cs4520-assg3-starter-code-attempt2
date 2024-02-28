package com.cs4520.assignment3

interface MVPContract {
    interface View {
        /**
         * Get the second number
         */
        fun getNumber1(): String

        /**
         * Get the first number
         */
        fun getNumber2(): String

        /**
         * Display toast message if numbers provided are invalid
         */
        fun displayToast()


        /**
         * Sets the result value after an operation is performed
         */
        fun setResult(result: String)

        /**
         * Clears the numbers
         */
        fun clearNumbers()

    }

    interface Model{
        /**
         * Given two numbers and an operation, perform the operation and return the result
         */
        fun performOperation(number1: Double, number2: Double, operation: String): String

    }

    interface Presenter {
        /**
         * called when an operation button is pressed
         */
        fun onOperation(operation: String);
    }

}