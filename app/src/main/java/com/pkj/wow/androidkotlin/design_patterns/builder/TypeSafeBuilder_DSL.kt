package com.pkj.wow.androidkotlin.design_patterns.builder

/*
https://in-kotlin.com/design-patterns/builder-pattern/
 */
class Address {
    var city = ""
    var street = ""
}

class Person {
    var name = ""
    var age = 0
    var address = Address()

    fun address(init: Address.() -> Unit) {
        val address = Address()
        address.init()
        this.address = address
    }
}


fun person(init: Person.() -> Unit): Person {
    val person = Person()
    person.init()
    return person
}


fun main(){
    person {
        name = "Pankaj"
        age = 32

        address{

        }
    }
}