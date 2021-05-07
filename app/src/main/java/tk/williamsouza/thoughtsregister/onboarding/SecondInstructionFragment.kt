package tk.williamsouza.thoughtsregister.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import tk.williamsouza.thoughtsregister.R
import tk.williamsouza.thoughtsregister.databinding.FragmentSecondInstructionBinding

class SecondInstructionFragment : Fragment() {
    private lateinit var binding: FragmentSecondInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSecondInstructionBinding.inflate(layoutInflater)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.onboardingPager)

        binding.button.setOnClickListener {
            viewPager?.currentItem = 2
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}