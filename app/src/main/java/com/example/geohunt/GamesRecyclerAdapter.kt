package com.example.geohunt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.game_row.view.*


class GamesRecyclerAdapter(private val gameList: MutableList<Game>): RecyclerView.Adapter<GamesRecyclerAdapter.GamesHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesHolder {
		val layoutInflater = LayoutInflater.from(parent.context).inflate(
			R.layout.game_row,
			parent,
			false
		)
		return GamesHolder(layoutInflater)
	}

	override fun getItemCount() = gameList.size

	override fun onBindViewHolder(holder: GamesHolder, index: Int) {
		val game = gameList[index]
		holder.description.text = game.description
		holder.index.text = index.toString()
	}

	class GamesHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener{
		val description: TextView = v.gameDescription
		val index: TextView = v.gameIndex

		init {
			v.setOnClickListener(this)
		}

		override fun onClick(v: View) {
			// todo, when clicked play a game
//			val intent = Intent(this, PlayGame::class.java)
//			intent.putExtra("gameIndex", index)
//			startActivity(intent)
		}
	}
}
