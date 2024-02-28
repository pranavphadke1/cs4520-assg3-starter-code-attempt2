package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.MvpViewBinding

class MVPFragment: Fragment(R.layout.mvp_view), MVPContract.View {
    private var _mvp_view_binding: MvpViewBinding? = null
    private val mvp_view_binding get() = _mvp_view_binding!!

    private var number1: EditText? = null
    private var number2: EditText? = null
    private var result: TextView? = null

    private var add_button: Button? = null
    private var subtract_button: Button? = null
    private var multiply_button: Button? = null
    private var divide_button: Button? = null

    var presenter: MVPPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _mvp_view_binding = MvpViewBinding.inflate(inflater, container, false)

        number1 = _mvp_view_binding!!.number1
        number2 = _mvp_view_binding!!.number2
        result = _mvp_view_binding!!.result

        add_button = _mvp_view_binding!!.addButton
        subtract_button = _mvp_view_binding!!.subtractButton
        multiply_button = _mvp_view_binding!!.multiplyButton
        divide_button = _mvp_view_binding!!.divideButton

        presenter = MVPPresenter(this, MVPModel())

        add_button!!.setOnClickListener { presenter!!.onOperation("add") }
        subtract_button!!.setOnClickListener { presenter!!.onOperation("subtract") }
        multiply_button!!.setOnClickListener { presenter!!.onOperation("multiply") }
        divide_button!!.setOnClickListener { presenter!!.onOperation("divide") }

        return mvp_view_binding.root

    }

    override fun getNumber1(): String {
        return number1?.text.toString()
    }

    override fun getNumber2(): String {
        return number2?.text.toString()
    }

    override fun displayToast() {
        Toast.makeText(context, R.string.error, Toast.LENGTH_SHORT).show()
    }

    override fun setResult(result: String) {
        this.result?.text = result
    }

    override fun clearNumbers() {
        this.number1?.text?.clear()
        this.number2?.text?.clear()
    }
}