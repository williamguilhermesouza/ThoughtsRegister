package tk.williamsouza.thoughtsregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tk.williamsouza.thoughtsregister.databinding.FragmentThoughtViewBinding

class ThoughtViewFragment : Fragment() {
  private lateinit var binding: FragmentThoughtViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentThoughtViewBinding.inflate(layoutInflater)
        return binding.root
    }

}