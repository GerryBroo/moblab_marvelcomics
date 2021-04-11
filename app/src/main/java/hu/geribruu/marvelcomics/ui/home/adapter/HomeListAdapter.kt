package hu.geribruu.marvelcomics.ui.home.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.geribruu.marvelcomics.data.model.CharacterDataModel

class HomeListAdapter : ListAdapter<CharacterDataModel, HomeListAdapter.HomeViewHolder>(CHARACTER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    class HomeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

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