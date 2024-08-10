package com.example.rpncalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rpncalculator.compose.ResultListScreen
import com.example.rpncalculator.ui.theme.RPNCalculatorTheme
import java.util.LinkedList

class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RPNCalculatorTheme {
                ResultListScreen()
            }
        }
    }
}

@Composable
fun Greeting(list1:Array<String>,result1:Double, modifier: Modifier = Modifier) {
    Text(
        text = "Problem 1: $list1",
        modifier = modifier
    )
    Text(
        text = "result 1: $result1",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RPNCalculatorTheme {
        Greeting(arrayOf("1","2"),3.0)
    }
}

