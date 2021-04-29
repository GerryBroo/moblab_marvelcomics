package hu.geribruu.marvelcomics.ui.character

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import hu.geribruu.marvelcomics.R
import kotlinx.android.synthetic.main.activity_character_detail.*

@AndroidEntryPoint
class CharacterDetailActivity : AppCompatActivity() {

    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        viewModel.showTextDataNotifier.observe(this, { data ->
            tv_character_dy.text = data
        })
    }
}