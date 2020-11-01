package com.example.geohunt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_create_game.*

class CreateGameActivity : AppCompatActivity() {
	private val locations = mutableListOf<Location>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_create_game)


		locationsRecyclerView.layoutManager = LinearLayoutManager(this)
		locationsRecyclerView.adapter = WaypointRecyclerAdapter(locations)
	}

	fun onClickAddGame(view: View){
		val description = "" // todo
		val name = nameET.text.toString()
		val newGame = Game(name, description, locations)
		Games.gameList.add(newGame)
		finish()
	}

	fun onClickAddLocation(view: View){
		val intent = Intent(this, CreateLocationActivity::class.java)
		startActivity(intent)
	}
}