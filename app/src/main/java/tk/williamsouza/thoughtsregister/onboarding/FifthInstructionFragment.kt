package tk.williamsouza.thoughtsregister.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import tk.williamsouza.thoughtsregister.R
import tk.williamsouza.thoughtsregister.databinding.FragmentFifthInstructionBinding


class FifthInstructionFragment : Fragment() {
    private lateinit var binding: FragmentFifthInstructionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFifthInstructionBinding.inflate(layoutInflater)

        binding.button.setOnClickListener {
            val sharedPref = requireActivity().getSharedPreferences("onboarding", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putBoolean("onboarding", true)
            editor.apply()
            findNavController().navigate(R.id.action_onboardingViewPagerFragment_to_mainFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}