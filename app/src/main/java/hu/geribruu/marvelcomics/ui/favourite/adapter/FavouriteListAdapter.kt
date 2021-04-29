package hu.geribruu.marvelcomics.ui.favourite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.geribruu.marvelcomics.R
import hu.geribruu.marvelcomics.data.model.CharacterDataModel
import kotlinx.android.synthetic.main.layout_favourite_item.view.*
import kotlinx.android.synthetic.main.layout_home_item.view.*

class FavouriteListAdapter : ListAdapter<CharacterDataModel, FavouriteListAdapter.FavouriteViewHolder>(CHARACTER_COMPARATOR) {

    private lateinit var current : CharacterDataModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        return FavouriteViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        current = getItem(position)
        holder.bind(current, position)
    }


    class FavouriteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        private val tvCharacterName : TextView = itemView.textview_favourite_name

        fun bind(marvelCharacter: CharacterDataModel, position: Int){
            tvCharacterName.text = marvelCharacter.name

          /*  itemView.setOnClickListener {
                onClick.onClickHomeList(marvelCharacter.id.toString())
            }*/
        }

        companion object {
            fun create(parent: ViewGroup): FavouriteViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_favourite_item, parent, false)
                return FavouriteViewHolder(view)
            }
        }
    }

    companion object {
        private val CHARACTER_COMPARATOR = object : DiffUtil.ItemCallback<CharacterDataModel>() {
            override fun areItemsTheSame(oldItem: CharacterDataModel, newItem: CharacterDataModel): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: CharacterDataModel, newItem: CharacterDataModel): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}