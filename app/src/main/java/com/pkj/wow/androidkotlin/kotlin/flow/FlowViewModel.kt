package com.pkj.wow.androidkotlin.kotlin.flow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {

    val countDownFlow = flow<Int> {
        val startingValue = 10
        var current = startingValue
        emit(startingValue)

        while (current > 0) {
            delay(1000)
            current--
            emit(current)
        }
    }



    init {
        collectFlow()
    }

    private fun collectFlow() {
        viewModelScope.launch {
            countDownFlow
                .filter { time ->
                    time % 2 == 0
                }
                .map { time ->
                    time * 2
                }
                .onEach {
                    Log.d("PLOG", "FlowViewModel->collectFlow: onEach $it #${Thread.currentThread().name}")
                }
                .flowOn(Dispatchers.Default)
                .collect { time ->
                    Log.d("PLOG", "FlowViewModel->collectFlow: $time #${Thread.currentThread().name}")

                }
        }
    }



}