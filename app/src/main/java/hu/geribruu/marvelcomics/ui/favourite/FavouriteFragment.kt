package hu.geribruu.marvelcomics.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import hu.geribruu.marvelcomics.R
import hu.geribruu.marvelcomics.ui.home.HomeViewModel

@AndroidEntryPoint
class FavouriteFragment : Fragment() {

   // private lateinit var favouriteViewModel: FavouriteViewModel

    private val viewModel : FavouriteViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
     /*   favouriteViewModel =
                ViewModelProvider(this).get(FavouriteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favourite, container, false)
        val textView: TextView = root.findViewById(R.id.text_favourite)
        favouriteViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }
}