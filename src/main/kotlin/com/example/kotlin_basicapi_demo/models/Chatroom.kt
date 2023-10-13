package com.example.kotlin_basicapi_demo.models

import jakarta.persistence.*

@Entity
data class Chatroom(
    @Id
    @GeneratedValue
    var id: Long = -1,
    var name: String,
    var iconUrl: String
){
    // chatroom and user has many to many relations
    @ManyToMany
    open var users: List<User> = listOf()

    // chatroom and message has one to many relations
    @OneToMany
    open var messages: List<Message> = listOf()
}