package tk.williamsouza.thoughtsregister

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tk.williamsouza.thoughtsregister.adapters.ThoughtListAdapter
import tk.williamsouza.thoughtsregister.databinding.FragmentMainBinding
import tk.williamsouza.thoughtsregister.models.Thought
import tk.williamsouza.thoughtsregister.room.AppDatabase
import java.time.LocalDateTime
import java.util.*
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
    ): View? {
        binding.newThoughtActionButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragment2ToActivatingEventFragment()
            NavigationActivity.navStack = ActivatingEventFragment::class.java.name
            findNavController().navigate(action)
        }

        val view = binding.root
        return view
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        addDataSet()
    }

    private fun initRecyclerView() {
        val thoughtsView = binding.thoughtsRecyclerView
        thoughtsView.layoutManager = LinearLayoutManager(this.context)
        thoughtsAdapter = ThoughtListAdapter()
        thoughtsView.adapter = thoughtsAdapter
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addDataSet() {
        //val data = arrayListOf<Thought>(Thought(0, LocalDateTime.now().toString(), "evento", "thought", "feeling", "behavior"),
        //    Thought(1, LocalDateTime.now().toString(), "eventoasd", "thasdought", "feeasdasling", "behasdavior"))
        val db = Room.databaseBuilder(
            requireContext().applicationContext,
            AppDatabase::class.java, "thoughts"
        ).build()

        CoroutineScope(IO).launch {
            val data = db.thoughtDao().getAll()
            withContext(Main){
                setData(data)
            }
        }

        thoughtsAdapter.submitList(data)

    }

    private fun setData(_data: List<Thought>) {
        data = _data
    }


}