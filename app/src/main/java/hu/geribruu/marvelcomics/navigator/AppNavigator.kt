package hu.geribruu.marvelcomics.navigator

import hu.geribruu.marvelcomics.network.model.CharacterNet

interface AppNavigator {

    fun navigateToCharacter(characterId: Long)
}