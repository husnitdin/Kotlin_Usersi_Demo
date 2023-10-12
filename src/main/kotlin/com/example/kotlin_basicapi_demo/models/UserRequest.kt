package com.example.kotlin_basicapi_demo.models

data class CreateUserRequest(

    var userName: String,
    var email: String,
    var picture: String

){}