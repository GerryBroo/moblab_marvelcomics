package hu.geribruu.marvelcomics.ui.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import hu.geribruu.marvelcomics.R

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var characterViewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        characterViewModel =
            ViewModelProvider(this).get(CharacterViewModel::class.java)

    }
}