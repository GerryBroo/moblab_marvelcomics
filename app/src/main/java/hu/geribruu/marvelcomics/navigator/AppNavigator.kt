package hu.geribruu.marvelcomics.navigator

import hu.geribruu.marvelcomics.data.model.CharacterDataModel

interface AppNavigator {

    fun navigateToCharacter(characterDataModel: CharacterDataModel)
}