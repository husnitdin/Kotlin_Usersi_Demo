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

) {}