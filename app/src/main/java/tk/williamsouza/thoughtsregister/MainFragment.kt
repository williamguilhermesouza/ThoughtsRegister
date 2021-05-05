package tk.williamsouza.thoughtsregister

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import tk.williamsouza.thoughtsregister.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

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



}