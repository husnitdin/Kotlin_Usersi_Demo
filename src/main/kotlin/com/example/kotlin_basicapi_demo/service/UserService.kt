package com.example.kotlin_basicapi_demo.service

import com.example.kotlin_basicapi_demo.models.User
import com.example.kotlin_basicapi_demo.dto.UserRequest
import com.example.kotlin_basicapi_demo.repository.UserRepository
import com.example.springboot_project_01.exception.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

@Service
class UserService {

    @Autowired
    lateinit var repository: UserRepository

    fun getAll(): List<User>{
        return repository.findAll()
    }

    fun getById(id: Long): User {
        val foundUser = repository.findById(id)
        val u: User = foundUser.getOrElse { throw UserNotFoundException("User not found") }
        return u
    }

    fun saveUser(u: UserRequest): User {

        val newUser = User(
            userName = u.userName,
            email = u.email,
            picture = u.picture
        )

        return repository.save(newUser)
    }

}