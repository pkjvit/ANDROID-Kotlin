package com.pkj.wow.androidkotlin.design_patterns.singleton

/*
https://medium.com/androiddevelopers/the-one-and-only-object-5dfd2cf7ab9b
 */
object Singleton


data class Config(val param: Int = 0)


class ThreadSafeSingleton private constructor(){

    companion object{
        @Volatile private var INSTANCE: ThreadSafeSingleton? = null
        fun getInstance(): ThreadSafeSingleton{
            return INSTANCE?:
                synchronized(this){
                    INSTANCE ?: buildThreadSafeSingleton()
                }
        }

        private fun buildThreadSafeSingleton() = ThreadSafeSingleton()

    }
}



/*
Singleton holder
https://blog.mindorks.com/how-to-create-a-singleton-class-in-kotlin/
 */
class SingletonHolderExample private constructor(context: String) {
    fun doSomething() {
        TODO("Not yet implemented")
    }

    init {
        // do something with context
    }

    companion object : SingletonHolder<SingletonHolderExample, String>(::SingletonHolderExample)
}

fun main(){

    SingletonHolderExample.getInstance("context").doSomething()
}