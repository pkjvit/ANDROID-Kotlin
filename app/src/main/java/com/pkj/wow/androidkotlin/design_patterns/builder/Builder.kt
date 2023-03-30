package com.pkj.wow.androidkotlin.design_patterns.builder

/*
https://engineering.leanix.net/blog/kotlin-builder-pattern/
https://kotlinlang.org/docs/type-safe-builders.html#how-it-works
 */


class User() {
    var name = ""
    var address = ""
    var age = 0
}

class PersonBuilder() {

    private var name = ""
    private var address = ""
    private var age = 0

    fun setName(name : String) = apply {
        this.name = name
    }

    fun setAddress(address : String) = apply {
        this.address = address
    }

    fun setAge(age : Int) = apply {
        this.age = age
    }

    fun canBuild() : Boolean {
        // do business rules, checks
        return true
    }

    fun build() : User {
        val person = User()
        if(canBuild()) {
            person.address = address
            person.name = name
            person.age = age
        }
        return person
    }
}
fun main(){
    val person = PersonBuilder().
    setAddress("").build()


}