package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculator = Calculator()
        val textView = findViewById<TextView>(R.id.textView) as TextView
        getAllButtons(calculator,textView)

    }

    private fun getAllButtons(calculator: Calculator,textView: TextView){
        //clearing textView on-by-one
        findViewById<Button>(R.id.clear)
            .setOnClickListener {
                calculator.expression = "0"
                calculator.operand1 = 0
                calculator.operand2 = null
                calculator.operation = null
                textView.text = calculator.expression
            }

        //operations
        findViewById<Button>(R.id.equals)
            .setOnClickListener {
                if(calculator.operation != null && calculator.operand2 != null){
                    if (calculator.operation == '/' && calculator.operand2 == 0){
                        calculator.operand2 = null
                        calculator.operation = null
                        calculator.expression = calculator.operand1.toString()
                        Toast.makeText(this, "Division by zero not defined!", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        calculator.calculate()
                    }
                    textView.text = calculator.expression
                }
                else if(calculator.operation != null){
                    calculator.expression = calculator.expression.dropLast(1)
                    calculator.operation = null
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.divide)
            .setOnClickListener {
                if(calculator.operation == null){
                    calculator.operand1 = calculator.expression.toInt()
                    calculator.operation = '/'
                    calculator.expression += "/"
                    textView.text = calculator.expression
                }
                else if(calculator.operand2 != null){
                    if(calculator.operand2 == 0){
                        calculator.operand2 = null
                        calculator.operation = null
                        calculator.expression = calculator.operand1.toString()
                        textView.text = calculator.expression
                        Toast.makeText(this, "Division by zero not defined!", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        calculator.calculate()
                        calculator.operation = '/'
                        calculator.expression += '/'
                        textView.text = calculator.expression
                    }
                }
                else{
                    calculator.operation = '/'
                    calculator.expression = calculator.expression.dropLast(1)
                    calculator.expression += '/'
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.multiply)
            .setOnClickListener {
                if(calculator.operation == null){
                    calculator.operand1 = calculator.expression.toInt()
                    calculator.operation = '*'
                    calculator.expression += "*"
                    textView.text = calculator.expression
                }
                else if(calculator.operand2 != null){
                    calculator.calculate()
                    calculator.operation = '*'
                    calculator.expression += '*'
                    textView.text = calculator.expression
                }
                else{
                    calculator.operation = '*'
                    calculator.expression = calculator.expression.dropLast(1)
                    calculator.expression += '*'
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.subtract)
            .setOnClickListener {
                if(calculator.operation == null){
                    calculator.operand1 = calculator.expression.toInt()
                    calculator.operation = '-'
                    calculator.expression += "-"
                    textView.text = calculator.expression
                }
                else if(calculator.operand2 != null){
                    calculator.calculate()
                    calculator.operation = '-'
                    calculator.expression += '-'
                    textView.text = calculator.expression
                }
                else{
                    calculator.operation = '-'
                    calculator.expression = calculator.expression.dropLast(1)
                    calculator.expression += '-'
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.add)
            .setOnClickListener {
                if(calculator.operation == null){
                    calculator.operand1 = calculator.expression.toInt()
                    calculator.operation = '+'
                    calculator.expression += "+"
                    textView.text = calculator.expression
                }
                else if(calculator.operand2 != null){
                    calculator.calculate()
                    calculator.operation = '+'
                    calculator.expression += '+'
                    textView.text = calculator.expression
                }
                else{
                    calculator.operation = '+'
                    calculator.expression = calculator.expression.dropLast(1)
                    calculator.expression += '+'
                    textView.text = calculator.expression
                }
            }

        //numbers
        findViewById<Button>(R.id.zero)
            .setOnClickListener {
                if(calculator.operand2 == null && calculator.operation != null){
                    calculator.expression = "0"
                    calculator.operand2 = calculator.expression.toInt()
                    textView.text = calculator.expression
                }
                else if(calculator.expression != "0"){
                    calculator.expression += "0"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.one)
            .setOnClickListener {
                if(calculator.operand2 == null && calculator.operation != null){
                    calculator.expression = "1"
                    calculator.operand2 = calculator.expression.toInt()
                    textView.text = calculator.expression
                }
                else if(calculator.expression == "0"){
                    calculator.expression = "1"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
                else{
                    calculator.expression += "1"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.two)
            .setOnClickListener {
                if(calculator.operand2 == null && calculator.operation != null){
                    calculator.expression = "2"
                    calculator.operand2 = calculator.expression.toInt()
                    textView.text = calculator.expression
                }
                else if(calculator.expression == "0"){
                    calculator.expression = "2"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
                else{
                    calculator.expression += "2"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.three)
            .setOnClickListener {
                if(calculator.operand2 == null && calculator.operation != null){
                    calculator.expression = "3"
                    calculator.operand2 = calculator.expression.toInt()
                    textView.text = calculator.expression
                }
                else if(calculator.expression == "0"){
                    calculator.expression = "3"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
                else{
                    calculator.expression += "3"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.four)
            .setOnClickListener {
                if(calculator.operand2 == null && calculator.operation != null){
                    calculator.expression = "4"
                    calculator.operand2 = calculator.expression.toInt()
                    textView.text = calculator.expression
                }
                else if(calculator.expression == "0"){
                    calculator.expression = "4"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
                else{
                    calculator.expression += "4"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.five)
            .setOnClickListener {
                if(calculator.operand2 == null && calculator.operation != null){
                    calculator.expression = "5"
                    calculator.operand2 = calculator.expression.toInt()
                    textView.text = calculator.expression
                }
                else if(calculator.expression == "0"){
                    calculator.expression = "5"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
                else{
                    calculator.expression += "5"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.six)
            .setOnClickListener {
                if(calculator.operand2 == null && calculator.operation != null){
                    calculator.expression = "6"
                    calculator.operand2 = calculator.expression.toInt()
                    textView.text = calculator.expression
                }
                else if(calculator.expression == "0"){
                    calculator.expression = "6"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
                else{
                    calculator.expression += "6"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.seven)
            .setOnClickListener {
                if(calculator.operand2 == null && calculator.operation != null){
                    calculator.expression = "7"
                    calculator.operand2 = calculator.expression.toInt()
                    textView.text = calculator.expression
                }
                else if(calculator.expression == "0"){
                    calculator.expression = "7"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
                else{
                    calculator.expression += "7"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.eight)
            .setOnClickListener {
                if(calculator.operand2 == null && calculator.operation != null){
                    calculator.expression = "8"
                    calculator.operand2 = calculator.expression.toInt()
                    textView.text = calculator.expression
                }
                else if(calculator.expression == "0"){
                    calculator.expression = "8"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
                else{
                    calculator.expression += "8"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
            }
        findViewById<Button>(R.id.nine)
            .setOnClickListener {
                if(calculator.operand2 == null && calculator.operation != null){
                    calculator.expression = "9"
                    calculator.operand2 = calculator.expression.toInt()
                    textView.text = calculator.expression
                }
                else if(calculator.expression == "0"){
                    calculator.expression = "9"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
                else{
                    calculator.expression += "9"
                    if(calculator.operand2 != null){
                        calculator.operand2 = calculator.expression.toInt()
                    }
                    textView.text = calculator.expression
                }
            }
    }
}