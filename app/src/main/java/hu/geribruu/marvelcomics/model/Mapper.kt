package hu.geribruu.marvelcomics.model

import hu.geribruu.marvelcomics.network.model.CharacterNet

fun CharacterNet.toMarvelCharacter(): hu.geribruu.marvelcomics.model.MarvelCharacter {
    return hu.geribruu.marvelcomics.model.MarvelCharacter(id.toLong(), name, "")
}