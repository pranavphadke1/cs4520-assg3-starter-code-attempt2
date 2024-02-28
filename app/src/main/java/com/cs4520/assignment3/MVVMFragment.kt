package com.cs4520.assignment3

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.cs4520.assignment3.databinding.CalculatorViewBinding

class MVVMFragment: Fragment(R.layout.calculator_view) {
    private var _calculator_view_binding: CalculatorViewBinding? = null
    private val calculator_view_binding get() = _calculator_view_binding!!

    private var number1: EditText? = null
    private var number2: EditText? = null
    private var result: TextView? = null

    private var add_button: Button? = null
    private var subtract_button: Button? = null
    private var multiply_button: Button? = null
    private var divide_button: Button? = null

    lateinit var viewModel: MVVMViewModel

    // Using the same layout as MVPFragment uses so we need to reset the background color
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            view.setBackgroundColor(Color.parseColor("#ffb3ba"))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel = MVVMViewModel()
        _calculator_view_binding = CalculatorViewBinding.inflate(inflater, container, false)

        number1 = _calculator_view_binding!!.number1
        number2 = _calculator_view_binding!!.number2
        result = _calculator_view_binding!!.result

        add_button = _calculator_view_binding!!.addButton
        subtract_button = _calculator_view_binding!!.subtractButton
        multiply_button = _calculator_view_binding!!.multiplyButton
        divide_button = _calculator_view_binding!!.divideButton

        bindUIToViewModel()

        observeLiveData()

        return calculator_view_binding.root
    }

    // Uses viewModel to update the model's number1 and number2
    private fun setNumbers() {
        viewModel.setNumbers(number1?.text.toString(), number2?.text.toString())
    }

    // Visually clear the number1 and number2 displayed on the view
    private fun clearNumbers() {
        number1?.text?.clear()
        number2?.text?.clear()
    }

    private fun validInputs(checkZero: Boolean = false): Boolean {
        var result = number1?.text.toString().isNotEmpty()
                && number2?.text.toString().isNotEmpty()
        if (checkZero){
            result = result && number2?.text.toString().toDouble() != 0.0
        }
        return result
    }

    private fun bindUIToViewModel() {
        add_button!!.setOnClickListener {
            setNumbers()
            viewModel.onOperation("add")
            if (validInputs()) { clearNumbers()}
        }
        subtract_button!!.setOnClickListener {
            setNumbers()
            viewModel.onOperation("subtract")
            if (validInputs()) { clearNumbers()}
        }
        multiply_button!!.setOnClickListener {
            setNumbers()
            viewModel.onOperation("multiply")
            if (validInputs()) { clearNumbers()}
        }
        divide_button!!.setOnClickListener {
            setNumbers()
            viewModel.onOperation("divide")
            if (validInputs(true)) { clearNumbers()}
        }
    }

    private fun observeLiveData() {
        viewModel.result.observe(viewLifecycleOwner, Observer { newResult ->
            result?.text = newResult
        })
        viewModel.displayErrorMessage.observe(viewLifecycleOwner, Observer { displayToast ->
            if (displayToast) {
                if (viewModel.divideByZeroError) {
                    Toast.makeText(context, R.string.divide_by_0, Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(context, R.string.invalid_input, Toast.LENGTH_SHORT).show()
                }
                viewModel.displayErrorMessage.value = false
                viewModel.divideByZeroError = false
            }

        })
    }


}