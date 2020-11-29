package com.example.geohunt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CreateLocationActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_create_location)
	}

	fun onClickAddLocation(view: View){
//      TODO get location properly
		val x_cord = 0.0
		val y_cord = 0.0
		val cord = Location(x_cord, y_cord)
		val intent = Intent()
		intent.putExtra("CORD", cord)
		setResult(Activity.RESULT_OK, intent)
		finish()
	}
}
