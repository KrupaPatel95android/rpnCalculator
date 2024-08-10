package com.example.rpncalculator

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.rpncalculator.model.ResultListItemUIModel
import com.example.rpncalculator.model.ResultListUIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RPNViewModel: ViewModel() {

    val list1 = arrayOf("5", "8", "+")
    val list2 = arrayOf("5","5","5", "8", "+","+","-", "13", "+")
    val list3 = arrayOf("-3", "-2", "*","5","+")
    val list4 = arrayOf("5", "9", "1", "-","/")

    // Static list of ResultListItemUIModel
    private val _resultListUIModel = MutableStateFlow(
        ResultListUIModel(
            data = listOf(
                ResultListItemUIModel(problems = list1, result = evalRPN(list1)),
                ResultListItemUIModel(problems = list2, result = evalRPN(list2)),
                ResultListItemUIModel(problems = list3, result = evalRPN(list3)),
                ResultListItemUIModel(problems = list4, result = evalRPN(list4))
            )
        )
    )

    // Expose the StateFlow to the UI
    val resultListUIModel: StateFlow<ResultListUIModel> = _resultListUIModel

    //logic behind this function

//    Input: The function takes an array of strings (tokens), where each string is either an operand (a number) or an operator (+, -, *, /).
//    Stack-Based Evaluation:
//    It uses a stack to evaluate the expression.
//    Operands are pushed onto the stack.
//    When an operator is encountered, the function pops the required number of operands from the stack, applies the operator, and pushes the result back onto the stack.
//    Final Result: After processing all tokens, the stack should contain exactly one element, which is the result of the expression.
//    Example
//    Given the input arrayOf("-3", "-2", "*", "5", "+"), the evalRPN function:
//
//    Pushes -3.0 and -2.0 onto the stack.
//    Pops -2.0 and -3.0, Multiply them (6.0), and pushes the result onto the stack.
//    Pushes 5.0 onto the stack.
//    Pops 5.0 and 6.0, add them (11.0), and pushes the result onto the stack.
//    The final result is 11.0.

    fun evalRPN(tokens: Array<String>): Double {
        val stack = mutableListOf<Double>()

        for (token in tokens) {
            val operation: (Double, Double) -> Double = when (token) {
                "+" -> Double::plus
                "-" -> Double::minus
                "*" -> Double::times
                "/" -> Double::div
                else -> {
                    stack += token.toDouble()
                    continue
                }
            }

            val rhs = stack.removeLast()
            val lhs = stack.removeLast()
            stack += operation(lhs, rhs)
        }

        return stack.single()
    }
}