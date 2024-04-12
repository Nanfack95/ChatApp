package com.example.chatapp.adapters

import android.content.Intent
import android.icu.text.DateFormat.HourCycle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.chatapp.R
import com.example.chatapp.activities.ChatActivity
import com.example.chatapp.models.Friend
import com.google.android.material.imageview.ShapeableImageView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FriendsRecyclerAdapter:RecyclerView.Adapter<FriendsRecyclerAdapter.ViewHolder>() {

    var items : MutableList<Friend> = mutableListOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_friend, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friend = items[position]
        holder.bind(friend)

    }


    class ViewHolder(itemViews: View):RecyclerView.ViewHolder(itemViews) {

        val ivFriend:ShapeableImageView = itemViews.findViewById(R.id.ivFriend)
        val tvName:TextView = itemViews.findViewById(R.id.tvName)
        val lastMsg:TextView = itemViews.findViewById(R.id.tvLastMsg)
        val tvHour: TextView = itemViews.findViewById(R.id.tvHour)

        fun bind(friend : Friend){
            tvName.text = friend.name
            lastMsg.text = friend.lastMsg

            val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
            tvHour.text = sdf.format(Date(friend.timestamp))

            itemView.setOnClickListener{
                Intent(itemView.context, ChatActivity::class.java).also {
                    itemView.context.startActivity(it)
                }
            }
        }

    }
}