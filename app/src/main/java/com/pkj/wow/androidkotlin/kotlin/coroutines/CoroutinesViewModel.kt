package com.pkj.wow.androidkotlin.kotlin.coroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CoroutinesViewModel: ViewModel() {
    init {
        /*viewModelScope.launch{
            while (true){
                delay(500)
                Log.d("PLOG", "CoroutinesViewModel->launch: ")
            }
        }*/


        viewModelScope.launch {

        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("PLOG", "CoroutinesViewModel->onCleared: destroyed")
    }
}