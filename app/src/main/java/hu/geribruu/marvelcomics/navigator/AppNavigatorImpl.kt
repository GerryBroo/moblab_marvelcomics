package hu.geribruu.marvelcomics.navigator

import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import hu.geribruu.marvelcomics.ui.character.CharacterDetailActivity
import hu.geribruu.marvelcomics.ui.character.CharacterViewModel.Companion.CHARACTER_ID
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor(private val activity: FragmentActivity) : AppNavigator {

    override fun navigateToCharacter(characterId: String) {
        val intent = Intent (activity, CharacterDetailActivity::class.java)
        intent.putExtra(CHARACTER_ID, characterId)
        activity.startActivity(intent)
    }
}