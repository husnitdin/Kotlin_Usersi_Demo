package com.example.kotlin_basicapi_demo.service

import com.example.kotlin_basicapi_demo.dto.NewChatRequest
import com.example.kotlin_basicapi_demo.models.Chatroom
import com.example.kotlin_basicapi_demo.models.Message
import com.example.kotlin_basicapi_demo.models.User
import com.example.kotlin_basicapi_demo.repository.ChatRepository
import com.example.kotlin_basicapi_demo.repository.MessageRepository
import com.example.kotlin_basicapi_demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChatService {

    @Autowired lateinit var chatRepository: ChatRepository
    @Autowired lateinit var messageRepository: MessageRepository
    @Autowired lateinit var userRepository: UserRepository

    fun newChatMessage(ncr: NewChatRequest): Message {
        // create new message variable
        val newMessage = Message(value = ncr.message, time = Date())

        // does the chatroom exist? if not create one
        val chatRoom = chatRepository.findByName(ncr.chatRoomName)

        if(chatRoom.isPresent){
            newMessage.chatroom = chatRoom.get()
        } else {
            val newChatroom = chatRepository.save(
                Chatroom(
                    name = ncr.chatRoomName,
                    iconUrl = "default.png")
            )

            newMessage.chatroom = newChatroom
        }

        // does the user exist? if not ERROR
        val temp: Optional<User> = userRepository.findById(ncr.userId)

        if(temp.isPresent){
            newMessage.user = temp.get()
        } else {
            // TODO throw error
        }

        return messageRepository.save(newMessage)
    }

    fun getAllMessages(): MutableList<Message> {
        return messageRepository.findAll()
    }

}