package com.example.kotlin_basicapi_demo.controller

import com.example.kotlin_basicapi_demo.models.User
import com.example.kotlin_basicapi_demo.models.UserRequest
import com.example.kotlin_basicapi_demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController() {

    @Autowired
    lateinit var service: UserService

    @GetMapping("")
    fun getAllUsers(): List<User> {
        return service.getAll()
    }

    @GetMapping("/{id}")
    fun getAllUsers(@PathVariable id: Long): User {
        return service.getById(id)
    }

    @PostMapping("save")
    fun saveUser(@RequestBody u: UserRequest): User {
        return service.saveUser(u)
    }

}