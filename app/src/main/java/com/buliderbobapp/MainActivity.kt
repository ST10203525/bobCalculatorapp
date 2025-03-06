package com.buliderbobapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var add: Button
    private lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


            }
            add = findViewById(R.id.add)
            editText1 = findViewById(R.id.editText1)
            editText2 = findViewById(R.id.editText2)
            result = findViewById(R.id.result)

        add.setOnClickListener {
            val num1 = editText1.text.toString()
            val num2 = editText2.text.toString()

            // Convert strings to integers
            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                val number1 = num1.toIntOrNull() ?: 0 // Default to 0 if conversion fails
                val number2 = num2.toIntOrNull() ?: 0 // Default to 0 if conversion fails

                add(number1, number2)
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }}


    private fun add(number1: Int, number2: Int) {
        val resultValue = number1 + number2
        result.text = " $resultValue"
        Log.e("MainActivity", "The user input was: $number1 and $number2, and the result was $resultValue")
    }



    }
