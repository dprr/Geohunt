package com.example.geohunt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.select_game_layout.*

class SelectGameActivity : AppCompatActivity() {
	private val games = mutableListOf<Game>() //todo don't make an empty list, take the list of games from the settings/db

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.select_game_layout)

		gamesRecyclerView.layoutManager = LinearLayoutManager(this)
		gamesRecyclerView.adapter = GamesRecyclerAdapter(games)
	}
}