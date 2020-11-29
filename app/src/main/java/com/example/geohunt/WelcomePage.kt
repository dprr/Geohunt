package com.example.geohunt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class WelcomePage : AppCompatActivity() {
	private val CREATE_GAME_REQUEST_CODE = 0
	private val games = mutableListOf<Game>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_welcome_page)
	}

	fun onClickPlayButton(view: View){

	}

	fun onClickCreateButton(view: View){
		val intent = Intent(this, CreateGameActivity::class.java)
		startActivityForResult(intent, CREATE_GAME_REQUEST_CODE)
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)

		if (requestCode == CREATE_GAME_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
				val returnGame = data!!.getParcelableExtra<Game>("GAME")!!
				games.add(returnGame)
				Toast.makeText(this, "Game added", Toast.LENGTH_SHORT).show()
			}
		}
	}
}