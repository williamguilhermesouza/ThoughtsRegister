package tk.williamsouza.thoughtsregister

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import tk.williamsouza.thoughtsregister.databinding.FragmentActivatingEventBinding
import tk.williamsouza.thoughtsregister.databinding.FragmentBehaviorBinding
import tk.williamsouza.thoughtsregister.models.Thought
import tk.williamsouza.thoughtsregister.room.AppDatabase
import java.time.LocalDateTime

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
            val activatingEvent = arguments?.getString("activatingEvent")
            val thought = arguments?.getString("thought")
            val feeling = arguments?.getString("feeling")
            val behavior = binding.behaviorInput.text.toString()

            val db = Room.databaseBuilder(
                requireContext().applicationContext,
                AppDatabase::class.java, "thoughts"
            ).build()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CoroutineScope(IO).launch {
                    db.thoughtDao().insertAll(Thought( date=LocalDateTime.now().toString(), activatingEvent = activatingEvent!!, thought = thought!!, feeling = feeling!!, behavior = behavior))
                }
            }

            println("event: $activatingEvent \n thought: $thought \n feeling: $feeling \n behavior: $behavior \n")
            val action = BehaviorFragmentDirections.actionBehaviorFragmentToMainFragment2()
            NavigationActivity.navStack = MainFragment::class.java.name
            findNavController().navigate(action)
        }

        val view = binding.root
        return view
    }
}