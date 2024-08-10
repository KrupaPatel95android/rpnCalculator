package com.example.rpncalculator.compose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rpncalculator.RPNViewModel
import com.example.rpncalculator.model.ResultListItemUIModel

@Composable
fun ResultListScreen(rpnViewModel: RPNViewModel = viewModel()){
    val resultListUIModel = rpnViewModel.resultListUIModel.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(resultListUIModel.value.data){ item: ResultListItemUIModel ->
                val problem = item.problems.joinToString(separator = ",")
                val result = item.result.toString()
                Text(text = "Test Case")
                Text(text = "Problem: $problem")
                Text(text = "result $result")
            }
        }
    }

}

@Composable
fun ResultItem(resultListItemUIModel: ResultListItemUIModel){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)) {

    }
}


@Preview(showBackground = true)
@Composable
fun ResultListScreenPreview(){
    ResultListScreen()
}
