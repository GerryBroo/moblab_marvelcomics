package hu.geribruu.marvelcomics.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.geribruu.marvelcomics.R
import hu.geribruu.marvelcomics.model.MarvelCharacter
import hu.geribruu.marvelcomics.network.model.CharacterNet
import kotlinx.android.synthetic.main.layout_home_item.view.*

class HomeListAdapter(private val onClick: HomeListClickListener) :
        ListAdapter<CharacterNet, HomeListAdapter.HomeViewHolder>(CHARACTER_COMPARATOR) {

    private lateinit var current : CharacterNet

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.create(parent, onClick)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        current = getItem(position)
        holder.bind(current, position)
    }


    class HomeViewHolder(itemView : View, private val onClick: HomeListClickListener) : RecyclerView.ViewHolder(itemView) {

        private val tvCharacterName : TextView = itemView.textview_home_name

        fun bind(marvelCharacter: CharacterNet, position: Int){
            tvCharacterName.text = marvelCharacter.name

            itemView.setOnClickListener {
                onClick.onClickHomeList(marvelCharacter.id.toString())
            }
        }

        companion object {
            fun create(parent: ViewGroup, onClick: HomeListClickListener): HomeViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_home_item, parent, false)
                return HomeViewHolder(view, onClick)
            }
        }
    }

    companion object {
        private val CHARACTER_COMPARATOR = object : DiffUtil.ItemCallback<CharacterNet>() {
            override fun areItemsTheSame(oldItem: CharacterNet, newItem: CharacterNet): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: CharacterNet, newItem: CharacterNet): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }

    interface HomeListClickListener {
        fun onClickHomeList(characterId: String)
    }
}