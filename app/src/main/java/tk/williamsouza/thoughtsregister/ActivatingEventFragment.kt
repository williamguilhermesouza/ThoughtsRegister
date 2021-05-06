package tk.williamsouza.thoughtsregister

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import tk.williamsouza.thoughtsregister.databinding.FragmentActivatingEventBinding

class ActivatingEventFragment : Fragment() {
    private lateinit var binding: FragmentActivatingEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentActivatingEventBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewPager = activity?.findViewById<ViewPager2>(R.id.navigationViewPager)

        binding.backButton.setOnClickListener {
            viewPager?.currentItem = 0
        }

        binding.forwardButton.setOnClickListener {
            viewPager?.currentItem = 2
        }

        viewPager?.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            saveInputToSharedPref()
        }

        val view = binding.root
        return view
    }

    private fun saveInputToSharedPref() {
        val sharedPref = requireActivity().getSharedPreferences("thought", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("activatingEvent", binding.activatingEventInput.text.toString())
        editor.apply()
    }
}