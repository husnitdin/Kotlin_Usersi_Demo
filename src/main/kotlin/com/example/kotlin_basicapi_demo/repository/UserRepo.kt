package com.example.kotlin_basicapi_demo.repository

import com.example.kotlin_basicapi_demo.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo: JpaRepository<User, Long> {

    fun findUserById(id: Long): User

}