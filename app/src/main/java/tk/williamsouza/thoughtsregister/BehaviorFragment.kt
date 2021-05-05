package tk.williamsouza.thoughtsregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import tk.williamsouza.thoughtsregister.databinding.FragmentActivatingEventBinding
import tk.williamsouza.thoughtsregister.databinding.FragmentBehaviorBinding

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
            val action = BehaviorFragmentDirections.actionBehaviorFragmentToMainFragment2()
            findNavController().navigate(action)
        }

        val view = binding.root
        return view
    }
}