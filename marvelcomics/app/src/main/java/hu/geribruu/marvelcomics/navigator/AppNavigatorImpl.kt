package hu.geribruu.marvelcomics.navigator

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import hu.geribruu.marvelcomics.data.model.CharacterDataModel
import hu.geribruu.marvelcomics.ui.character.CharacterDetailActivity
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor(private val activity: FragmentActivity) : AppNavigator {

    override fun navigateToCharacter(characterDataModel: CharacterDataModel) {


        val intent = Intent (activity, CharacterDetailActivity::class.java)
        activity.startActivity(intent)
    }
}