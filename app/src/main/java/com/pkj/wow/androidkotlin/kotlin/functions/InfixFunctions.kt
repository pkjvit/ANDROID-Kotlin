package com.pkj.wow.androidkotlin.kotlin.functions

fun main() {

    infix fun Int.times(str: String) = str.repeat(this)        // 1
    println(4 times "Bye ")                                    // 2

    val pair = "Ferrari" to "Katrina"                          // 3
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)   // 4
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    val rana = Person("Rana")
    sophia likes claudia // 5
    sophia likes rana
    println("PLOG: <top>->main: ${sophia.likedPeople}")
}

data class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }  // 6
}