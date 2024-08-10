package com.example.rpncalculator.model

data class ResultListUIModel(
    val data: List<ResultListItemUIModel> = listOf()
)
data class ResultListItemUIModel(
    val problems:Array<String> = arrayOf(),
    val result: Double = 0.0
)
