package com.pkj.wow.androidkotlin.kotlin.functions

// My let function

inline fun <T,R> T.myLet(block: (T)->R):R{
    return block(this)
}

inline fun <T, R> T.myRun(block: T.() -> R):R{
    return block()
}

inline fun <T> T.myApply(block: T.() -> Unit): T{
    block()
    return this
}
inline fun <T> T.myAlso(block: (T) -> Unit): T{
    block(this)
    return this
}
fun main(){
    var string:String? = "Pankaj"

    string = string?.apply {
        reversed()
        "PKJ"
    }
    println(string)

    var myLetString = "My let string".myLet {
        it.reversed()
    }
    println(myLetString)

    var myRunString = "My run String"?.myRun {
        reversed()
    }
    println(myRunString)



}