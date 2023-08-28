package com.ridhamsharma.livedatacolor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ridhamsharma.livedatacolor.databinding.ActivityMainBinding
import com.ridhamsharma.livedatacolor.databinding.FragmentColorBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var colorViewModel: ColorViewModel
    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        colorViewModel = ViewModelProvider(this)[ColorViewModel::class.java]

        binding.btnRed.setOnClickListener {
            colorViewModel.color.value = 1
        }
        binding.btnBlue.setOnClickListener {
            colorViewModel.color.value = 2
        }
        binding.btnGreen.setOnClickListener {
            colorViewModel.color.value = 3
        }
        binding.btnAdd.setOnClickListener {
            number = number + 1
            binding.tvInsertNumber.setText(number.toString())
            colorViewModel.number.value = number

        }
        binding.btnMinus.setOnClickListener {
            number = number - 1
            binding.tvInsertNumber.setText(number.toString())
            colorViewModel.number.value = number
        }

        colorViewModel.number.observe(this){
            binding.tvInsertNumber.setText(it.toString())
        }



        





        }
    }
