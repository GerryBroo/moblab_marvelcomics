package hu.geribruu.marvelcomics.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import hu.geribruu.marvelcomics.R
import hu.geribruu.marvelcomics.ui.favourite.adapter.FavouriteListAdapter
import hu.geribruu.marvelcomics.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_favourite.*
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class FavouriteFragment : Fragment() {

    private val viewModel : FavouriteViewModel by viewModels()
    private lateinit var adapter: FavouriteListAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycleView()
    }

    private fun setupRecycleView() {
        adapter = FavouriteListAdapter()
        recyclerview_favourite.adapter = adapter
        recyclerview_favourite.layoutManager = LinearLayoutManager(context)

        activity?.let { activity ->
            viewModel.characters.observe(activity, Observer { character ->
                character.let { adapter.submitList(it) }
            } )
        }
    }
}