package tk.williamsouza.thoughtsregister.models

import java.util.*

data class Thought(
    val date: Date,
    val activatingEvent: String,
    val thought: String,
    val feeling: String,
    val behavior: String
) {
}