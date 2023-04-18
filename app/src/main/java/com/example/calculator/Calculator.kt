package com.example.calculator

import android.widget.Toast
import kotlin.math.exp

class Calculator {
    var expression: String = "0"
    var operand1: Int = 0
    var operand2: Int? = null
    var operation: Char? = null

    private fun add() {
        operand1 += operand2!!
        operand2 = null
        operation = null
        expression = operand1.toString()
    }

    private fun subtract() {
        operand1 -= operand2!!
        operand2 = null
        operation = null
        expression = operand1.toString()
    }

    private fun divide() {
        operand1 /= operand2!!
        operand2 = null
        operation = null
        expression = operand1.toString()
    }

    private fun multiply() {
        operand1 *= operand2!!
        operand2 = null
        operation = null
        expression = operand1.toString()
    }

    fun calculate(){
        when(operation){
            '+' -> add()
            '-' -> subtract()
            '/' -> divide()
            '*' -> multiply()
        }
    }
}