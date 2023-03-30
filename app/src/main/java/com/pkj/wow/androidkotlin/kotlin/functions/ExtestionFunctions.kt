package com.pkj.wow.androidkotlin.kotlin.functions


class ExtensionL: ExtensionParentL() {
}

open class ExtensionParentL{

}

fun ExtensionParentL.prefixA(prefix:String):String{
    return "$prefix+ExtensionParentL"
}

fun ExtensionL.prefixA(prefix:String):String{
    return "$prefix+ExtensionL"
}

fun main(){

    val extensionParentL = ExtensionParentL()
    val extensionL = ExtensionL()
    val string = "pankaj"

    println("${extensionL.prefixA(string)}")
    println("${extensionParentL.prefixA(string)}")

}