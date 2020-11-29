package com.example.geohunt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_create_game.*

class CreateGameActivity : AppCompatActivity() {
	private val CREATE_LOCATION_REQUEST_CODE = 1

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
		val intent = Intent()
		intent.putExtra("GAME", newGame)
		setResult(Activity.RESULT_OK, intent)
		finish()
	}

	fun onClickAddLocation(view: View){
		val intent = Intent(this, CreateLocationActivity::class.java)
		startActivityForResult(intent, CREATE_LOCATION_REQUEST_CODE)
	}

	// This method is called when the second activity finishes
	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)

		// Check that it is the CreateLocationActivity with an OK result
		if (requestCode == CREATE_LOCATION_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
				// Get location data from Intent
				val returnLocation = data!!.getParcelableExtra<Location>("CORD")!!
				locations.add(returnLocation)
				Toast.makeText(this, "Location added", Toast.LENGTH_SHORT).show()
				locationsRecyclerView.adapter!!.notifyItemInserted(locations.size - 1)
			}
		}
	}

}