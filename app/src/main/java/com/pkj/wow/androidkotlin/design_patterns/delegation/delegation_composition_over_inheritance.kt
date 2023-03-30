package com.pkj.wow.androidkotlin.design_patterns.delegation


interface IMoving {
    fun move()
}

class Walking : IMoving {
    override fun move() {
        println("Walking")
    }
}

class Animal(movable : IMoving) : IMoving by movable {

}

fun main() {
    val string:String by lazy {
        "const"
    }
    var walking = Walking()
    var animal = Animal(walking)
    animal.move()
}