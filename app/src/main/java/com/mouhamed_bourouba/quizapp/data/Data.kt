package com.mouhamed_bourouba.quizapp.data

data class Data<T, Boolean, Exception>(
    var data: T?,
    var isLoading: Boolean?,
    var exception: Exception?,
)