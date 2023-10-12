package com.example.kotlin_basicapi_demo.service

import com.example.kotlin_basicapi_demo.models.User
import com.example.kotlin_basicapi_demo.models.UserRequest
import com.example.kotlin_basicapi_demo.repository.UserRepo
import com.example.springboot_project_01.exception.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {

    @Autowired
    lateinit var repository: UserRepo

    fun getAll(): List<User>{
        return repository.findAll()
    }

    private fun checkForUserId(id: Long) {
        if (!repository.existsById(id)) {
            throw UserNotFoundException("User with ID: $id does not exist!")
        }
    }

    fun getById(id: Long): User {
        return repository.findUserById(id)
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