package hu.geribruu.marvelcomics.ui.favourite.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.geribruu.marvelcomics.data.model.CharacterDataModel
import hu.geribruu.marvelcomics.ui.home.adapter.HomeListAdapter

class FavouriteListAdapter : ListAdapter<CharacterDataModel, FavouriteListAdapter.FavouriteViewHolder>(CHARACTER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    class FavouriteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

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