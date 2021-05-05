package tk.williamsouza.thoughtsregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tk.williamsouza.thoughtsregister.databinding.ActivityActivatingEventBinding
import tk.williamsouza.thoughtsregister.databinding.ActivityBehaviorBinding

class BehaviorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBehaviorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBehaviorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, FeelingActivity::class.java)
            startActivity(intent)
        }

        binding.saveThoughtButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}