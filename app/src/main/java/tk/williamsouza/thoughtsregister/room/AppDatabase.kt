package tk.williamsouza.thoughtsregister.room

import androidx.room.Database
import androidx.room.RoomDatabase
import tk.williamsouza.thoughtsregister.models.Thought

@Database(entities = arrayOf(Thought::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun  thoughtDao(): ThoughtDao
}