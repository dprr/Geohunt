package com.example.geohunt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class WelcomePage : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_welcome_page)
	}

	fun onClickPlayButton(view: View){

	}

	fun onClickCreateButton(view: View){
		val intent = Intent(this, CreateGameActivity::class.java)
		startActivity(intent)
	}
}