package com.example.kotlin_basicapi_demo.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.*

@Entity
data class Message(
    @Id
    @GeneratedValue
    var id: Long = -1,
    var value: String,
    var time: Date
){
    // chatroom and message has one to many relations
    @ManyToOne
    // open means class is open for the extension
    // we can create subclass of that class.
    // In Kotlin, all classes are final by default
    open lateinit var chatroom: Chatroom

    // user and message has one to many relations
    @ManyToOne
    open lateinit var user: User
}