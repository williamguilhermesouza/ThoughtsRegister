package tk.williamsouza.thoughtsregister.newthought

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tk.williamsouza.thoughtsregister.adapters.ViewPagerAdapter
import tk.williamsouza.thoughtsregister.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(layoutInflater)
        val view = binding.root

        val fragmentList = arrayListOf(
            ActivatingEventFragment(),
            ThoughtFragment(),
            FeelingFragment(),
            BehaviorFragment()
        )

        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        binding.navigationViewPager.adapter = adapter

        return view
    }

}