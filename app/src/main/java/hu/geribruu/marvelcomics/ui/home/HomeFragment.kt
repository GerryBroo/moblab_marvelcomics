package hu.geribruu.marvelcomics.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hu.geribruu.marvelcomics.R
import hu.geribruu.marvelcomics.model.toMarvelCharacter
import hu.geribruu.marvelcomics.navigator.AppNavigator
import hu.geribruu.marvelcomics.ui.character.CharacterDetailActivity
import hu.geribruu.marvelcomics.ui.home.adapter.HomeListAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeListAdapter.HomeListClickListener {

    @Inject lateinit var navigator: AppNavigator

    private val viewModel : HomeViewModel by viewModels()
    private lateinit var adapter: HomeListAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
       /* homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycleView()
    }

    private fun setupRecycleView() {
        adapter = HomeListAdapter(this)
        recyclerview_home.adapter = adapter
        recyclerview_home.layoutManager = LinearLayoutManager(context)

        activity?.let { activity ->
            viewModel.characters.observe(activity, Observer { character ->
                character.data.results.let { adapter.submitList(it.asList()) }
            } )
        }
    }

    override fun onClickHomeList() {
        startActivity(
            Intent(context, CharacterDetailActivity()::class.java).apply {

            }
        )
    }
}