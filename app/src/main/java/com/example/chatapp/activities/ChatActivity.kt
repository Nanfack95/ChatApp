package com.example.chatapp.activities

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.adapters.ChatRecyclerAdapter
import com.example.chatapp.models.Message
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChatActivity : AppCompatActivity() {

    lateinit var fabSendMessage : FloatingActionButton
    lateinit var editMessage : EditText
    lateinit var rvChatList : RecyclerView
    lateinit var chatRecyclerAdapter: ChatRecyclerAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        fabSendMessage = findViewById(R.id.fabSendMessage)
        editMessage = findViewById(R.id.editMessage)
        rvChatList = findViewById(R.id.rvChatList)

        val name = intent.getStringExtra("friend")
        supportActionBar?.title = name ?: "ChatApp"
        chatRecyclerAdapter = ChatRecyclerAdapter()

        val messages = mutableListOf(
            Message(sender = "Jospin", receiver = "Arole", text="salut", timestamp=1266487, isReceived=false),
            Message(sender = "Arole", receiver = "Jospin", text="ca va ?", timestamp=1266487, isReceived=false),
            Message(sender = "Jospin", receiver = "Arole", text="salut mon frere", timestamp=1266487, isReceived=true),
            Message(sender = "Arole", receiver = "Jospin", text="oui bien et toi ?", timestamp=1266487, isReceived=true),
            Message(sender = "Jospin", receiver = "Arole", text="nickel", timestamp=1266487, isReceived=false)
        )

        fabSendMessage.setOnClickListener{
//            envoyer un message
            val message = editMessage.text.toString()
            if (message.isNotEmpty()){
                messages.add(Message(sender = "Jospin", receiver = "Arole", text=message, timestamp=System.currentTimeMillis(), isReceived=false))
                chatRecyclerAdapter.notifyDataSetChanged()
                editMessage.setText("")

//                hide keyboard
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(editMessage.windowToken, 0)
            }
        }




        rvChatList.apply {
            layoutManager = LinearLayoutManager(this@ChatActivity)
            adapter = chatRecyclerAdapter
        }
        chatRecyclerAdapter.items = messages
    }
}