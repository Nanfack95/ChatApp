package com.example.chatapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.adapters.FriendsRecyclerAdapter
import com.example.chatapp.models.Friend
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    lateinit var rvFriend : RecyclerView
    lateinit var fabChat : FloatingActionButton

    lateinit var friendsRecyclerAdapter : FriendsRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvFriend = findViewById(R.id.rvFriend)
        fabChat = findViewById(R.id.fabChat)

        fabChat.setOnClickListener{

        }

        val friends = mutableListOf(
            Friend("Jospin Duclair","salut","",1234678349),
            Friend("Arole Wilson","hello","",1234678349),
            Friend("Gibril Duclair","bonjour","",1234678349),
            Friend("Linda Cruz","hi","",1234678349)
        )
        friendsRecyclerAdapter = FriendsRecyclerAdapter()
        friendsRecyclerAdapter.items = friends
        rvFriend.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = friendsRecyclerAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.itemLogout){
            Intent(this, AuthentificationActivity::class.java).also{
                startActivity(it)
            }
            finish()
        }
        if(item.itemId == R.id.itemSetting){
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_LONG).show()
//            Intent(this, SettingsActivity::class.java).also{
//                startActivity(it)
//            }
        }
        return super.onOptionsItemSelected(item)
    }
}
