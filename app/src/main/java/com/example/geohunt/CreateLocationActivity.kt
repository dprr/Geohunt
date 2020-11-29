package com.example.geohunt

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_create_location.*

class CreateLocationActivity : AppCompatActivity() {
	private lateinit var fusedLocationClient: FusedLocationProviderClient
	private val REQUEST_CODE = 2

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_create_location)
		fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
	}

	fun onClickAddLocation(view: View){

		if (ActivityCompat.checkSelfPermission(
				this,
				Manifest.permission.ACCESS_FINE_LOCATION
			) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
				this,
				Manifest.permission.ACCESS_COARSE_LOCATION
			) != PackageManager.PERMISSION_GRANTED
		) {
			ActivityCompat.requestPermissions(
				this,
				arrayOf(
					Manifest.permission.ACCESS_FINE_LOCATION,
					Manifest.permission.ACCESS_COARSE_LOCATION
				),
				REQUEST_CODE
			);
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			return
		}
		fusedLocationClient.lastLocation
			.addOnSuccessListener { location->
				if (location != null) {
					val latitude = location.latitude
					val longitude = location.longitude
					val description = nameET.text.toString()
					val cord = Location(latitude, longitude, description)
					val intent = Intent()
					intent.putExtra("CORD", cord)
					setResult(Activity.RESULT_OK, intent)
					finish()
				}

			}
	}

	override fun onRequestPermissionsResult(
		requestCode: Int,
		permissions: Array<out String>,
		grantResults: IntArray
	) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults)
		when (requestCode) {
			REQUEST_CODE ->
				if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					//permission granted. No need to do anything
				} else {
					Toast.makeText(applicationContext, "This app requires location permissions to be granted", Toast.LENGTH_SHORT).show()
					finish()
				}
		}
	}
}
