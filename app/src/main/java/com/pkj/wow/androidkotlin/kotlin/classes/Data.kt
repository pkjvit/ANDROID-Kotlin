package com.pkj.wow.androidkotlin.kotlin.classes

/*
https://proandroiddev.com/kotlin-data-class-behind-the-mask-51a05ad92ae9
 */
data class User(val id:String, var name: String?){
    var age:Int = 0
}

class Constrcutors(
    val name: String
){

    constructor(name: String, age: Int): this(name){
        println("age $age, $name")
    }

    init {
        println("init block $name")
    }

}


fun main(){
    val user1 = User("100", "Pankaj")
    user1.age = 10
    val user2 = User("100", "Pankaj")
    user2.age = 20
    val user3 = user1

    val (name,id) = user1
    println("user1 - $name, $id")

    println("${user1==user2}") // .equals
    println("${user1==user3}") // .equals
    println("${user1.equals(user2)}")
    println("${user1===user2}") // check for reference only
    println("${user1===user3}") // check for reference only

    val constrcutors = Constrcutors("pankaj", 4)

}