package com.pkj.wow.androidkotlin.design_patterns.factory

interface Animal{
    fun makeSound()
}

class Dog():Animal{
    override fun makeSound() {
        println("PLOG: Dog->makeSound: WOOH!")
    }
}

class Cat():Animal{
    override fun makeSound() {
        println("PLOG: Cat->makeSound: MEOW!")
    }
}

object AnimalFactory {
    fun createAnimal(animalType: AnimalType):Animal{
        return when(animalType){
            AnimalType.CAT -> Cat()
            AnimalType.DOG -> Dog()
            else -> throw IllegalArgumentException("Unknown animal type")
        }
    }
}

enum class AnimalType {
    CAT,
    DOG
}

fun main(){
    AnimalFactory.createAnimal(AnimalType.DOG).makeSound()
    AnimalFactory.createAnimal(AnimalType.CAT).makeSound()
}
