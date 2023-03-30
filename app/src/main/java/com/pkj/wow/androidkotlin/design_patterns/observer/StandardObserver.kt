package com.pkj.wow.androidkotlin.design_patterns.observer

/*
https://in-kotlin.com/design-patterns/observer/
 */
open class Subject {
    private var observers = mutableListOf<Observer>()

    fun callObservers() {
        for(obs in observers) obs.update()
    }

    fun attach(obs : Observer) {
        observers.add(obs)
    }

    fun detach(obs : Observer) {
        observers.remove(obs)
    }
}

interface Observer {
    fun update()
}

class Sensor : Subject() {
    var temperature: Int = 0
        set(value) {
            field = value
            callObservers()
        }
}

class Monitor(val sensor: Sensor) : Observer {
    init {
        sensor.attach(this)
    }

    override fun update() {
        val newTemperature = sensor.temperature
        println("update Monitor $newTemperature")
    }

}

fun main() {

    val sensor = Sensor()
    val monitor = Monitor(sensor)

    sensor.temperature = 5
    sensor.temperature = 6
    sensor.temperature = 7
}