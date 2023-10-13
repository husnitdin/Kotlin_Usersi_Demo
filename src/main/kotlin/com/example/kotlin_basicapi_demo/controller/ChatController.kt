package com.example.kotlin_basicapi_demo.controller

import com.example.kotlin_basicapi_demo.dto.NewChatRequest
import com.example.kotlin_basicapi_demo.models.Message
import com.example.kotlin_basicapi_demo.service.ChatService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("chat")
class ChatController {

    lateinit var chatService: ChatService

    @PostMapping
    fun newChatMessage(@RequestBody ncr: NewChatRequest): Message {
        return chatService.newChatMessage(ncr)
    }

    @GetMapping("messages")
    fun getAllMessages(): MutableList<Message> {
        return chatService.getAllMessages()
    }

}