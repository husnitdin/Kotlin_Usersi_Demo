package com.example.kotlin_basicapi_demo.models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.*

@Entity
data class User(

    @Id
    @GeneratedValue
    val id: Long = -1,

    @Column(nullable = false, unique = true)
    var userName: String = "",

    @Column(nullable = false, unique = true)
    var email: String = "",

    var picture: String = ""

) {

    // user and chatroom has many to many relations
    @ManyToMany
    open var chatrooms: List<Chatroom> = listOf()

    // user and message has one to many relations
    @OneToMany
    open var messages: List<Message> = listOf()

}