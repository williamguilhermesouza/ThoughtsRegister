package tk.williamsouza.thoughtsregister.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Thought(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name="date") val date: String,
    @ColumnInfo(name="activatingEvent") val activatingEvent: String,
    @ColumnInfo(name="thought") val thought: String,
    @ColumnInfo(name="feeling") val feeling: String,
    @ColumnInfo(name="behavior") val behavior: String
) {
}