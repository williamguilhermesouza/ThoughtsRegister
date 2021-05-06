package tk.williamsouza.thoughtsregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import tk.williamsouza.thoughtsregister.databinding.FragmentThoughtBinding

class ThoughtFragment : Fragment() {
    private lateinit var binding: FragmentThoughtBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentThoughtBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.forwardButton.setOnClickListener {
            val thought = binding.thoughtInput.text.toString()
            val activatingEvent = arguments?.getString("activatingEvent")
            val bundle = bundleOf("activatingEvent" to activatingEvent, "thought" to thought)
            findNavController().navigate(R.id.action_thoughtFragment_to_feelingFragment, bundle)
        }

        val view = binding.root
        return view
    }
}