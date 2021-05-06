package tk.williamsouza.thoughtsregister

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import tk.williamsouza.thoughtsregister.adapters.ThoughtListAdapter
import tk.williamsouza.thoughtsregister.databinding.FragmentMainBinding
import tk.williamsouza.thoughtsregister.models.Thought
import java.time.LocalDateTime
import java.util.*


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var thoughtsAdapter: ThoughtListAdapter

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
        val data = arrayListOf<Thought>(Thought(0, LocalDateTime.now().toString(), "evento", "thought", "feeling", "behavior"),
            Thought(1, LocalDateTime.now().toString(), "eventoasd", "thasdought", "feeasdasling", "behasdavior"))
        thoughtsAdapter.submitList(data)

    }


}