package com.cs4520.assignment3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMViewModel : ViewModel() {
    private val model: Model = Model()

    // This is live data that our view (MVVMFragment) observes to update itself
    val result = MutableLiveData<String>("") // The result of performing an operation
    val displayErrorMessage = MutableLiveData<Boolean>(false) // Tells the view if there is an error

    // indicates if the error is due to dividing by 0
    var divideByZeroError = false

    fun onOperation(operation: String) {
        val number1: String? = model.number1
        val number2: String? = model.number2

        if (number1.isNullOrEmpty() || number2.isNullOrEmpty()) {
            displayErrorMessage.value = true
        }
        else if (operation == "divide" && number2.toDouble() == 0.0){
            divideByZeroError = true
            displayErrorMessage.value = true
        }
        else {
            result.value = model.performOperation(number1.toDouble(), number2.toDouble(), operation)
        }
    }

    // Allows the view to set the model's numbers
    fun setNumbers(num1: String, num2: String) {
        model.number1 = num1
        model.number2 = num2
    }

}