package com.pkj.wow.androidkotlin.design_patterns.factory

interface Network {
    fun isSuccessful() : Boolean
    fun execute()
}

interface NetworkFactory {
    fun createNetwork(url : String) : Network
}

class NetworkImpl(private val url: String = "") : Network{
    private var errorCode = 200

    override fun isSuccessful() : Boolean {
        return errorCode == 200
    }

    override fun execute() {

    }
}

class NetworkFactoryImpl : NetworkFactory {
    override fun createNetwork(url : String) : Network {
        return NetworkImpl(url)
    }
}

class NetworkMock : Network{
    override fun isSuccessful() : Boolean {
        return true
    }

    override fun execute() {

    }
}

class NetworkMockFactory : NetworkFactory {
    override fun createNetwork(url : String) : Network {
        return NetworkMock()
    }
}


fun callUrl(url : String, factory : NetworkFactory = NetworkFactoryImpl()) : String {
    val network = factory.createNetwork(url)
    network.execute()
    if(network.isSuccessful()) return "OK"
    return "FAILURE"
}