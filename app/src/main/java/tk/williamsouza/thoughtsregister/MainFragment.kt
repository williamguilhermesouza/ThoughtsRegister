package tk.williamsouza.thoughtsregister

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tk.williamsouza.thoughtsregister.adapters.ThoughtListAdapter
import tk.williamsouza.thoughtsregister.databinding.FragmentMainBinding
import tk.williamsouza.thoughtsregister.models.Thought
import tk.williamsouza.thoughtsregister.room.AppDatabase
import kotlin.collections.ArrayList


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var thoughtsAdapter: ThoughtListAdapter
    private var data: List<Thought> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.newThoughtActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_viewPagerFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        addDataSet()
    }

    private fun initRecyclerView() {
        val thoughtsView = binding.thoughtsRecyclerView
        thoughtsView.layoutManager = LinearLayoutManager(this.context)

        thoughtsView.adapter = thoughtsAdapter
    }

    private fun addDataSet() {
        val db = Room.databaseBuilder(
            requireContext().applicationContext,
            AppDatabase::class.java, "thoughts"
        ).build()

        CoroutineScope(IO).launch {
            val data = db.thoughtDao().getAll()
            withContext(Main){
                setData(data)
                thoughtsAdapter.submitList(data)
                if (data.isNotEmpty()) {
                    binding.emptyListText.visibility = View.INVISIBLE
                }
                thoughtsAdapter.notifyDataSetChanged()
            }
        }




    }

    private fun setData(_data: List<Thought>) {
        data = _data
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        thoughtsAdapter = ThoughtListAdapter()

        thoughtsAdapter.notifyDataSetChanged()
    }


}