package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment3.databinding.HomeViewBinding

class HomeFragment: Fragment(R.layout.home_view) {
    private var _home_binding: HomeViewBinding? = null
    private val home_binding get() = _home_binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _home_binding = HomeViewBinding.inflate(inflater, container, false)
        val navController = findNavController()
        val mvpButton = _home_binding!!.mvpButton
        mvpButton.setOnClickListener{ navController.navigate(R.id.action_home_to_mvp) }
        return home_binding.root
    }
}