package tk.williamsouza.thoughtsregister.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import tk.williamsouza.thoughtsregister.R
import tk.williamsouza.thoughtsregister.models.Thought
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class ThoughtListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<Thought> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ThoughtsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.thought_list_item, parent, false)
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ThoughtsViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(thoughtsList: List<Thought>) {
        items = thoughtsList
    }

    class ThoughtsViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        val dateView = itemView.findViewById<TextView>(R.id.dateTextView)!!
        private val thoughtView = itemView.findViewById<TextView>(R.id.thoughtTextView)!!
        private val cardView = itemView.findViewById<FrameLayout>(R.id.listItemFrameLayout)!!

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(thought: Thought) {
            val date = LocalDateTime.parse(thought.date)
            dateView.text = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy-hh:mm"))
            thoughtView.text = thought.thought

            cardView.setOnClickListener {
                val bundle = bundleOf(
                    "id" to thought.id,
                    "date" to LocalDateTime.parse(thought.date).format(DateTimeFormatter.ofPattern("dd/MM/yyyy-hh:mm")),
                    "activatingEvent" to thought.activatingEvent,
                    "thought" to thought.thought,
                    "feeling" to thought.feeling,
                    "behavior" to thought.behavior)
                itemView.findNavController().navigate(R.id.action_mainFragment_to_thoughtViewFragment, bundle)
            }
        }
    }


}