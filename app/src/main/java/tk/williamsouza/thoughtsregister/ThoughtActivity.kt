package tk.williamsouza.thoughtsregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tk.williamsouza.thoughtsregister.databinding.ActivityActivatingEventBinding
import tk.williamsouza.thoughtsregister.databinding.ActivityThoughtBinding

class ThoughtActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThoughtBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThoughtBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, ActivatingEventActivity::class.java)
            startActivity(intent)
        }

        binding.forwardButton.setOnClickListener {
            val intent = Intent(this, FeelingActivity::class.java)
            startActivity(intent)
        }
    }
}