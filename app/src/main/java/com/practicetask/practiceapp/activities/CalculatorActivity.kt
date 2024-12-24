package com.practicetask.practiceapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.practicetask.practiceapp.R


class CalculatorActivity : AppCompatActivity(){
    private lateinit var firstNumber:EditText
    private lateinit var secondNumber:EditText
    private lateinit var addBtn:Button
    private lateinit var subBtn:Button
    private lateinit var mulBtn:Button
    private lateinit var divBtn:Button
    private lateinit var result:TextView
    private var num1=0
    private var num2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.basic_calculator)

        firstNumber = findViewById(R.id.firstNum)
        secondNumber = findViewById(R.id.SecNum)
        addBtn = findViewById(R.id.add)
        subBtn = findViewById(R.id.sub)
        mulBtn = findViewById(R.id.mul)
        divBtn = findViewById(R.id.div)
        result = findViewById(R.id.answer)


        addBtn.setOnClickListener {
            num1 = takeEdittext(firstNumber)
            num2 = takeEdittext(secondNumber)
            result.text="Result:" + (num1+num2).toString()
        }
        subBtn.setOnClickListener {
            num1 = takeEdittext(firstNumber)
            num2 = takeEdittext(secondNumber)
            result.text = "Result: ${num1-num2}"
        }
        mulBtn.setOnClickListener {
            num1 = takeEdittext(firstNumber)
            num2 = takeEdittext(secondNumber)
            result.text = "Result: ${num1*num2}"
        }
        divBtn.setOnClickListener {
            num1 = takeEdittext(firstNumber)
            num2 = takeEdittext(secondNumber)
            if(num2 == 0){
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            result.text = "Result: ${num1.toFloat()/num2.toFloat()}"
        }



    }

    private fun takeEdittext(number:EditText) : Int{
        val num = number.text.toString()
//        if(num == ""){
//            Toast.makeText(this, "Please Enter Number", Toast.LENGTH_SHORT).show()
//        }


        return num.toIntOrNull() ?: 0

    }

//    private fun calculation(num1:Int, num2:Int, operation:String) : String
//    {
//        return when (operation){
//            "+" -> "Result:" + (num1+num2).toString()
//            "-" -> "Result:" +(num1-num2).toString()
//            "*" -> "Result:" +(num1*num2).toString()
//            "/" -> "Result:" + (num1/num2).toString()
//            else -> "Invalid Operation"
//        }
//    }

}
