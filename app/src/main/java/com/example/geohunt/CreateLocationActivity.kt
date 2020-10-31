package com.example.geohunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CreateLocationActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_create_location)
	}

	fun onClickAddLocation(view: View){
//      TODO save location

//       finish activity and go back to previous screen
		finish()
	}
}