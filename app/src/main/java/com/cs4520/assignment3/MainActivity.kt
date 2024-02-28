package com.cs4520.assignment3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cs4520.assignment3.databinding.HomeViewBinding

class MainActivity : AppCompatActivity() {
    private lateinit var home_binding: HomeViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        home_binding = HomeViewBinding.inflate(layoutInflater)
        setContentView(home_binding.root)
    }
}