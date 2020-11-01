package com.example.geohunt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.waypoint_row.view.*

class WaypointRecyclerAdapter(private val locationList: MutableList<Location>): RecyclerView.Adapter<WaypointRecyclerAdapter.WaypointHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaypointHolder {
		val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.waypoint_row, parent,false)
		return WaypointHolder(layoutInflater)
	}

	override fun getItemCount() = locationList.size

	override fun onBindViewHolder(holder: WaypointHolder, index: Int) {
		val location = locationList[index]
		holder.description.text = location.toString()
	}

	class WaypointHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener{
		val description: TextView = v.waypointDescription

		init {
			v.setOnClickListener(this)
		}

		override fun onClick(v: View) {
			// todo remove the waypoint if clicked
		}
	}
}
