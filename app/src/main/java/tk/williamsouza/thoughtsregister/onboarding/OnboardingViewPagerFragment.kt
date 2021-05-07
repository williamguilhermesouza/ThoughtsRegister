package tk.williamsouza.thoughtsregister.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tk.williamsouza.thoughtsregister.adapters.ViewPagerAdapter
import tk.williamsouza.thoughtsregister.databinding.FragmentOnboardingViewPagerBinding

class OnboardingViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentOnboardingViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingViewPagerBinding.inflate(layoutInflater)

        val adapter = ViewPagerAdapter(arrayListOf(
            FirstInstructionFragment(),
            SecondInstructionFragment(),
            ThirdInstructionFragment(),
            FourthInstructionFragment(),
            FifthInstructionFragment()
        ), requireActivity().supportFragmentManager, lifecycle)

        binding.onboardingPager.adapter = adapter
        // Inflate the layout for this fragment
        return binding.root
    }

}