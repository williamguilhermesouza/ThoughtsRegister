package tk.williamsouza.thoughtsregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tk.williamsouza.thoughtsregister.databinding.ActivityActivatingEventBinding

class ActivatingEventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActivatingEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivatingEventBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.forwardButton.setOnClickListener {
            val intent = Intent(this, ThoughtActivity::class.java)
            startActivity(intent)
        }
    }
}