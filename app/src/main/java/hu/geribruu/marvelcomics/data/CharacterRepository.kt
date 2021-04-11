package hu.geribruu.marvelcomics.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(private val characterDao: CharacterDao) {


}