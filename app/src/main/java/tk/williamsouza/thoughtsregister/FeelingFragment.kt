package tk.williamsouza.thoughtsregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import tk.williamsouza.thoughtsregister.databinding.FragmentFeelingBinding

class FeelingFragment : Fragment() {
    private lateinit var binding: FragmentFeelingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentFeelingBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.forwardButton.setOnClickListener {
            val action = FeelingFragmentDirections.actionFeelingFragmentToBehaviorFragment()
            findNavController().navigate(action)
        }

        val view = binding.root
        return view
    }
}