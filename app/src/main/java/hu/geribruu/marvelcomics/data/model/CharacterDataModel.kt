package hu.geribruu.marvelcomics.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterDataModel(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,

    @ColumnInfo(name = "apiId")
    var apiId: String,

    @ColumnInfo(name = "name")
    var name : String,

    @ColumnInfo(name = "description")
    var description: String
)