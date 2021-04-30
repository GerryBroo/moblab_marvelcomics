package hu.geribruu.marvelcomics.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import hu.geribruu.marvelcomics.data.model.CharacterDataModel
import hu.geribruu.marvelcomics.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.Matchers.contains
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.beans.HasPropertyWithValue.hasProperty
import org.junit.Rule


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class FavouriteCharacterDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: FavouriteCharacterDao
    private lateinit var db: FavouriteCharacterRoomDatabase

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                FavouriteCharacterRoomDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = db.favouriteCharacterDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertCharacter() = runBlockingTest {
        val character = CharacterDataModel(id = 1, "0", "spider-man", "amazing")
        dao.insert(character)

        val allcharacter = dao.getAll().asLiveData().getOrAwaitValue()

        assertThat(character).isIn(allcharacter)
    }
}