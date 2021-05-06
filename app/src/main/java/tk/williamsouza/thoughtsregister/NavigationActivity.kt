package tk.williamsouza.thoughtsregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import tk.williamsouza.thoughtsregister.adapters.ViewPagerAdapter
import tk.williamsouza.thoughtsregister.databinding.ActivityNavigationBinding

const val DEBUG_TAG = "Debug"


class NavigationActivity : AppCompatActivity(){
    private lateinit var binding: ActivityNavigationBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        val view = binding.root

        val fragmentList = arrayListOf<Fragment>(
            MainFragment(),
            ActivatingEventFragment(),
            ThoughtFragment(),
            FeelingFragment(),
            BehaviorFragment()
        )

        val adapter = ViewPagerAdapter(fragmentList, supportFragmentManager, lifecycle)

        binding.navigationViewPager.adapter = adapter

        setContentView(view)

    }


}