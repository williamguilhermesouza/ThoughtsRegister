package tk.williamsouza.thoughtsregister.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import tk.williamsouza.thoughtsregister.models.Thought

@Dao
interface ThoughtDao{
    @Query("SELECT * FROM thought")
    fun getAll(): List<Thought>

    @Query("SELECT * FROM thought WHERE id = (:thoughtId)")
    suspend fun getById(thoughtId: Int): Thought

    @Insert
    suspend fun insertAll(vararg thoughts: Thought)

    @Delete
    suspend fun delete(thought: Thought)
}