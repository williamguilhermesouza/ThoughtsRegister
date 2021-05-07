package tk.williamsouza.thoughtsregister.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import tk.williamsouza.thoughtsregister.R
import tk.williamsouza.thoughtsregister.databinding.FragmentFirstInstructionBinding

class FirstInstructionFragment : Fragment() {
    private lateinit var binding: FragmentFirstInstructionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstInstructionBinding.inflate(layoutInflater)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.onboardingPager)

        binding.button.setOnClickListener {
            viewPager?.currentItem = 1
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}