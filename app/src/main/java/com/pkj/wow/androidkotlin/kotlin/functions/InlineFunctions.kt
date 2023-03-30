package com.pkj.wow.androidkotlin.kotlin.functions

/*
https://medium.com/android-news/inline-noinline-crossinline-what-do-they-mean-b13f48e113c2
cross inline : https://amitshekhar.me/blog/crossinline-in-kotlin
 */

inline fun callingFunction(crossinline callback: () -> Unit){
    println("Calling function start")
    normalFunction {
        println("Normal function start")
        callback.invoke()

        return@normalFunction
        println("Normal function end")
    }

    println("Calling function end")
}

fun normalFunction(callback: () -> Unit){

    callback.invoke()

}



fun main(){
    callingFunction {
        println("Callback todo")
//        return@callingFunction
    }
}