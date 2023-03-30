package com.pkj.wow.androidkotlin.kotlin.classes

class Box<T> (t:T){
    var value: T = t

    inline fun <reified S> isNumber() = value is S
}




fun main(){

    val list = listOf<Box<Number>>(Box(4))
    val box = Box(4.0)
    println("${box.isNumber<Int>()}")
    println("${box.value}")


}