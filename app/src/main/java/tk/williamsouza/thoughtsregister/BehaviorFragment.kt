package tk.williamsouza.thoughtsregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import tk.williamsouza.thoughtsregister.databinding.FragmentActivatingEventBinding
import tk.williamsouza.thoughtsregister.databinding.FragmentBehaviorBinding
import tk.williamsouza.thoughtsregister.room.AppDatabase

class BehaviorFragment : Fragment() {
    private lateinit var binding: FragmentBehaviorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentBehaviorBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.saveThoughtButton.setOnClickListener {
            val activatingEvent = arguments?.getString("activatingEvent")
            val thought = arguments?.getString("thought")
            val feeling = arguments?.getString("feeling")
            val behavior = binding.behaviorInput.text.toString()

            val db = Room.databaseBuilder(
                requireContext().applicationContext,
                AppDatabase::class.java, "thoughts"
            ).build()

            println("event: $activatingEvent \n thought: $thought \n feeling: $feeling \n behavior: $behavior \n")
            val action = BehaviorFragmentDirections.actionBehaviorFragmentToMainFragment2()
            NavigationActivity.navStack = MainFragment::class.java.name
            findNavController().navigate(action)
        }

        val view = binding.root
        return view
    }
}