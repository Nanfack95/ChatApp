package com.example.chatapp.models

import java.sql.Timestamp

data class Message(
    val sender : String,
    val receiver : String,
    val text : String,
    val timestamp: Long,
    val isReceived: Boolean = true
)
