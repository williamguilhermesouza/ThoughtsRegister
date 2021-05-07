package tk.williamsouza.thoughtsregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tk.williamsouza.thoughtsregister.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity(){
    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

    }


}