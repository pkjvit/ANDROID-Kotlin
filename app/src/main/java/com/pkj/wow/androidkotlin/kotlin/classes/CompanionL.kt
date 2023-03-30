package com.pkj.wow.androidkotlin.kotlin.classes

class CompanionL {

    companion object{
        fun staticFunction(){
            println("staticFunction")
        }
    }
}

fun main(){
    CompanionL.staticFunction()
}
