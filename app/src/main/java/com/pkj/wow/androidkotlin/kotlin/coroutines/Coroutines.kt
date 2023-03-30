package com.pkj.wow.androidkotlin.kotlin.coroutines

import android.util.Log
import kotlinx.coroutines.*


fun main() = runBlocking {

    val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("PLOG", "handler->main: ${throwable.message}")
    }

    try {
        coroutineScope {
            val task1 = launch(handler) {
                throw Exception("task 1 error")
            }

            val task2 = launch {
                throw Exception("task 2 error")
            }
        }
    }catch (e: Exception){
        Log.d("PLOG", "catch->main: ${e.message}")
        println("catch: ${e.message}")
    }

}
