package hu.geribruu.marvelcomics.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.geribruu.marvelcomics.R
import hu.geribruu.marvelcomics.model.MarvelCharacter
import kotlinx.android.synthetic.main.layout_home_item.view.*

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var marvelCharacters: MutableList<MarvelCharacter> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_home_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCharacterName.text = marvelCharacters[holder.adapterPosition].name
    }

    override fun getItemCount(): Int = marvelCharacters.size

    fun addAll(marvelCharacters: List<MarvelCharacter>) {
        this.marvelCharacters.addAll(marvelCharacters)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCharacterName : TextView = itemView.textview_home_name
    }
}