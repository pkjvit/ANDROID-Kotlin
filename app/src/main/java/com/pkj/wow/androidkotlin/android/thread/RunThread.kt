package com.pkj.wow.androidkotlin.android.thread


fun main(){
    println("PLOG: <top>->main: ${Thread.currentThread().name}")
    JavaThread().start()
    Thread(JavaThreadRunnable()).start()

}
