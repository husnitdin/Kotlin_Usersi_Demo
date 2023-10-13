package com.example.kotlin_basicapi_demo.dto

data class NewChatRequest(
    var chatRoomName: String,
    var userId: Long,
    var message: String
){}