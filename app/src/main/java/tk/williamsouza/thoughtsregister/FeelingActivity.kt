package tk.williamsouza.thoughtsregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tk.williamsouza.thoughtsregister.databinding.ActivityActivatingEventBinding
import tk.williamsouza.thoughtsregister.databinding.ActivityFeelingBinding

class FeelingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeelingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeelingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, ThoughtActivity::class.java)
            startActivity(intent)
        }

        binding.forwardButton.setOnClickListener {
            val intent = Intent(this, BehaviorActivity::class.java)
            startActivity(intent)
        }
    }
}