package hu.geribruu.marvelcomics.ui.character

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hu.geribruu.marvelcomics.R
import hu.geribruu.marvelcomics.network.model.CharacterNet
import hu.geribruu.marvelcomics.ui.character.adapter.ComicsListAdapter
import kotlinx.android.synthetic.main.activity_character_detail.*

@AndroidEntryPoint
class CharacterDetailActivity : AppCompatActivity() {

    private val viewModel: CharacterViewModel by viewModels()

    private lateinit var currentCharacter : CharacterNet
    private lateinit var adapter : ComicsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        setupRecycleView()

        viewModel.characterLiveData.observe(this, { data ->
            currentCharacter = data
            tv_character_dy.text = data.name
            tv_desc_dy.text = data.description

            adapter.submitList(data.comicsList.items)
        })

        btn_favourite.setOnClickListener {
            viewModel.insertToDatabase(currentCharacter)
            Toast.makeText(applicationContext, "Adding to Favourite", Toast.LENGTH_LONG).show()
        }

    }

    private fun setupRecycleView() {
        adapter = ComicsListAdapter()
        recyclerview_comics.adapter = adapter
        recyclerview_comics.layoutManager = LinearLayoutManager(baseContext)
    }
}