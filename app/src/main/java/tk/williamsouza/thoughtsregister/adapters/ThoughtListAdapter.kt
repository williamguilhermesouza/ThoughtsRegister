package tk.williamsouza.thoughtsregister.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tk.williamsouza.thoughtsregister.R
import tk.williamsouza.thoughtsregister.models.Thought


class ThoughtListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<Thought> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ThoughtsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.thought_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ThoughtsViewHolder -> {
                holder.bind(items.get(position))
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
        val dateView = itemView.findViewById<TextView>(R.id.dateTextView)
        val thoughtView = itemView.findViewById<TextView>(R.id.thoughtTextView)

        fun bind(thought: Thought) {
            dateView.text = thought.date.toString()
            thoughtView.text = thought.thought
        }
    }


}