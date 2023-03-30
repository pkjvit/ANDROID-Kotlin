package com.pkj.wow.androidkotlin.design_patterns.solid_principle
/*
https://proandroiddev.com/solid-design-principles-in-kotlin-79100c670df1

https://medium.com/kayvan-kaseb/the-solid-principles-for-android-developers-75fd4ca3ef84
 */

data class User(
    var id: Long,
    var name: String,
    var password: String
){
    // Not a good approach, only User related operations should be here, it's violating the SRP
    /*fun signIn(){
        // This method will do signing in operations
    }

    fun signOut(){
        // This method will do signing out operations
    }
    */

}

//  This is correct, separate out the classes with single responsibility
class AuthenticationService(){
    fun signIn(){
        // This method will do signing in operations
    }

    fun signOut(){
        // This method will do signing out operations
    }
}