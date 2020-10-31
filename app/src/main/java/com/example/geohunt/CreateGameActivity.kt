package com.example.geohunt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CreateGameActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_create_game)
	}

	fun onClickAddGame(view: View){

	}

	fun onClickAddLocation(view: View){
		val intent = Intent(this, CreateLocationActivity::class.java)
		startActivity(intent)
	}
}