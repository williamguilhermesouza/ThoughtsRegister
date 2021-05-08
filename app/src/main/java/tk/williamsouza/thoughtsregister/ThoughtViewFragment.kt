package tk.williamsouza.thoughtsregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tk.williamsouza.thoughtsregister.databinding.FragmentThoughtViewBinding
import tk.williamsouza.thoughtsregister.room.AppDatabase

class ThoughtViewFragment : Fragment() {
  private lateinit var binding: FragmentThoughtViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentThoughtViewBinding.inflate(layoutInflater)

        binding.dateView.text = requireArguments().getString("date")

        binding.eventView.text = requireArguments().getString("activatingEvent")

        binding.thoughtView.text = requireArguments().getString("thought")

        binding.feelingView.text = requireArguments().getString("feeling")

        binding.behaviorView.text = requireArguments().getString("behavior")


        binding.backArrowButton.setOnClickListener {
            findNavController().navigate(R.id.action_thoughtViewFragment_to_mainFragment)
        }

        val db = Room.databaseBuilder(
            requireContext().applicationContext,
            AppDatabase::class.java, "thoughts"
        ).build()

        binding.deleteButton.setOnClickListener {
            CoroutineScope(IO).launch {
                db.thoughtDao().delete(requireArguments().getInt("id"))
                withContext(Main) {
                    findNavController().navigate(R.id.action_thoughtViewFragment_to_mainFragment)
                }
            }
        }

        return binding.root
    }

}