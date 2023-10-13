package com.example.kotlin_basicapi_demo.repository

import com.example.kotlin_basicapi_demo.models.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository: JpaRepository<Message, Long> {

}