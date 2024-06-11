package com.example.simplecalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener { calculatingLogic(1) }
        binding.minusBtn.setOnClickListener { calculatingLogic(2) }
        binding.multiplyBtn.setOnClickListener { calculatingLogic(3) }
        binding.divideBtn.setOnClickListener { calculatingLogic(4) }
    }
    fun calculatingLogic(operation :Int){
        val firstNumText = binding.firstNum.text.toString()
        val secondNumText = binding.secondNum.text.toString()

        if (firstNumText.isEmpty() || secondNumText.isEmpty()){
            Toast.makeText(this,"Please fill first and second number", Toast.LENGTH_SHORT).show()
            return
        }

        val firstNumber = firstNumText.toIntOrNull()
        val secondNumber = secondNumText.toIntOrNull()

        if (firstNumber != null && secondNumber != null){
            val result = when(operation){
                1 -> firstNumber + secondNumber
                2 -> firstNumber - secondNumber
                3 -> firstNumber * secondNumber
                4 -> if (secondNumber != 0) firstNumber / secondNumber else{
                    Toast.makeText(this,"You can not any number to zero", Toast.LENGTH_SHORT).show()
return
                } else -> 0
            }
            binding.result.text = result.toString()
        }
        else {
            Toast.makeText(this,"Please add only numbers", Toast.LENGTH_SHORT).show()

        }
    }

}