package com.example.kotlin_basicapi_demo.repository

import com.example.kotlin_basicapi_demo.models.Chatroom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ChatRepository: JpaRepository<Chatroom, Long> {

    @Query("SELECT c FROM Chatroom c where c.name = :name")
    fun findByName(@Param("name")name: String): Optional<Chatroom>
}