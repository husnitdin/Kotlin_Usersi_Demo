package com.example.kotlin_basicapi_demo.repository

import com.example.kotlin_basicapi_demo.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository: JpaRepository<User, Long> {

    fun findUserById(id: Long): User

    fun findUserByEmail(email: String?): Optional<User>?

    fun findUserByUserName(arg: String?): Optional<User>?

}