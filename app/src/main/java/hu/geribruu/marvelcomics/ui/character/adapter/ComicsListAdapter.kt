package hu.geribruu.marvelcomics.ui.character.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.geribruu.marvelcomics.R
import hu.geribruu.marvelcomics.network.model.ComicsSummary
import kotlinx.android.synthetic.main.layout_comics_item.view.*

class ComicsListAdapter : ListAdapter<ComicsSummary, ComicsListAdapter.ComicsViewHolder>(COMICS_COMPARATOR) {

    private lateinit var current : ComicsSummary

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return ComicsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        current = getItem(position)
        holder.bind(current, position)
    }

    class ComicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvComicsName : TextView = itemView.tv_comics_name

        fun bind(comics: ComicsSummary, position: Int) {
            tvComicsName.text = comics.name
        }

        companion object {
            fun create(parent: ViewGroup) : ComicsViewHolder {
                val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_comics_item, parent, false)
                return ComicsViewHolder(view)
            }
        }
    }

    companion object {
        private val COMICS_COMPARATOR = object : DiffUtil.ItemCallback<ComicsSummary>() {
            override fun areItemsTheSame(oldItem: ComicsSummary, newItem: ComicsSummary): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: ComicsSummary, newItem: ComicsSummary): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}
