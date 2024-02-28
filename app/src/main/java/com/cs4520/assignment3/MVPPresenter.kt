package com.cs4520.assignment3

class MVPPresenter(private val view: MVPContract.View?,
                   private val model: MVPContract.Model
): MVPContract.Presenter {
    override fun onOperation(operation: String) {
        if (view != null){
            val number1: String = view.getNumber1()
            val number2: String = view.getNumber2()

            if (number1.isEmpty() || number2.isEmpty()) {
                view.displayToast()
            }
            else {
                val result: String = model.performOperation(number1.toDouble(), number2.toDouble(), operation)
                view.setResult(result)
                view.clearNumbers()
            }
        }


    }


}